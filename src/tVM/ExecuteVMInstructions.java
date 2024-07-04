package tVM;

import org.antlr.v4.runtime.misc.Pair;
import storage.Integer;
import storage.Real;
import storage.Text;
import storage.Value;


import java.util.*;

public class ExecuteVMInstructions {
    private final ArrayList<Value<?>> constantPool;
    private final List<Pair<Opcode, java.lang.Integer>> instructionPool;
    private final Stack<Value<?>> stack = new Stack<>();
    private final ArrayList<Value<?>> globals = new ArrayList<>(0);
    // Colors for error printing.

    public ExecuteVMInstructions(ArrayList<Value<?>> constantPool, List<Pair<Opcode, java.lang.Integer>> instructionPool) {
        this.constantPool = constantPool;
        this.instructionPool = instructionPool;
    }

    public void execute(boolean trace) {
        ErrorHandler errorHandler = new ErrorHandler();
        int IP = 0; //instruction Pointer
        int FP = 0; //Frame Pointer

        while (IP < instructionPool.size()) {
            Opcode opcode = instructionPool.get(IP).a;
            int opcodeArg = instructionPool.get(IP).b;
            if(trace) {
                System.out.println();
                System.out.println("Global: " + globals);
                System.out.println("Stack: " + stack);
                System.out.println("IP: " + IP + " FP: " + FP);
                System.out.println();

                if (opcode.getNumArgs() > 0) {
                    System.out.println(IP + ": " + opcode + " " + opcodeArg);
                } else {
                    System.out.println(IP + ": " + opcode);
                }
            }
            switch (opcode) {
                case call:
                    int newFP = stack.size();
                    stack.push(new Integer(FP));
                    FP = newFP;
                    stack.push(new Integer(IP+1)); //next instruction position
                    //FP = newFP;
                    IP = opcodeArg;                            
                    //System.out.println(stack);
                    continue;
                case pop:
                    for(int i = 0; i < opcodeArg; i++){
                        stack.pop();
                    }
                    break;
                case lalloc:
                    for(int i = 0; i < opcodeArg; i++){
                        stack.push(null);
                    }
                    break;
                case lload:
                    Value<?> lload = stack.get(FP+opcodeArg);
                    stack.push(lload);
                    break;
                case lstore:
                    Value<?> lstore = stack.pop();
                    stack.set(FP+opcodeArg,lstore);
                    break;
                case retval:
                    Value<?> x = stack.pop();
                    int lvars = stack.size()-FP-2; //stackSize - FramePosition - 2(reserve positions) = number of localVariables
                    for (int i = 0; i < lvars; i++){
                        stack.pop();
                    }
                    IP = stack.pop().toInt();
                    FP = stack.pop().toInt();
                    for (int i = 0; i < opcodeArg; i++){
                        stack.pop();
                    }
                    stack.push(x);
                    continue;
                case ret:
                    int retlvars = stack.size()-FP-2; //stackSize - FramePosition - 2(reserve positions) = number of localVariables
                    for (int i = 0; i < retlvars; i++){
                        stack.pop();
                    }
                    IP = stack.pop().toInt();
                    FP = stack.pop().toInt();
                    for (int i = 0; i < opcodeArg; i++){
                        stack.pop();
                    }
                    continue;
                case iconst:
                    stack.push(new storage.Integer(opcodeArg));
                    break;
                case iadd:
                    errorHandler.checkStackSize(stack.size(), 2, "iadd");
                    Value<?> addR = stack.pop();
                    Value<?> addL = stack.pop();
                    errorHandler.checkValuesTypes(addL, addR, "int", "iadd");
                    stack.push(new storage.Integer(addL.toInt() + addR.toInt()));
                    break;
                case isub:
                    errorHandler.checkStackSize(stack.size(), 2, "isub");
                    Value<?> subR = stack.pop();
                    Value<?> subL = stack.pop();
                    errorHandler.checkValuesTypes(subL, subR, "int", "isub");
                    stack.push(new storage.Integer(subL.toInt() - subR.toInt()));
                    break;
                case imult:
                    errorHandler.checkStackSize(stack.size(), 2, "imult");
                    Value<?> multR = stack.pop();
                    Value<?> multL = stack.pop();
                    errorHandler.checkValuesTypes(multL, multR, "int", "imult");
                    stack.push(new storage.Integer(multL.toInt() * multR.toInt()));
                    break;
                case idiv:
                    errorHandler.checkStackSize(stack.size(), 2, "idiv");
                    Value<?> divR = stack.pop();
                    Value<?> divL = stack.pop();
                    errorHandler.checkValuesTypes(divL, divR, "int", "idiv");
                    stack.push(new storage.Integer(divL.toInt() / divR.toInt()));
                    break;
                case imod:
                    errorHandler.checkStackSize(stack.size(), 2, "imod");
                    Value<?> imodR = stack.pop();
                    Value<?> imodL = stack.pop();
                    errorHandler.checkValuesTypes(imodL, imodR, "int", "imod");
                    stack.push(new storage.Integer(imodL.toInt() % imodR.toInt()));
                    break;
                case iuminus:
                    errorHandler.checkStackSize(stack.size(), 1, "iuminus");
                    Value<?> iuminus = stack.pop();
                    errorHandler.checkValuesTypes(iuminus, "int", "iuminus");
                    stack.push(new storage.Integer(-iuminus.toInt()));
                    break;
                case ieq:
                    errorHandler.checkStackSize(stack.size(), 2, "ieq");
                    Value<?> ieqR = stack.pop();
                    Value<?> ieqL = stack.pop();
                    errorHandler.checkValuesTypes(ieqL, ieqR, "int", "ieq");
                    stack.push(new storage.Boolean(ieqL.toInt() == ieqR.toInt()));
                    break;
                case ineq:
                    errorHandler.checkStackSize(stack.size(), 2, "ineq");
                    Value<?> ineqR = stack.pop();
                    Value<?> ineqL = stack.pop();
                    errorHandler.checkValuesTypes(ineqL, ineqR, "int", "ineq");
                    stack.push(new storage.Boolean(ineqL.toInt() != ineqR.toInt()));
                    break;
                case ilt:
                    errorHandler.checkStackSize(stack.size(), 2, "ilt");
                    Value<?> iltR = stack.pop();
                    Value<?> iltL = stack.pop();
                    errorHandler.checkValuesTypes(iltL, iltR, "int", "ilt");
                    stack.push(new storage.Boolean(iltL.toInt() < iltR.toInt()));
                    break;
                case ileq:
                    errorHandler.checkStackSize(stack.size(), 2, "ileq");
                    Value<?> ilecR = stack.pop();
                    Value<?> ilecL = stack.pop();
                    errorHandler.checkValuesTypes(ilecL, ilecR, "int", "ileq");
                    stack.push(new storage.Boolean(ilecL.toInt() <= ilecR.toInt()));
                    break;
                case itod:
                    errorHandler.checkStackSize(stack.size(), 1, "itod");
                    Value<?> itod = stack.pop();
                    errorHandler.checkValuesTypes(itod, "int", "itod");
                    stack.push(new Real((double) itod.toInt()));
                    break;
                case itos:
                    errorHandler.checkStackSize(stack.size(), 1, "itos");
                    Value<?> itos = stack.pop();
                    errorHandler.checkValuesTypes(itos, "int", "itos");
                    stack.push(new Text(String.valueOf(itos.toInt())));
                    break;
                case iprint:
                    errorHandler.checkStackSize(stack.size(), 1, "iprint");
                    Value<?> iprint = stack.pop();
                    errorHandler.checkValuesTypes(iprint, "int", "iprint");
                    System.out.println(iprint.toInt());
                    break;
                case dconst:
                    errorHandler.checkConstantPoolSize(constantPool.size(), opcodeArg, "dconst");
                    Value<?> dconst = constantPool.get(opcodeArg);
                    errorHandler.checkValuesTypes(dconst, "real", "dconst");
                    stack.push(new Real(dconst.toDouble()));
                    break;
                case duminus:
                    errorHandler.checkStackSize(stack.size(), 1, "duminus");
                    Value<?> duminus = stack.pop();
                    errorHandler.checkValuesTypes(duminus, "real", "duminus");
                    stack.push(new Real(-duminus.toDouble()));
                    break;
                case dadd:
                    errorHandler.checkStackSize(stack.size(), 2, "dadd");
                    Value<?> daddR = stack.pop();
                    Value<?> daddL = stack.pop();
                    errorHandler.checkValuesTypes(daddL, daddR, "real", "dadd");
                    stack.push(new Real(daddL.toDouble() + daddR.toDouble()));
                    break;
                case dsub:
                    errorHandler.checkStackSize(stack.size(), 2, "dsub");
                    Value<?> dsubR = stack.pop();
                    Value<?> dsubL = stack.pop();
                    errorHandler.checkValuesTypes(dsubL, dsubR, "real", "dsub");
                    stack.push(new Real(dsubL.toDouble() - dsubR.toDouble()));
                    break;
                case dmult:
                    errorHandler.checkStackSize(stack.size(), 2, "dmult");
                    Value<?> dmultR = stack.pop();
                    Value<?> dmultL = stack.pop();
                    errorHandler.checkValuesTypes(dmultL, dmultR, "real", "dmult");
                    stack.push(new Real(dmultL.toDouble() * dmultR.toDouble()));
                    break;
                case ddiv:
                    errorHandler.checkStackSize(stack.size(), 2, "ddiv");
                    Value<?> ddivR = stack.pop();
                    Value<?> ddivL = stack.pop();
                    errorHandler.checkValuesTypes(ddivL, ddivR, "real", "ddiv");
                    if (ddivR.toDouble() != 0) {
                        stack.push(new Real(ddivL.toDouble() / ddivR.toDouble()));
                    } else {
                        errorHandler.error("Cannot divide by zero");
                    }
                    break;
                case deq:
                    errorHandler.checkStackSize(stack.size(), 2, "deq");
                    Value<?> ddeqR = stack.pop();
                    Value<?> ddeqL = stack.pop();
                    errorHandler.checkValuesTypes(ddeqL, ddeqR, "real", "deq");
                    stack.push(new storage.Boolean(ddeqL.toDouble() == ddeqR.toDouble()));
                    break;
                case dneq:
                    errorHandler.checkStackSize(stack.size(), 2, "dneq");
                    Value<?> dneqR = stack.pop();
                    Value<?> dneqL = stack.pop();
                    errorHandler.checkValuesTypes(dneqL, dneqR, "real", "dneq");
                    stack.push(new storage.Boolean(dneqL.toDouble() != dneqR.toDouble()));
                    break;
                case dlt:
                    errorHandler.checkStackSize(stack.size(), 2, "dlt");
                    Value<?> dltR = stack.pop();
                    Value<?> dltL = stack.pop();
                    errorHandler.checkValuesTypes(dltL, dltR, "real", "dlt");
                    stack.push(new storage.Boolean(dltL.toDouble() < dltR.toDouble()));
                    break;
                case dleq:
                    errorHandler.checkStackSize(stack.size(), 2, "dleq");
                    Value<?> dleqR = stack.pop();
                    Value<?> dleqL = stack.pop();
                    errorHandler.checkValuesTypes(dleqL, dleqR, "real", "dleq");
                    stack.push(new storage.Boolean(dleqL.toDouble() <= dleqR.toDouble()));
                    break;
                case dtos:
                    errorHandler.checkStackSize(stack.size(), 1, "dtos");
                    Value<?> dtos = stack.pop();
                    errorHandler.checkValuesTypes(dtos, "real", "dtos");
                    stack.push(new Text(String.valueOf(dtos.toDouble())));
                    break;
                case dprint:
                    errorHandler.checkStackSize(stack.size(), 1, "dprint");
                    Value<?> dprint = stack.pop();
                    errorHandler.checkValuesTypes(dprint, "real", "dprint");
                    System.out.println(dprint.toDouble());
                    break;
                case sconst:
                    errorHandler.checkConstantPoolSize(constantPool.size(), opcodeArg, "sconst");
                    Value<?> sconst = constantPool.get(opcodeArg);
                    errorHandler.checkValuesTypes(sconst, "string", "sconst");
                    stack.push(new Text(sconst.toString()));
                    break;
                case sadd:
                    errorHandler.checkStackSize(stack.size(), 2, "sadd");
                    Value<?> saddR = stack.pop();
                    Value<?> saddL = stack.pop();
                    errorHandler.checkValuesTypes(saddL, saddR, "string", "sadd");
                    stack.push(new Text(saddL.toString().concat(saddR.toString())));
                    break;
                case sprint:
                    errorHandler.checkStackSize(stack.size(), 1, "sprint");
                    Value<?> sprint = stack.pop();
                    errorHandler.checkValuesTypes(sprint, "string", "sprint");
                    System.out.println(sprint.toString());
                    break;
                case seq:
                    errorHandler.checkStackSize(stack.size(), 2, "seq");
                    Value<?> seqR = stack.pop();
                    Value<?> seqL = stack.pop();
                    errorHandler.checkValuesTypes(seqL, seqR, "string", "seq");
                    stack.push(new storage.Boolean(seqL.toString().equals(seqR.toString())));
                    break;
                case sneq:
                    errorHandler.checkStackSize(stack.size(), 2, "sneq");
                    Value<?> sneqR = stack.pop();
                    Value<?> sneqL = stack.pop();
                    errorHandler.checkValuesTypes(sneqL, sneqR, "string", "sneq");
                    stack.push(new storage.Boolean(!sneqL.toString().equals(sneqR.toString())));
                    break;
                case beq:
                    errorHandler.checkStackSize(stack.size(), 2, "beq");
                    Value<?> bRight = stack.pop();
                    Value<?> bLeft = stack.pop();
                    errorHandler.checkValuesTypes(bLeft, bRight, "bool", "beq");
                    stack.push(new storage.Boolean(bLeft.toBoolean() == bRight.toBoolean()));
                    break;
                case bneq:
                    errorHandler.checkStackSize(stack.size(), 2, "bneq");
                    Value<?> bneqRight = stack.pop();
                    Value<?> bneqLeft = stack.pop();
                    errorHandler.checkValuesTypes(bneqLeft, bneqRight, "bool", "bneq");
                    stack.push(new storage.Boolean(bneqLeft.toBoolean() != bneqRight.toBoolean()));
                    break;
                case bprint:
                    errorHandler.checkStackSize(stack.size(), 1, "bprint");
                    Value<?> bprint = stack.pop();
                    errorHandler.checkValuesTypes(bprint, "bool", "bprint");
                    System.out.println(bprint.toBoolean()); // Print top of the boolean stack
                    break;
                case btos:
                    errorHandler.checkStackSize(stack.size(), 1, "btos");
                    Value<?> btos = stack.pop();
                    errorHandler.checkValuesTypes(btos, "bool", "btos");
                    stack.push(new Text(String.valueOf(btos.toBoolean())));
                    break;
                case jump:
                    IP = opcodeArg;
                    continue;
                case jumpt:
                    errorHandler.checkStackSize(stack.size(), 1, "jumpt");
                    Value<?> jumpt = stack.pop();
                    errorHandler.checkValuesTypes(jumpt, "bool", "jumpt");
                    if (jumpt.toBoolean()) {
                        IP = opcodeArg;
                        continue;
                    }
                    break;
                case jumpf:
                    errorHandler.checkStackSize(stack.size(), 1, "jumpf");
                    Value<?> jumptf = stack.pop();
                    errorHandler.checkValuesTypes(jumptf, "bool", "jumpf");
                    if (!jumptf.toBoolean()) {
                        IP = opcodeArg;
                        continue;
                    }
                    break;
                case halt:
                    System.exit(1);
                    break;
                case galloc:
                    for (int j = 0; j < opcodeArg; j++) {
                        globals.add(null); // Initialize with null or a default value
                    }
                    break;
                case gload:
                    errorHandler.checkGlobalsSize(globals.size(), opcodeArg,"gload");
                    if (globals.get(opcodeArg) != null) {
                        stack.push(globals.get(opcodeArg));
                    } else { errorHandler.error(" global address " + opcodeArg + " was not initialized."); }
                    break;
                case gstore:
                    errorHandler.checkGlobalsSize(globals.size(), opcodeArg,"gload");
                    errorHandler.checkStackSize(stack.size(), 1, "gstore");
                    Value<?> valueToStore = stack.pop();
                    globals.set(opcodeArg, valueToStore);
                    break;

                case and:
                    errorHandler.checkStackSize(stack.size(), 2, "and");
                    Value<?> andRight = stack.pop();
                    Value<?> andLeft = stack.pop();
                    errorHandler.checkValuesTypes(andLeft, andRight, "bool", "and");
                    stack.push(new storage.Boolean(andLeft.toBoolean() && andRight.toBoolean()));
                    break;
                case or:
                    errorHandler.checkStackSize(stack.size(), 2, "or");
                    Value<?> orRight = stack.pop();
                    Value<?> orLeft = stack.pop();
                    errorHandler.checkValuesTypes(orLeft, orRight, "bool", "or");
                    stack.push(new storage.Boolean(orLeft.toBoolean() || orRight.toBoolean()));
                    break;
                case not:
                    errorHandler.checkStackSize(stack.size(), 1, "not");
                    Value<?> not = stack.pop();
                    errorHandler.checkValuesTypes(not, "bool", "not");
                    stack.push(new storage.Boolean(!not.toBoolean()));
                    break;
                case tconst:
                    stack.push(new storage.Boolean(true));
                    break;
                case fconst:
                    stack.push(new storage.Boolean(false));
                    break;

                default:
                    System.err.println("Unhandled opcode: " + opcode);
                    System.exit(1);
            }
            IP++;
        }
        errorHandler.error("Halt instruction could not be reached!");
    }
}
