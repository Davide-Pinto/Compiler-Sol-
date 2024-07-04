package tVM;

import org.antlr.v4.runtime.Token;
import storage.*;
import storage.Boolean;
import storage.Integer;

public class ErrorHandler {

    public void error(String msg){
        System.err.printf("runtime error: " + msg);
        System.exit(1);
    }


    //Checks if there is enough values in the stack for the operation
    public void checkStackSize(int stackSize, int stackRequiredSize, String opcode){
        if(stackRequiredSize > stackSize){
            error(opcode + " needs " + stackRequiredSize + " elements at the top of the stack.");
        }
    }

    public void checkConstantPoolSize(int constantPoolSize, int constantPosition, String opcode){
        if(constantPosition > constantPoolSize){
            error(opcode + " argument ("+ constantPosition +") is not valid, out of bounds.");
        }
    }

    public void checkGlobalsSize(int globalsSize, int globalsPosition, String opcode){
        if(globalsPosition > globalsSize){
            error(opcode + " argument ("+ globalsPosition +") is not valid, out of bounds.");
        }
    }

    private boolean checkInstanceOf(Value<?> value, String expectedType){
        switch (expectedType){
            case "int": return value instanceof Integer;
            case "real": return value instanceof Real;
            case "bool": return value instanceof Boolean;
            case "string": return value instanceof Text;
        }
        return false;
    }

    public void checkValuesTypes(Value<?> left, Value<?> right, String expectedType, String opcode){
        if (!(checkInstanceOf(left,expectedType)) || !(checkInstanceOf(right,expectedType))) {
            error(opcode + " needs two " + expectedType + " elements at the top of the stack.");
        }
    }

    public void checkValuesTypes(Value<?> value, String expectedType, String opcode){
        if (!(checkInstanceOf(value,expectedType))) {
            error(opcode + " needs one " + expectedType + " element at the top of the stack.");
        }
    }
}
