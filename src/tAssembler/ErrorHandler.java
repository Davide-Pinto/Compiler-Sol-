package tAssembler;

import org.antlr.v4.runtime.Token;

public class ErrorHandler {

    public int numberOfErrors = 0;

    public void error(Token t, String msg){
        System.err.printf("line %d:%d %s\n", t.getLine(),t.getCharPositionInLine(),msg);
        numberOfErrors++;
    }

}
