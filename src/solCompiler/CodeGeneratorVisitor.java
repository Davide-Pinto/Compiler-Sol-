package solCompiler;

import Sol.SolBaseVisitor;
import Sol.SolParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import solCompiler.SymbolTable.FunctionSymbol;
import solCompiler.SymbolTable.Scope;
import solCompiler.SymbolTable.Symbol;
import solCompiler.SymbolTable.VariableSymbol;
import storage.Integer;
import storage.Real;
import storage.Text;
import storage.Value;
import tVM.Opcode;


import java.util.*;

public class CodeGeneratorVisitor extends SolBaseVisitor<Void> {
    public ArrayList<Value<?>> bytecodes = new ArrayList<>();
    public List<Pair<Opcode, Value<?>>> constantPool = new ArrayList<>();
    public List<Pair<Opcode, Integer>> instructionPool = new ArrayList<>();
    public ParseTreeProperty<String> types;
    ParseTreeProperty<Scope> scopes;
    private final ArrayList<Pair<java.lang.Integer, java.lang.Integer>> backPatch = new ArrayList<>(); //Pair<loopnumber, indexofBreak>
    private final ArrayList<Pair<java.lang.Integer, String>> callsBackPatch = new ArrayList<>();
    Scope globals;
    Scope currentScope;

    int numberOfLocalVar = 0;
    FunctionSymbol currentFunction;
    private int loopNumber = 0; //keeps track of loops used to back patch break.
    public CodeGeneratorVisitor(ParseTreeProperty<String> types, ParseTreeProperty<Scope> scopes, Scope globals) {
        this.types = types;
        this.scopes = scopes;
        this.globals = globals;
    }

    //-----------------------------------------------------Trabalho 2--------------------------------------------------
    public Void visitS(SolParser.SContext ctx) {
        visit(ctx.prog());
        return null;
    }

    public Void visitProg(SolParser.ProgContext ctx) {
        currentScope = globals;
        for (SolParser.DeclarationContext declaration : ctx.declaration()) {
            visit(declaration);
        }
        //emits call for the main and stores it for backpatch in the end
        callsBackPatch.add(new Pair<>(emit(Opcode.call,-1),"main"));
        //emits halt
        emit(Opcode.halt);
        for (SolParser.FunctionDeclarationContext function : ctx.functionDeclaration()) {
            visit(function);
        }
        backPatchCalls();
        writeBytecodes();
        return null;
    }

    public Void visitPrint(SolParser.PrintContext ctx) {
        visit(ctx.expr());
        switch (types.get(ctx)) { //type of print according to the type of the node
            case "int": emit(Opcode.iprint);break;
            case "real": emit(Opcode.dprint);break;
            case "string": emit(Opcode.sprint);break;
            case "bool": emit(Opcode.bprint);break;
        }
        return null;
    }

