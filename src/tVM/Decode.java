package tVM;

import org.antlr.v4.runtime.misc.Pair;
import storage.Codes;
import storage.Real;
import storage.Text;
import storage.Value;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;



public class Decode {
    public ArrayList<Value<?>> constantPool = new ArrayList<>();
    public List<Pair<Opcode, Integer>> instructionPool = new ArrayList<>();


    public void execute(String bytecodeFile, Boolean trace) {
        try (DataInputStream din = new DataInputStream(new FileInputStream(bytecodeFile))) {
            while (din.available() > 0) {

                int op = din.readInt();
                Opcode opcode = Opcode.valueOf(op);
                switch (opcode) {
                    case spool:
                        int stringSize = din.readInt();
                        StringBuilder spool_result = new StringBuilder();
                        for (int j = 0; j < stringSize; j++) {
                            spool_result.append(din.readChar());
                        }
                        constantPool.add(new Text(spool_result.toString()));
                        break;
                    case dpool:
                        int doubleSize = din.readInt();
                        StringBuilder dpool_result = new StringBuilder();
                        for (int j = 0; j < doubleSize; j++) {
                            dpool_result.append(din.readChar());
                        }
                        constantPool.add(new Real(Double.valueOf(dpool_result.toString())));
                        break;
                default:
                        int argument = 0;
                        if (opcode.getNumArgs() > 0) {
                            argument = din.readInt();
                        }
                        instructionPool.add(new Pair<>(opcode, argument));
                        break;
                }
            }

            if(trace) {
                System.out.println("Constant Pool:");
                for (int j = 0; j < constantPool.size(); j++) {
                    System.out.println(j + ": " + constantPool.get(j));
                }
                System.out.println("Instruction Pool:");
                for (int j = 0; j < instructionPool.size(); j++) {
                    if(instructionPool.get(j).a.getNumArgs()>0) {
                        System.out.println(j + ": " + instructionPool.get(j).a + " " + instructionPool.get(j).b);
                    }else{
                        System.out.println(j + ": " + instructionPool.get(j).a);
                    }
                }
                System.out.println();
                System.out.println("Operations Trace:");
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
