/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/

import org.antlr.v4.runtime.misc.Pair;
import storage.*;
import storage.Boolean;
import storage.Integer;
import tAssembler.SemanticCheck;
import tAssembler.TasmInstructionGenerator;
import Tasm.TasmParser;
import Tasm.TasmLexer;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.Iterator;
import tVM.Opcode;


public class tAssembler {

    public static void main(String[] args) {
        boolean debugMode = false;
        if (args.length == 0) {
            System.out.println("Usage: java tAssembler input_file.tasm");
            return;
        }
        String inputFile = args[0];
        String outputFile = inputFile.replace(".tasm", ".tbc");

        for (String arg : args) {
            if ("-debug".equals(arg)) {
                debugMode = true;
                System.out.println("The program is in debug mode.");
            }
        }

        try (InputStream is = new FileInputStream(inputFile);
             DataOutputStream dout = new DataOutputStream(new FileOutputStream(outputFile))) {

            CharStream input = CharStreams.fromStream(is);
            TasmLexer lexer = new TasmLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TasmParser parser = new TasmParser(tokens);
            ParseTree tree = parser.s();
            ParseTreeWalker walker = new ParseTreeWalker();
            int numberOfSyntaxErrors = parser.getNumberOfSyntaxErrors();
            if(numberOfSyntaxErrors == 0) {
                // Semantic Check
                SemanticCheck eval = new SemanticCheck();
                walker.walk(eval, tree);

                // TASM Instruction Generation
                TasmInstructionGenerator exe = new TasmInstructionGenerator();
                walker.walk(exe, tree);
                for (Value<?> val : exe.bytecodes) {
                    if (val instanceof Codes) {
                        dout.writeByte(((Codes) val).getValue().getOpcode());
                    } else if (val instanceof Integer) {
                        dout.writeInt(((Integer) val).getValue());
                    } else if (val instanceof Text) {
                        dout.writeChars(((Text) val).getValue());
                    }
                    else {
                        throw new IllegalArgumentException("unknown type of data: " + val.getValue());
                    }
                }

                if (debugMode) {
                    // Print Constant Pool
                    System.out.println();
                    System.out.println("Constant Pool:");
                    int constantIndex = 0;
                    for (Pair<Opcode, Value<?>> constant : exe.constantPool) {
                        System.out.println( constantIndex + ":" + constant.b.getValue().toString());
                        constantIndex++;
                    }
                    System.out.println();

                    // Print Instruction Pool
                    System.out.println("Instruction Pool:");
                    int instructionIndex = 0;
                    for (Pair<Opcode, Value<?>> instruction : exe.instructionPool) {
                        System.out.print(instructionIndex + ": " + instruction.a);
                        if (instruction.b != null) {
                            System.out.print(" " + instruction.b);
                        }
                        System.out.println();
                        instructionIndex++;
                    }
                }

            }
            System.out.println("Saving Bytecodes in: " + outputFile);
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }
}