    public Void visitAdd(SolParser.AddContext ctx) {
        visit(ctx.expr(0)); //Visit Left
        visit(ctx.expr(1)); //Visit Right
        switch (types.get(ctx)) { //type of add according to the type of the node
            case "int": emit(Opcode.iadd);break;
            case "real": emit(Opcode.dadd);break;
            case "string": emit(Opcode.sadd);break;
        }
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); // Verifies if a change of type command is needed (itod,itos,dtos,btos)
        return null;
    }

    public Void visitSub(SolParser.SubContext ctx) {
        visit(ctx.expr(0)); //Visit Left
        visit(ctx.expr(1)); //Visit Right
        switch (types.get(ctx)) { //type of sub according to the type of the node
            case "int": emit(Opcode.isub);break;
            case "real": emit(Opcode.dsub);break;
        }
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); // Verifies if a change of type command is needed (itod,itos,dtos,btos)
        return null;
    }

    public Void visitBethan(SolParser.BethanContext ctx) {
        visit(ctx.expr(1)); //Visit Right
        visit(ctx.expr(0)); //Visit Left
        String type = checkBoolOperationChildren(ctx); //because operation is type bool, used to determine what type of data is in both sides
        switch (type) { //type of Bethan according to the type of the node
            case "int": emit(Opcode.ileq);break;
            case "real": emit(Opcode.dleq);break;
        }
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); // Verifies if a change of type command is needed (itod,itos,dtos,btos)
        return null;
    }

    public Void visitMod(SolParser.ModContext ctx) {
        visit(ctx.expr(0)); //Visit Left
        visit(ctx.expr(1)); //Visit Right
        emit(Opcode.imod);
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); // Verifies if a change of type command is needed (itod,itos,dtos,btos)
        return null;
    }

    public Void visitOr(SolParser.OrContext ctx) {
        visit(ctx.expr(0)); //Visit Left
        visit(ctx.expr(1)); //Visit Right
        emit(Opcode.or);
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); // Verifies if a change of type command is needed (itod,itos,dtos,btos)
        return null;
    }

    public Void visitNotequals(SolParser.NotequalsContext ctx) {
        visit(ctx.expr(0)); //Visit Left
        visit(ctx.expr(1)); //Visit Right
        String type = checkBoolOperationChildren(ctx); //because operation is type bool, used to determine what type of data is in both sides
        switch (type) { //type of NotEquals according to the type of the node
            case "int": emit(Opcode.ineq);break;
            case "real": emit(Opcode.dneq);break;
            case "string": emit(Opcode.sneq);break;
            case "bool": emit(Opcode.beq);break;
        }
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); // Verifies if a change of type command is needed (itod,itos,dtos,btos)
        return null;
    }

    public Void visitLthan(SolParser.LthanContext ctx) {
        visit(ctx.expr(0)); //Visit Left
        visit(ctx.expr(1)); //Visit Right
        String type = checkBoolOperationChildren(ctx); //because operation is type bool, used to determine what type of data is in both sides
        switch (type) { //type of LThan according to the type of the node
            case "int": emit(Opcode.ilt);break;
            case "real": emit(Opcode.dlt);break;
        }
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); // Verifies if a change of type command is needed (itod,itos,dtos,btos)
        return null;
    }

    public Void visitString(SolParser.StringContext ctx) {
        String stringValue = ctx.STRING().getText();
        stringValue = stringValue.replace("\"", ""); //removes '"'
        emit(Opcode.sconst, constantPool.size());
        constantPool.add(new Pair<>(Opcode.spool, new Text(stringValue)));
        return null;
    }

    public Void visitDouble(SolParser.DoubleContext ctx) {
        double doubleValue = Double.parseDouble(ctx.DOUBLE().getText());
        emit(Opcode.dconst, constantPool.size());
        constantPool.add(new Pair<>(Opcode.dpool, new Real(doubleValue)));
        if(!(ctx.parent instanceof SolParser.CallExprContext))
            changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); //(itod,itos,dtos,btos).
        return null;
    }

    public Void visitInt(SolParser.IntContext ctx) {
        int intValue = java.lang.Integer.parseInt(ctx.INT().getText());
        emit(Opcode.iconst, intValue);
        if(!(ctx.parent instanceof SolParser.CallExprContext))
            changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); //(itod,itos,dtos,btos).
        return null;
    }

    public Void visitLethan(SolParser.LethanContext ctx) {
        visit(ctx.expr(0)); //Visit Left
        visit(ctx.expr(1)); //Visit Right
        String type = checkBoolOperationChildren(ctx); //because operation is type bool, used to determine what type of data is in both sides
        switch (type) { //type of LEThan according to the type of the node
            case "int": emit(Opcode.ileq);break;
            case "real": emit(Opcode.dleq);break;
        }
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); //(itod,itos,dtos,btos)
        return null;
    }

    public Void visitDiv(SolParser.DivContext ctx) {
        visit(ctx.expr(0)); //Visit Left
        visit(ctx.expr(1)); //Visit Right
        switch (types.get(ctx)) { //type of Div according to the type of the node
            case "int": emit(Opcode.idiv);break;
            case "real": emit(Opcode.ddiv);break;
        }
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); //(itod,itos,dtos,btos)
        return null;
    }

    public Void visitNot(SolParser.NotContext ctx) {
        visit(ctx.expr());
        emit(Opcode.not);
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); //(itod,itos,dtos,btos)
        return null;
    }

    public Void visitEquals(SolParser.EqualsContext ctx) {
        visit(ctx.expr(0)); //Visit Left
        visit(ctx.expr(1)); //Visit Right
        String type = checkBoolOperationChildren(ctx); //because operation is type bool, used to determine what type of data is in both sides
        switch (type) { //type of Equals according to the type of the node
            case "int": emit(Opcode.ieq);break;
            case "real": emit(Opcode.deq);break;
            case "string": emit(Opcode.seq);break;
            case "bool": emit(Opcode.beq);break;
        }
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); //(itod,itos,dtos,btos)
        return null;
    }

    public Void visitMult(SolParser.MultContext ctx) {
        visit(ctx.expr(0)); //Visit Left
        visit(ctx.expr(1)); //Visit Right
        switch (types.get(ctx)) { //type of Mult according to the type of the node
            case "int": emit(Opcode.imult);break;
            case "real": emit(Opcode.dmult);break;
        }
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); // Verifies if a change of type command is needed (itod,itos,dtos,btos)
        return null;
    }

    public Void visitBool(SolParser.BoolContext ctx) {
        boolean value = Boolean.parseBoolean(ctx.BOOL().getText());
        if (value) { //if value is true
            emit(Opcode.tconst);
        } else {    //else if value is false
            emit(Opcode.fconst);
        }
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); //(itod,itos,dtos,btos)
        return null;
    }

    public Void visitAnd(SolParser.AndContext ctx) {
        visit(ctx.expr(0)); //Visit Left
        visit(ctx.expr(1)); //Visit Right
        emit(Opcode.and);
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); //(itod,itos,dtos,btos)
        return null;
    }

    public Void visitBthan(SolParser.BthanContext ctx) {
        visit(ctx.expr(1)); //Visit Right
        visit(ctx.expr(0)); //Visit Left
        String type = checkBoolOperationChildren(ctx); //because operation is type bool, used to determine what type of data is in both sides
        switch (type) { //type of BThan according to the type of the node
            case "int": emit(Opcode.ilt);break;
            case "real": emit(Opcode.dlt);break;
        }
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); //(itod,itos,dtos,btos)
        return null;
    }

    public Void visitParentheses(SolParser.ParenthesesContext ctx) {
        //visit expressions inside the Parentheses
        visit(ctx.expr());
        //checks if a change in type is needed
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); //(itod,itos,dtos,btos)
        return null;
    }

    public Void visitMinus(SolParser.MinusContext ctx) {
        visit(ctx.expr());
        switch (types.get(ctx)) { //type of Minus according to the type of the node
            case "int": emit(Opcode.iuminus);break;
            case "real": emit(Opcode.duminus);break;
        }
        changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); //(itod,itos,dtos,btos)
        return null;
    }
    //-------------------------------------------------Fim Trabalho 2---------------------------------------------
    //---------------------------------------------------Trabalho 3-----------------------------------------------

    public Void visitVarChange(SolParser.VarChangeContext ctx) {
        //System.out.println("Current: " + currentScope.getName()+ " " + currentScope.symbols);
        VariableSymbol sym =  currentScope.getVariableSymbol(ctx.VARNAME().getText());
        visit(ctx.expr());
        emit(sym.store(), sym.getPosition());
        return null;
    }

    public Void visitBlock(SolParser.BlockContext ctx) {
        numberOfLocalVar = 0;
        currentScope = scopes.get(ctx);
        for (SolParser.DeclarationContext DeclarationContext : ctx.declaration()) {
            //visit every statement contained by the block
            visit(DeclarationContext);
        }
        int vars = numberOfLocalVar;

        for (SolParser.StmtContext statement : ctx.stmt()) {
            //visit every statement contained by the block
            visit(statement);
        }
        if(vars>0 && currentScope.getName().equals("local")){
            emit(Opcode.pop,vars);
        }
        currentScope = currentScope.getEnclosingScope();
        return null;
    }

    public Void visitWhile(SolParser.WhileContext ctx) {
        loopNumber++; //used to keep track of current loop
        int numberOfLoop= loopNumber;
        //stores the start position of the loop, used in jump at the end, to repeat the loop
        int loopStartIndex = instructionPool.size();
        //visit while control expression
        visit(ctx.expr());
        //jumpf in case to exit the loop in case that control expression is false
        int loopJumpf = emit(Opcode.jumpf, -1);
        //visit statments inside the loop
        visit(ctx.stmt());
        //jump to the start of the loop
        emit(Opcode.jump,loopStartIndex);
        //back patch jumpf instruction to exit the loop
        setInstructionPool(loopJumpf, Opcode.jumpf,instructionPool.size()); //back patch  index/opcode/new arg
        //back patch of eventual breaks in loop
        backPatchingBreak(numberOfLoop,instructionPool.size());
        loopNumber--; //used to keep track of current loop
        return null;
    }

    public Void visitFor(SolParser.ForContext ctx) {
        VariableSymbol sym = currentScope.getVariableSymbol(ctx.VARNAME().getText());
        loopNumber++; //used to keep track of current loop
        int numberOfLoop = loopNumber;
        visit(ctx.expr(0));
        int loopStartIndex;
        int loopJumpf;
        emit(sym.store(), sym.getPosition());
        loopStartIndex = emit(sym.load(),sym.getPosition());
        visit(ctx.expr(1));
        emit(Opcode.ileq);
        loopJumpf = emit(Opcode.jumpf,-1);
        visit(ctx.stmt());
        emit(sym.load(), sym.getPosition());
        emit(Opcode.iconst, 1);
        emit(Opcode.iadd);
        emit(sym.store(), sym.getPosition());
        //jump to start
        emit(Opcode.jump, loopStartIndex);
        //backPatch jump to end of loop
        setInstructionPool(loopJumpf ,Opcode.jumpf,instructionPool.size());
        //backPatch of eventual breaks in loop
        backPatchingBreak(numberOfLoop,instructionPool.size());
        loopNumber--; //used to keep track of current loop
        return null;
    }

    public Void visitIfElse(SolParser.IfElseContext ctx) {
        //visit control expression
        visit(ctx.expr());
        //jumpf to exit if
        int jumpIfIndex = emit(Opcode.jumpf,-1);
        //visit statements inside if
        visit(ctx.stmt(0));
        //back patch is case that there is no else
        setInstructionPool(jumpIfIndex,Opcode.jumpf,instructionPool.size()); //back patch  index/opcode/new arg
        //checking is there is an else
        if (ctx.stmt(1) != null) { //checking if there is an else
            //jump else
            int jumpElseIndex = emit(Opcode.jump,-1);
            //back patch if there is an else
            setInstructionPool(jumpIfIndex,Opcode.jumpf,instructionPool.size()); //back patch  index/opcode/new arg
            //visit else statements
            visit(ctx.stmt(1));
            //back patch jump instruction
            setInstructionPool(jumpElseIndex,Opcode.jump,instructionPool.size()); //back patch  index/opcode/new arg
        }
        return null;
    }

    public Void visitBreak(SolParser.BreakContext ctx) {
        int breakPosition = emit(Opcode.jump, -1);
        //stores the number of the loop that the break belongs to, and the break position in the instruction array.
        backPatch.add(new Pair<>(loopNumber,breakPosition));
        return null;
    }

    public Void visitVar(SolParser.VarContext ctx) {
        VariableSymbol sym = currentScope.getVariableSymbol(ctx.VARNAME().getText());
        emit(sym.load(), sym.getPosition()); //emits gload instruction with the position of the var in that global array as argument.
        if(!(ctx.parent instanceof SolParser.CallExprContext))
            changeTypeInstruction(types.get(ctx), types.get(ctx.parent), ctx.parent); //(itod,itos,dtos,btos).
        return null;
    }

    public Void visitDeclaration(SolParser.DeclarationContext ctx) {
        if(currentScope.getName().equals("Global"))
            emit(Opcode.galloc, ctx.varDeclaration().size()); //emits galloc instruction, with the number of variables being declared.
        else
            emit(Opcode.lalloc, ctx.varDeclaration().size());
        for (SolParser.VarDeclarationContext declaration : ctx.varDeclaration()) {
            visit(declaration); //visits every variable declaration associated with this declaration.
        }
        return null;
    }

    public Void visitVarDeclaration(SolParser.VarDeclarationContext ctx) {
        numberOfLocalVar++;
        VariableSymbol sym = currentScope.getVariableSymbol(ctx.VARNAME().getText());
        if (ctx.expr() != null) {  //If expr is not null, means that the variable was initialized.
            visit(ctx.expr());    //visits the expression that initializes the variable.
            emit(sym.store(), sym.getPosition()); //emits the gstore instruction with the nex position in the globals array as argument.
        }
        return null;
    }

    //--------------------------------------Trabalho 4--------------------------------------------------
    public Void visitCallStmt(SolParser.CallStmtContext ctx) {
        for (SolParser.ExprContext exprContext : ctx.expr()) {
            visit(exprContext);
        }
        callsBackPatch.add(new Pair<>(emit(Opcode.call,-1),ctx.VARNAME().getText()));
        return null;
    }
    public Void visitReturn(SolParser.ReturnContext ctx) {
        visit(ctx.expr());
        Symbol function = currentScope.resolve(currentFunction.lexeme());
        if(!function.getType().equals("void")){
            if (function.getType().equals("real") && types.get(ctx.expr()).equals("int")) {
                emit(Opcode.itod);
            }
        }
        emit(Opcode.retval,currentFunction.get_arguments().size());
        return null;
    }

    public Void visitFunctionDeclaration(SolParser.FunctionDeclarationContext ctx) {
        currentFunction = currentScope.getFuctionSymbol(ctx.VARNAME().getText());
        currentFunction.setFirstArgPosition(instructionPool.size());
        if(ctx.formalParameters() != null){
            visit(ctx.formalParameters());
        }
        visit(ctx.block());
        //Symbol function = currentScope.resolve(ctx.VARNAME().getText());
        if(currentFunction.getType().equals("void"))
            emit(Opcode.ret,currentFunction.get_arguments().size());
        return null;
    }
    public Void visitFormalParameters(SolParser.FormalParametersContext ctx) {
        for (SolParser.FormalParameterContext formalParameterContext : ctx.formalParameter()) {
            visit(formalParameterContext);
        }
        return null;
    }

    public Void visitFormalParameter(SolParser.FormalParameterContext ctx) {
        return null;
    }
    public Void visitCallExpr(SolParser.CallExprContext ctx) {
        for (SolParser.ExprContext exprContext : ctx.expr()) {
            visit(exprContext);
        }
        callsBackPatch.add(new Pair<>(emit(Opcode.call,-1),ctx.VARNAME().getText()));
        return null;
    }


    //----------------------------------Support Functions-----------------------------------------------

    // checkBoolOperationChildren, checks the children of a bool operation and returns the "dominant" type between the two
    private String checkBoolOperationChildren(ParseTree node) {
        if (node.getChildCount() == 0) {
            return types.get(node);
        }

        String leftType = types.get(node.getChild(0));
        String rightType = types.get(node.getChild(2));
        if (leftType != null && rightType != null) {
            if (leftType.equals("int") && rightType.equals("real") || leftType.equals("real") && rightType.equals("int")) {
                return "real";
            } else if (leftType.equals("real") && rightType.equals("string") || leftType.equals("string") && rightType.equals("real")) {
                return "string";
            } else if (leftType.equals("int") && rightType.equals("int")) {
                return "int";
            } else if (leftType.equals("real") && rightType.equals("real")) {
                return "real";
            } else if (leftType.equals("string") && rightType.equals("string")) {
                return "string";
            } else if (leftType.equals("string") && rightType.equals("bool") || leftType.equals("bool") && rightType.equals("string")) {
                return "string";
            } else if (leftType.equals("bool") && rightType.equals("bool")) {
                return "bool";
            }
        }
        return "ignore";
    }

    //this function is used to determine if (itod,dtos,itos,btos) instruction is needed
    private void changeTypeInstruction(String nodeType, String parentType, ParseTree parent) {
        if (parentType != null && parentType.equals("bool")) {
            parentType = checkBoolOperationChildren(parent);
        }
        switch (nodeType) {
            case "int":
                switch (Objects.requireNonNull(parentType)) {
                    case "real": emit(Opcode.itod);break;
                    case "string": emit(Opcode.itos);break;
                    default: break;
                }
                break;
            case "real":
                if (parentType != null && parentType.equals("string")) {
                    emit(Opcode.dtos);
                }
                break;
            case "string:": break;
            case "bool":
                if (parentType != null && parentType.equals("string")) {
                    emit(Opcode.btos);
                }
                break;
        }
    }

    //setInstructionPool updates entries in the instruction pool
    public void setInstructionPool(int index, Opcode opcode, int arg){
        instructionPool.set(index, new Pair<>(opcode, new Integer(arg)));
    }

    //backPatchingBreak back-patches any breaks
    private void backPatchingBreak(int loopNumber, int arg) {
        for (int i = 0; i < backPatch.size(); i++) {
            Pair<java.lang.Integer, java.lang.Integer> value = backPatch.get(i);
            if (value.a == loopNumber) {
                setInstructionPool(value.b, Opcode.jump, arg);
                backPatch.remove(i);
                i--;
            }
        }
    }

    //emit functions emit instructions to the instruction pool array List
    private int emit(Opcode opcode, int arg) {
        int position = instructionPool.size();
        instructionPool.add(new Pair<>(opcode, new Integer(arg)));
        return position;
    }
    private void emit(Opcode opcode) {
        instructionPool.add(new Pair<>(opcode, null));
    }

    public void backPatchCalls(){
        for(int i = 0; i < callsBackPatch.size(); i++){
            FunctionSymbol function = currentScope.getFuctionSymbol(callsBackPatch.get(i).b);
            int index = callsBackPatch.get(i).a;
            int firstArgPosition = function.getFirstArgPosition();
            setInstructionPool(index, Opcode.call, firstArgPosition);
        }
    }

    private void writeBytecodes(){
        //puts the constant pool in the bytecodes ArrayList
        for (Pair<Opcode, Value<?>> opcodeValuePair : constantPool) {
            bytecodes.add(new Integer(opcodeValuePair.a.getOpcode()));
            char[] charArray = opcodeValuePair.b.getValue().toString().toCharArray();
            bytecodes.add(new Integer(charArray.length));
            for (char c : charArray) {
                bytecodes.add(new Text(String.valueOf(c)));
            }
        }
        //puts the instruction pool in the bytecodes ArrayList
        for (Pair<Opcode, Integer> opcodeIntegerPair : instructionPool) {
            bytecodes.add(new Integer(opcodeIntegerPair.a.getOpcode()));
            if (opcodeIntegerPair.b != null) {
                bytecodes.add(new Integer(opcodeIntegerPair.b.getValue()));
            }
        }
    }

    //-----------------------------------------------END Support Functions---------------------------------------------
}
