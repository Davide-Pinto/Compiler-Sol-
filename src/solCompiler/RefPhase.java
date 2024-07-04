package solCompiler;

import Sol.SolBaseListener;
import Sol.SolParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import solCompiler.SymbolTable.CheckSymbols;
import solCompiler.SymbolTable.FunctionSymbol;
import solCompiler.SymbolTable.Scope;
import solCompiler.SymbolTable.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RefPhase extends SolBaseListener {
    public ParseTreeProperty<String> types = new ParseTreeProperty<>();

    public CheckType rules = new CheckType();
    public ParseTreeProperty<Scope> scopes;
    public Scope global;
    private Scope currentScope;
    private boolean hasReturn;

    FunctionSymbol currentFunction;
    public int error = 0;

    int loopnumber = 0;

    public RefPhase(Scope global, ParseTreeProperty<Scope> scopes){
        this.scopes = scopes;
        this.global = global;
    }

    public void enterProg(SolParser.ProgContext ctx) {
        currentScope = global;
    }
    public void exitProg(SolParser.ProgContext ctx) {
        error += rules.error;
    }

    private void performFunctionCallChecks(Token token, String functionName, ArrayList<Symbol> arguments, List<SolParser.ExprContext> exprContexts) {
        Symbol sym = currentScope.resolve(functionName);
        FunctionSymbol function = currentScope.getFuctionSymbol(functionName);
        int numberOfArguments = function.get_arguments().size();

        if (!(sym instanceof FunctionSymbol)) {
            CheckSymbols.error(token, " error: " + functionName + " is not a function");
            error++;
        }

        if (exprContexts.size() != numberOfArguments) {
            CheckSymbols.error(token, " error: " + functionName + " has " + numberOfArguments + " arguments not " + exprContexts.size());
            error++;
        }

        for (int i = 0; i < numberOfArguments; i++) {
            if (exprContexts.size() == numberOfArguments && !Objects.equals(types.get(exprContexts.get(i)), arguments.get(i).getType())) {
                CheckSymbols.error(token, " error: '" + exprContexts.get(i).getText() + "' is type " + types.get(exprContexts.get(i)) + " but type " + arguments.get(i).getType() + " expected");
                error++;
            }
        }
    }

    public void exitCallStmt(SolParser.CallStmtContext ctx) {
        String functionName = ctx.VARNAME().getText();
        FunctionSymbol function = currentScope.getFuctionSymbol(functionName);

        if (function != null) {
            ArrayList<Symbol> arguments = function.get_arguments();
            performFunctionCallChecks(ctx.start, functionName, arguments, ctx.expr());
            if (!(ctx.parent instanceof SolParser.VarDeclarationContext) && !(ctx.parent instanceof SolParser.VarChangeContext) && !function.getType().equals("void")) {
                CheckSymbols.error(ctx.start, " error: " + "value of '" + functionName + "' should be assigned to a variable");
                error++;
            }
            types.put(ctx, function.getType());
        }
        else
            types.put(ctx, "invalid");
    }

    public void exitCallExpr(SolParser.CallExprContext ctx) {
        String functionName = ctx.VARNAME().getText();
        FunctionSymbol function = currentScope.getFuctionSymbol(functionName);
        if (function != null) {
            ArrayList<Symbol> arguments = function.get_arguments();
            performFunctionCallChecks(ctx.start, functionName, arguments, ctx.expr());
            types.put(ctx, function.getType());
        }
        else
            types.put(ctx, "invalid");
    }


    public void enterReturn(SolParser.ReturnContext ctx) {
        hasReturn = true;
        types.put(ctx,"ignore");
    }

    public void enterFunctionDeclaration(SolParser.FunctionDeclarationContext ctx) {
        hasReturn = false;
        currentFunction = currentScope.getFuctionSymbol(ctx.VARNAME().getText());
        types.put(ctx,"ignore");
    }
    public void exitFunctionDeclaration(SolParser.FunctionDeclarationContext ctx) {
        if(!hasReturn && !currentFunction.getType().equals("void")){
            CheckSymbols.error(ctx.stop, " error: missing return in function " + currentFunction.lexeme());
            error++;
        }
        types.put(ctx,"ignore");
    }

    public void enterFormalParameters(SolParser.FormalParametersContext ctx) {
        types.put(ctx,"ignore");
    }

    public void enterFormalParameter(SolParser.FormalParameterContext ctx) {
        types.put(ctx,"ignore");
    }


    public void exitVarChange(SolParser.VarChangeContext ctx) {
        Symbol sym = currentScope.resolve(ctx.VARNAME().getText());
        if(sym == null){
            types.put(ctx, "invalid");
            CheckSymbols.error(ctx.start, " error: Variable '" + ctx.VARNAME().getText() + "' is not defined");
            error++;
        }else {
            rules.checkOperation("=", sym.getType(), types.get(ctx.expr()), ctx.start);
            types.put(ctx, sym.getType());
        }

    }

    public void enterBlock(SolParser.BlockContext ctx) {
        currentScope = scopes.get(ctx);
    }
    public void exitBlock(SolParser.BlockContext ctx) {
        currentScope = currentScope.getEnclosingScope();
        types.put(ctx,"ignore");
    }
    public void exitPrint(SolParser.PrintContext ctx) {
        types.put(ctx, types.get(ctx.expr()));
    }

    public void enterWhile(SolParser.WhileContext ctx) {
        loopnumber++;
    }

    public void exitWhile(SolParser.WhileContext ctx) {
        String exprType = types.get(ctx.expr());
        if (exprType == null || !exprType.equals("bool")) {
            CheckSymbols.error(ctx.start, " error: while expression must be of type bool");
            error++;
        }
        loopnumber--;
        types.put(ctx, "ignore");
    }

    public void enterFor(SolParser.ForContext ctx) {
        loopnumber++;
    }
    public void exitFor(SolParser.ForContext ctx) {
        Symbol sym = currentScope.resolve(ctx.VARNAME().getText());
        String controlExpressionOne = types.get(ctx.expr(0));
        String controlExpressionTwo = types.get(ctx.expr(1));

        if (sym == null) {
            CheckSymbols.error(ctx.start, " error: Variable '" + ctx.VARNAME().getText() + "' is not defined");
            error++;
        } else if (!sym.getType().equals("int")) {
            CheckSymbols.error(ctx.start, " error: Identifier in 'for' loop must be of type int, '" + ctx.VARNAME().getText() + "' it's type " + sym.getType());
            error++;
        }
        if (!controlExpressionOne.equals("int") || !controlExpressionTwo.equals("int")) {
            CheckSymbols.error(ctx.start, " error: Control Expressions in 'for' loop must be of type int");
            error++;
        }
        loopnumber--;
        types.put(ctx, "ignore");
    }

    public void exitVarDeclaration(SolParser.VarDeclarationContext ctx) {
        if (ctx.expr() != null) {
            Symbol sym = currentScope.resolve(ctx.VARNAME().getText());
            rules.checkOperation("=", sym.getType(), types.get(ctx.expr()), ctx.start);
        }
        types.put(ctx, "ignore");
    }

    public void exitIfElse(SolParser.IfElseContext ctx) {
        String exprType = types.get(ctx.expr());
        if (exprType != null && !exprType.equals("bool")) { //checks if control expression is type bool
            CheckSymbols.error(ctx.start, " error: 'if' expression must be of type bool");
            error++;
        }
        types.put(ctx, "ignore");
    }
    public void exitBreak(SolParser.BreakContext ctx) {
        if (loopnumber == 0) {
            CheckSymbols.error(ctx.start, " error: break statement can only occur inside a loop");
            error++;
        }
        types.put(ctx, "ignore");
    }

    public void exitVar(SolParser.VarContext ctx) {
        String name = ctx.VARNAME().getSymbol().getText();
        Symbol var = currentScope.resolve(name);
        if(var == null){
            CheckSymbols.error(ctx.VARNAME().getSymbol(), " error: no such variable: " + name);
            error++;
            types.put(ctx, "invalid");
        }else{
            types.put(ctx, var.getType());
        }
        if( var instanceof FunctionSymbol){
            CheckSymbols.error(ctx.VARNAME().getSymbol(), " error: " + name + " is not a variable");
            error++;
            types.put(ctx, "invalid");
        }
    }

    public void exitInt(SolParser.IntContext ctx) {
        types.put(ctx,"int");
    }

    public void exitString(SolParser.StringContext ctx) {
        types.put(ctx,"string");
    }

    public void exitDouble(SolParser.DoubleContext ctx) {
        types.put(ctx,"real");
    }

    public void exitBool(SolParser.BoolContext ctx) {
        types.put(ctx, "bool");
    }
    public void exitParentheses(SolParser.ParenthesesContext ctx) {
        types.put(ctx,types.get(ctx.expr()));
    }

    
    public void exitMinus(SolParser.MinusContext ctx) {
        String value = types.get(ctx.expr());
        String operation_type = rules.getResultType("-",value, ctx.start);
        types.put(ctx,operation_type);
    }

    public void exitMult(SolParser.MultContext ctx) {
        String operation_type = rules.getResultType("*",types.get(ctx.expr(0)),types.get(ctx.expr(1)),ctx.start);
        types.put(ctx,operation_type);
    }

    public void exitAdd(SolParser.AddContext ctx) {
        String operation_type = rules.getResultType("+",types.get(ctx.expr(0)),types.get(ctx.expr(1)),ctx.start);
        types.put(ctx,operation_type);
    }

    public void exitSub(SolParser.SubContext ctx) {
        String operation_type = rules.getResultType("-",types.get(ctx.expr(0)),types.get(ctx.expr(1)),ctx.start);
        types.put(ctx,operation_type);
    }

    public void exitBethan(SolParser.BethanContext ctx) {
        String operation_type = rules.getResultType(">=",types.get(ctx.expr(0)),types.get(ctx.expr(1)),ctx.start);
        types.put(ctx,operation_type);
    }

    public void exitMod(SolParser.ModContext ctx) {
        String operation_type = rules.getResultType("%",types.get(ctx.expr(0)),types.get(ctx.expr(1)),ctx.start);
        types.put(ctx,operation_type);
    }

    public void exitOr(SolParser.OrContext ctx) {
        String operation_type = rules.getResultType("or",types.get(ctx.expr(0)),types.get(ctx.expr(1)),ctx.start);
        types.put(ctx,operation_type);
    }
    public void exitAnd(SolParser.AndContext ctx) {
        String operation_type = rules.getResultType("and",types.get(ctx.expr(0)),types.get(ctx.expr(1)),ctx.start);
        types.put(ctx,operation_type);
    }

    public void exitNotequals(SolParser.NotequalsContext ctx) {
        String operation_type = rules.getResultType("!=",types.get(ctx.expr(0)),types.get(ctx.expr(1)),ctx.start);
        types.put(ctx,operation_type);
    }

    public void exitLthan(SolParser.LthanContext ctx) {
        String operation_type = rules.getResultType("<",types.get(ctx.expr(0)),types.get(ctx.expr(1)),ctx.start);
        types.put(ctx,operation_type);
    }

    public void exitLethan(SolParser.LethanContext ctx) {
        String operation_type = rules.getResultType("<=", types.get(ctx.expr(0)), types.get(ctx.expr(1)), ctx.start);
        types.put(ctx,operation_type);
    }

    public void exitBthan(SolParser.BthanContext ctx) {
        String operation_type = rules.getResultType(">",types.get(ctx.expr(0)),types.get(ctx.expr(1)),ctx.start);
        types.put(ctx,operation_type);
    }

    public void exitDiv(SolParser.DivContext ctx) {
        String operation_type = rules.getResultType("/",types.get(ctx.expr(0)),types.get(ctx.expr(1)),ctx.start);
        types.put(ctx,operation_type);
    }

    public void exitNot(SolParser.NotContext ctx) {
        String value = types.get(ctx.expr());
        String operation_type = rules.getResultType("not",value,ctx.start);
        types.put(ctx,operation_type);
    }

    public void exitEquals(SolParser.EqualsContext ctx) {
        String operation_type = rules.getResultType("==",types.get(ctx.expr(0)),types.get(ctx.expr(1)),ctx.start);
        types.put(ctx,operation_type);
    }

}
