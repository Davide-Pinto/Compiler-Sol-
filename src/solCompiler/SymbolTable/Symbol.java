package solCompiler.SymbolTable;

import org.antlr.v4.runtime.Token;
import solCompiler.SymbolTable.Scope;

public class Symbol {
    public static enum Type{ tinvalid, tint, treal, tbool, tstring, tvoid}

    Token token;
    Type type;
    Scope scope;


    public Symbol(Token token){
        this.token = token;
    }
    public Symbol(Token token, Type type){
        this.token = token;
        this.type = type;
    }

    public Token getToken(){
        return token;
    }

    public String lexeme(){
        return getToken().getText();
    }

    public Scope getScope() {
        return scope;
    }


    public String getType(){
        switch (type){
            case tint: return "int";
            case treal: return "real";
            case tbool: return "bool";
            case tstring: return "string";
            case tvoid: return "void";
        }
        return "tinvalid";
    }

    public String toString(){
        if(type != Type.tinvalid){ return '<'+lexeme()+":"+type+'>';}
        return lexeme();
    }
}
