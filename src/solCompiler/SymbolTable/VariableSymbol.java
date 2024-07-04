package solCompiler.SymbolTable;

import org.antlr.v4.runtime.Token;
import tVM.Opcode;

public class VariableSymbol extends Symbol{

    int position;
    public VariableSymbol(Token token, Type type){
        super(token,type);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Opcode load(){
        if(scope.getName().equals("Global"))
            return Opcode.gload;
        else
            return Opcode.lload;
    }

    public Opcode store(){
        if(scope.getName().equals("Global"))
            return Opcode.gstore;
        else
            return Opcode.lstore;
    }

    public String toString() {
        return "Variable" + super.toString() + "<position:" + position + '>';
    }

}
