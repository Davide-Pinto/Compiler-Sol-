package solCompiler;

import org.antlr.v4.runtime.Token;

import java.util.HashMap;
import java.util.Map;

public class CheckType {
    private final Map<String, String> rules = new HashMap<>();
    public int error = 0;

    public CheckType() {

        rules.put("- int", "int");
        rules.put("- real", "real");
        rules.put("not bool", "bool");

        // Int with Real operations
        rules.put("+ int int", "int");
        rules.put("- int int", "int");
        rules.put("* int int", "int");
        rules.put("/ int int", "int");
        rules.put("% int int", "int");
        rules.put("+ int real", "real");
        rules.put("- int real", "real");
        rules.put("* int real", "real");
        rules.put("/ int real", "real");
        rules.put("+ real real", "real");
        rules.put("- real real", "real");
        rules.put("* real real", "real");
        rules.put("/ real real", "real");

        // Boolean with String operations
        rules.put("+ bool string", "string");
        // String with Int/Real operations
        rules.put("+ string int", "string");
        rules.put("+ string real", "string");
        rules.put("+ string string", "string");
        // Boolean operations
        rules.put("and bool bool", "bool");
        rules.put("or bool bool", "bool");
        // Relational operations between Int and Real
        rules.put("< int int", "bool");
        rules.put("> int int", "bool");
        rules.put("<= int int", "bool");
        rules.put(">= int int", "bool");
        rules.put("== int int", "bool");
        rules.put("!= int int", "bool");
        // Relational mixed operations between Int and Real
        rules.put("< int real", "bool");
        rules.put("> int real", "bool");
        rules.put("<= int real", "bool");
        rules.put(">= int real", "bool");
        rules.put("== int real", "bool");
        rules.put("!= int real", "bool");

        rules.put("< real real", "bool");
        rules.put("> real real", "bool");
        rules.put("<= real real", "bool");
        rules.put(">= real real", "bool");
        rules.put("== real real", "bool");
        rules.put("!= real real", "bool");

        // Relational operations for Strings
        rules.put("== string string", "bool");
        rules.put("!= string string", "bool");
        // Relational operations for Booleans
        rules.put("== bool bool", "bool");

    }

    public String getResultType(String op, String type1, String type2, Token t) {
        // Generate the lookup key by concatenating the operator and operand types
        String keyOne = op + " " + type1 + " " + type2;
        String keyTwo = op + " " + type2 + " " + type1;
        if (rules.containsKey(keyOne)) { return rules.get(keyOne);}
        else if(rules.containsKey(keyTwo)){ return rules.get(keyTwo);}
        else if(type1 != null && type2 != null && !type1.equals("invalid") && !type2.equals("invalid")){
            error(t," error: operator " + op + " is invalid between " + type1 + " and " + type2+ "." );
        }
        return null;
    }

    public String getResultType(String op, String type1, Token t) {
        // Generate the lookup key by concatenating the operator and operand types
        String key = op + " " + type1;
        if (rules.containsKey(key)) {
            return rules.get(key);
        } else if(type1 != null && !type1.equals("invalid")) {
            error(t, " error: operator " + op + " is invalid for type " + type1 + ".");
        }
        return null;
    }

    public void checkOperation(String op, String type1, String type2, Token t) {
        if(!type1.equals(type2) && !type1.equals("invalid") && !type2.equals("invalid") ){
            error(t," error: operator " + op + " is invalid between " + type1 + " and " + type2+ "." );
        }
    }
    //Taken from the book
    public void error(Token t, String msg){
        System.err.printf("line %d:%d %s\n", t.getLine(),t.getCharPositionInLine(),msg);
        error++;
    }

}
