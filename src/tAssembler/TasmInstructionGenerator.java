package tAssembler;

import Tasm.TasmBaseListener;
import Tasm.TasmParser;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import storage.*;
import storage.Integer;
import tVM.Opcode;

import java.util.*;

public class TasmInstructionGenerator extends TasmBaseListener {
    private final Map<String, java.lang.Integer> labelMap = new HashMap<>();

    public ArrayList<Value<?>> bytecodes = new ArrayList<>();
    public List<Pair<Opcode, Value<?>>> constantPool = new ArrayList<>();
    public List<Pair<Opcode, Value<?>>> instructionPool = new ArrayList<>();


    //emit functions emit instructions to the instruction pool array List
    private void emit(Opcode opcode, int arg) {
        instructionPool.add(new Pair<>(opcode, new Integer(arg)));
    }

    private void emit(Opcode opcode, String arg) {
        instructionPool.add(new Pair<>(opcode, new Text(arg)));
    }
    private void emit(Opcode opcode) {
        instructionPool.add(new Pair<>(opcode, null));
    }
    private int getIntValue(ParseTree ctx){
        return java.lang.Integer.parseInt(ctx.getText());
    }

    private double getDoubleValue(ParseTree ctx){
        return Double.parseDouble(ctx.getText());
    }

    public void exitLabels(TasmParser.LabelsContext ctx) {
        for (TerminalNode label: ctx.LABEL()) {
            labelMap.put(label.getText(), instructionPool.size());
        }
    }

    public void exitIconst(Tasm.TasmParser.IconstContext ctx) {
        emit(Opcode.iconst, getIntValue(ctx.INT()));
    }

    public void exitDconst(Tasm.TasmParser.DconstContext ctx) {
        emit(Opcode.dconst, constantPool.size());
        constantPool.add(new Pair<>(Opcode.dpool, new Real(getDoubleValue(ctx.DOUBLE()))));
    }

    public void exitSconst(Tasm.TasmParser.SconstContext ctx) {
        String stringValue = ctx.STRING().getText();
        stringValue = stringValue.replace("\"", "");
        emit(Opcode.sconst, constantPool.size());
        constantPool.add(new Pair<>(Opcode.spool, new Text(stringValue)));
    }

    public void exitJump(Tasm.TasmParser.JumpContext ctx) {
        emit(Opcode.jump, ctx.LABEL().getText());
    }

    public void exitJumpt(Tasm.TasmParser.JumptContext ctx) {
        emit(Opcode.jumpt, ctx.LABEL().getText());
    }

    public void exitJumpf(Tasm.TasmParser.JumpfContext ctx) {
        emit(Opcode.jumpf, ctx.LABEL().getText());
    }

    public void exitGalloc(Tasm.TasmParser.GallocContext ctx) {
        emit(Opcode.galloc, getIntValue(ctx.INT()));
    }

    public void exitGload(Tasm.TasmParser.GloadContext ctx) {
        emit(Opcode.gload, getIntValue(ctx.INT()));
    }

    public void exitGstore(Tasm.TasmParser.GstoreContext ctx) {
        emit(Opcode.gstore, getIntValue(ctx.INT()));
    }

    public void exitIPrint(Tasm.TasmParser.IPrintContext ctx) {
        emit(Opcode.iprint);
    }

    public void exitIuminus(Tasm.TasmParser.IuminusContext ctx) {
        emit(Opcode.iuminus);
    }

    public void exitIAdd(Tasm.TasmParser.IAddContext ctx) {
        emit(Opcode.iadd);
    }

    public void exitISub(Tasm.TasmParser.ISubContext ctx) {
        emit(Opcode.isub);
    }

    public void exitIlt(Tasm.TasmParser.IltContext ctx) {
        emit(Opcode.ilt);
    }

    public void exitIMult(Tasm.TasmParser.IMultContext ctx) {
        emit(Opcode.imult);
    }

    public void exitIDiv(Tasm.TasmParser.IDivContext ctx) {
        emit(Opcode.idiv);
    }

    public void exitIMod(Tasm.TasmParser.IModContext ctx) {
        emit(Opcode.imod);
    }

    public void exitIEq(Tasm.TasmParser.IEqContext ctx) {
        emit(Opcode.ieq);
    }

    public void exitINeq(Tasm.TasmParser.INeqContext ctx) {
        emit(Opcode.ineq);
    }

    public void exitILeq(Tasm.TasmParser.ILeqContext ctx) {
        emit(Opcode.ileq);
    }

    public void exitITod(Tasm.TasmParser.ITodContext ctx) {
        emit(Opcode.itod);
    }

    public void exitITos(Tasm.TasmParser.ITosContext ctx) {
        emit(Opcode.itos);
    }

    public void exitDPrint(Tasm.TasmParser.DPrintContext ctx) {
        emit(Opcode.dprint);
    }

    public void exitDuminus(Tasm.TasmParser.DuminusContext ctx) {
        emit(Opcode.duminus);
    }

    public void exitDAdd(Tasm.TasmParser.DAddContext ctx) {
        emit(Opcode.dadd);
    }

