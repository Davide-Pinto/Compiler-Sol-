package solCompiler.SymbolTable;

import Sol.SolParser;
import org.antlr.v4.runtime.Token;

//taken from the book
public class CheckSymbols {
    public static  Symbol.Type getType(int tokenType) {
        switch ( tokenType ) {
            case SolParser.K_INT:    return Symbol.Type.tint;
            case SolParser.K_REAL:   return Symbol.Type.treal;
            case SolParser.K_BOOL:   return Symbol.Type.tbool;
            case SolParser.K_STRING: return Symbol.Type.tstring;
            case SolParser.K_VOID:   return Symbol.Type.tvoid;
        }
        return Symbol.Type.tinvalid;
    }

    public static void error(Token t, String msg){
        System.err.printf("line %d:%d %s\n", t.getLine(),t.getCharPositionInLine(),msg);
    }
}
