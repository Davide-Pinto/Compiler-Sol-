package solCompiler;

import org.antlr.v4.runtime.misc.Pair;
import storage.Integer;
import storage.Value;
import tVM.Opcode;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateTasmFile {
    private final List<Pair<Opcode, Value<?>>> constantPool;
    private final List<Pair<Opcode, Integer>> instructionPool;
    private final String outputFile;

    public CreateTasmFile(List<Pair<Opcode, Value<?>>> constantPool, List<Pair<Opcode, Integer>> instructionPool, String outputFile) {
        this.constantPool = constantPool;
        this.instructionPool = instructionPool;
        this.outputFile = outputFile;
    }

    public void writeTasmFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            int instructionPosition = 0;
            for (Pair<Opcode, Integer> opcodeIntegerPair : instructionPool) {
                Opcode opcode = opcodeIntegerPair.a;
                Integer opcodeArg = opcodeIntegerPair.b;
                String label = "L"+ instructionPosition + ": ";
                writer.write(label);
                if (opcodeArg != null) {
                    writeOpcodeWithArgument(writer, opcode, opcodeArg);
                } else {
                    writeOpcode(writer, opcode);
                }
                instructionPosition++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeOpcodeWithArgument(BufferedWriter writer, Opcode opcode, Integer opcodeArg) throws IOException {
        writer.write(String.valueOf(opcode));
        writer.write(" ");

        if (opcode.equals(Opcode.dconst)) {
            writeDoubleConstant(writer, opcodeArg);
        } else if (opcode.equals(Opcode.sconst)) {
            writeStringConstant(writer, opcodeArg);
        }else if (opcode.equals(Opcode.jump) || opcode.equals(Opcode.jumpf) || opcode.equals(Opcode.jumpt) || opcode.equals(Opcode.call)) {
            String label = "L";
            writer.write(label);
            writer.write(String.valueOf(opcodeArg));
        } else {
            writer.write(String.valueOf(opcodeArg));
        }

        writer.newLine();
    }

    private void writeDoubleConstant(BufferedWriter writer, Integer opcodeArg) throws IOException {
        writer.write(String.valueOf(constantPool.get(opcodeArg.toInt()).b));
    }

    private void writeStringConstant(BufferedWriter writer, Integer opcodeArg) throws IOException {
        String stringValue = "\"" + constantPool.get(opcodeArg.toInt()).b + "\"";
        writer.write(stringValue);
    }

    private void writeOpcode(BufferedWriter writer, Opcode opcode) throws IOException {
        writer.write(String.valueOf(opcode));
        writer.newLine();
    }

}