    public void exitDSub(Tasm.TasmParser.DSubContext ctx) {
        emit(Opcode.dsub);
    }

    public void exitDMult(Tasm.TasmParser.DMultContext ctx) {
        emit(Opcode.dmult);
    }

    public void exitDDiv(Tasm.TasmParser.DDivContext ctx) {
        emit(Opcode.ddiv);
    }

    public void exitDEq(Tasm.TasmParser.DEqContext ctx) {
        emit(Opcode.deq);
    }

    public void exitDNeq(Tasm.TasmParser.DNeqContext ctx) {
        emit(Opcode.dneq);
    }

    public void exitDlt(Tasm.TasmParser.DltContext ctx) {
        emit(Opcode.dlt);
    }

    public void exitDleq(Tasm.TasmParser.DleqContext ctx) {
        emit(Opcode.dleq);
    }

    public void exitDtos(Tasm.TasmParser.DtosContext ctx) {
        emit(Opcode.dtos);
    }

    public void exitSPrint(Tasm.TasmParser.SPrintContext ctx) {
        emit(Opcode.sprint);
    }

    public void exitSAdd(Tasm.TasmParser.SAddContext ctx) {
        emit(Opcode.sadd);
    }

    public void exitSeq(Tasm.TasmParser.SeqContext ctx) {
        emit(Opcode.seq);
    }

    public void exitSNeq(Tasm.TasmParser.SNeqContext ctx) {
        emit(Opcode.sneq);
    }

    public void exitBeq(Tasm.TasmParser.BeqContext ctx) {
        emit(Opcode.beq);
    }

    public void exitBneq(Tasm.TasmParser.BneqContext ctx) {
        emit(Opcode.bneq);
    }

    public void exitBtos(Tasm.TasmParser.BtosContext ctx) {
        emit(Opcode.btos);
    }

    public void exitAnd(Tasm.TasmParser.AndContext ctx) {
        emit(Opcode.and);
    }

    public void exitOr(Tasm.TasmParser.OrContext ctx) {
        emit(Opcode.or);
    }

    public void exitNot(Tasm.TasmParser.NotContext ctx) {
        emit(Opcode.not);
    }

    public void exitTconst(Tasm.TasmParser.TconstContext ctx) {
        emit(Opcode.tconst);
    }

    public void exitFconst(Tasm.TasmParser.FconstContext ctx) {
        emit(Opcode.fconst);
    }

    public void exitBprint(Tasm.TasmParser.BprintContext ctx) {
        emit(Opcode.bprint);
    }
    public void exitRet(TasmParser.RetContext ctx) {
        emit(Opcode.ret, getIntValue(ctx.INT()));
    }
    public void exitRetval(TasmParser.RetvalContext ctx) {
        emit(Opcode.retval, getIntValue(ctx.INT()));
    }
    public void exitCall(TasmParser.CallContext ctx) {
        emit(Opcode.call, ctx.LABEL().getText());
    }

    public void exitPop(TasmParser.PopContext ctx) {
        emit(Opcode.pop, getIntValue(ctx.INT()));
    }

    public void exitLstore(TasmParser.LstoreContext ctx) {
        emit(Opcode.lstore, getIntValue(ctx.INT()));
    }
    public void exitLload(TasmParser.LloadContext ctx) {
        emit(Opcode.lload, getIntValue(ctx.INT()));
    }

    public void exitLalloc(TasmParser.LallocContext ctx) {
        emit(Opcode.lalloc, getIntValue(ctx.INT()));
    }

    public void exitHalt(Tasm.TasmParser.HaltContext ctx) {
        emit(Opcode.halt);
    }

    public void exitS(TasmParser.SContext ctx) {

        //puts the constant pool in the bytecodes ArrayList
        for (Pair<Opcode, Value<?>> opcodeValuePair : constantPool) {
            bytecodes.add(new Integer(opcodeValuePair.a.getOpcode()));
            char[] charArray = opcodeValuePair.b.getValue().toString().toCharArray();
            bytecodes.add(new Integer(charArray.length));
            for (char c : charArray) {
                bytecodes.add(new Text(String.valueOf(c)));
            }
        }

        //substitutes the labels in jump, jumpt, jumpf for the instruction number that it refers to
        for (int i = 0; i < instructionPool.size(); i++) {
            Opcode op = instructionPool.get(i).a;
            if (op == Opcode.jump || op == Opcode.jumpt || op == Opcode.jumpf || op == Opcode.call) {
                int arg = labelMap.get(instructionPool.get(i).b.toString());
                instructionPool.set(i, new Pair<>(op, new Integer(arg)));
            }
        }
        //puts the instruction pool in the bytecodes ArrayList
        for (Pair<Opcode, Value<?>> opcodeIntegerPair : instructionPool) {
            bytecodes.add(new Integer(opcodeIntegerPair.a.getOpcode()));
            if (opcodeIntegerPair.b != null) {
                bytecodes.add(new Integer((int) opcodeIntegerPair.b.getValue()));
            }
        }
    }
}
