package solCompiler.SymbolTable;

import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

public class FunctionSymbol extends Symbol {
    ArrayList<Symbol> arguments = new ArrayList<Symbol>();

    int firstArgPosition;

    public FunctionSymbol(Token token, Type retType) {
        super(token, retType);
    }

    public void setFirstArgPosition(int firstArgPosition) {
        this.firstArgPosition = firstArgPosition;
    }

    public int getFirstArgPosition() {
        return firstArgPosition;
    }

    public ArrayList<Symbol> get_arguments() {
        return arguments;
    }

    public void add_argument(Symbol sym) {
        arguments.add(sym);
    }

    public String toString() {
        return "function" + super.toString() + ":" + arguments;
    }
}
