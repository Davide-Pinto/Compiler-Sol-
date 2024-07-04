package solCompiler;

import Sol.SolBaseListener;
import Sol.SolParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import solCompiler.SymbolTable.*;

import javax.swing.*;

public class DefPhase extends SolBaseListener {
    public ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    public Scope global;
    private Scope currentScope; // define symbols in this scope

    private  SolParser.TypeSpecifierContext currentType;
    private FunctionSymbol currentFunction;
    private int globalPosition = 0;
    private int localPosition = 2;


    private int formalParameterPosition;

    public int error = 0;


    void saveScope(ParserRuleContext ctx, Scope s) {
        scopes.put(ctx, s);
    }

    void defineVar(SolParser.TypeSpecifierContext typeCtx, Token nameToken) {
        int typeTokenType = typeCtx.start.getType();
        Symbol.Type type = CheckSymbols.getType(typeTokenType);
        VariableSymbol var = new VariableSymbol(nameToken, type);
        if (!currentScope.contains(var.lexeme())){
            currentScope.define(var); // Define symbol in current scope
        }
        else {
            CheckSymbols.error(nameToken, " error: Variable '" + var.lexeme() + "' is already defined");
            error++;
        }
    }

    public void enterProg(SolParser.ProgContext ctx) {
        global = new Scope(null, "Global");
        currentScope = global;
    }

    public void exitProg(SolParser.ProgContext ctx) {
        Symbol main = global.resolve("main");
        if(!(main instanceof FunctionSymbol)){
            CheckSymbols.error(ctx.stop, " error: missing main() function");
            error++;
        }
    }

    public void enterFunctionDeclaration(SolParser.FunctionDeclarationContext ctx) {
        //hasReturn = false;
        Token token = ctx.VARNAME().getSymbol();
        int typeTokenType = ctx.typeSpecifier().start.getType();
        Symbol.Type type = CheckSymbols.getType(typeTokenType);
        FunctionSymbol function = new FunctionSymbol(token, type);
        currentScope.define(function);
        currentFunction = function;

    }
    public void exitFunctionDeclaration(SolParser.FunctionDeclarationContext ctx) {
        localPosition = 2; //testar se devia estar aqui ou nos blocks
    }
    public void enterFormalParameters(SolParser.FormalParametersContext ctx) {
        formalParameterPosition = -ctx.formalParameter().size();
    }

    public void exitFormalParameter(SolParser.FormalParameterContext ctx) {
        SolParser.TypeSpecifierContext typeCtx = ctx.typeSpecifier();
        int typeTokenType = typeCtx.start.getType();
        Symbol.Type type = CheckSymbols.getType(typeTokenType);
        VariableSymbol var = new VariableSymbol(ctx.VARNAME().getSymbol(), type);
        var.setPosition(formalParameterPosition);
        formalParameterPosition++;
        currentFunction.add_argument(var);
    }

    public void enterBlock(SolParser.BlockContext ctx) {
        currentScope = new Scope(currentScope);
        if (currentFunction != null) {
            currentScope.setName(currentFunction.lexeme());

            for (Symbol sym : currentFunction.get_arguments()) {
                if (currentScope.resolve_local(sym.lexeme()) == null)
                    currentScope.define(sym);
                else {
                    CheckSymbols.error(sym.getToken(), "formal parameter " + sym.lexeme() + " is defined more than once in function " + currentFunction.lexeme());
                    error++;
                }
            }
        }else
            currentScope.setName("local");
        currentFunction = null;
        saveScope(ctx,currentScope);
    }

    public void exitBlock(SolParser.BlockContext ctx) {
        localPosition -= ctx.declaration().size();
        currentScope = currentScope.getEnclosingScope();
    }
    public void enterDeclaration(SolParser.DeclarationContext ctx) {
        currentType = ctx.typeSpecifier();
    }

    public void exitVarDeclaration(SolParser.VarDeclarationContext ctx) {
        defineVar(currentType, ctx.VARNAME().getSymbol());
        VariableSymbol var = currentScope.getVariableSymbol(ctx.VARNAME().getText());
        if(currentScope.getName().equals("Global")){
            var.setPosition(globalPosition);
            globalPosition++;
        }else {
            var.setPosition(localPosition);
            localPosition++;
        }

    }

    public void exitDeclaration(SolParser.DeclarationContext ctx) {
        currentType = null;
    }


}
