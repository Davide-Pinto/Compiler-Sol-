
import storage.*;
import storage.Integer;
//import solCompiler.SemanticAnalysis;
import Sol.SolParser;
import Sol.SolLexer;
import solCompiler.*;
import tVM.Opcode;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;


public class solCompiler {

    public static void main(String[] args) {
        boolean asm = false;
        boolean tasm = false;
        if (args.length == 0) {
            System.out.println("Usage: java solCompiler input_file.Sol");
            return;
        }
        String inputFile = args[0];
        String outputFile = inputFile.replace(".sol", ".tbc");
        String outputTasmFile = inputFile.replace(".sol", ".tasm");
        for (String arg : args) {
            //-asm mode prints the generated instructions that will be used by tVM
            if ("-asm".equals(arg)) {
                asm = true;
                System.out.println("The program is in asm mode.");
            }
            //create Tasm File
            if ("-tasm".equals(arg)) {
                tasm = true;
            }
        }

        try (InputStream is = new FileInputStream(inputFile);
             DataOutputStream dout = new DataOutputStream(new FileOutputStream(outputFile))) {

            CharStream input = CharStreams.fromStream(is);
            SolLexer lexer = new SolLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SolParser parser = new SolParser(tokens);
            ParseTree tree = parser.s();
            ParseTreeWalker walker = new ParseTreeWalker();

            int numberOfSyntaxErrors = parser.getNumberOfSyntaxErrors();
            if(numberOfSyntaxErrors == 0) {

                // Semantic Check
                DefPhase def = new DefPhase(); //define variables phase
                walker.walk(def,tree);

                RefPhase ref = new RefPhase(def.global,def.scopes); //Refinement phase
                walker.walk(ref,tree);

                int errors = def.error + ref.error;
                if(errors > 0){
                    System.err.println(errors + " Semantic errors detected, exiting program.");
                    System.exit(1);
                }

                // Sol Instruction Generation with Visitor
                CodeGeneratorVisitor loader = new CodeGeneratorVisitor(ref.types,def.scopes,def.global);
                loader.visit(tree);

                for (Value<?> val : loader.bytecodes) {
                    if (val instanceof Integer) {
                        dout.writeInt(((Integer) val).getValue());
                    } else if (val instanceof Text) {
                        dout.writeChars(((Text) val).getValue());
                    }
                    else {
                        throw new IllegalArgumentException("unknown type of data: " + val.getValue());
                    }
                }
                if(asm) {
                    System.out.println();
                    System.out.println("Constant Pool:");
                    for (int i = 0; i < loader.constantPool.size(); i++){
                        System.out.println(i+":" + loader.constantPool.get(i).b);
                    }
                    System.out.println();
                    System.out.println("Instruction Pool:");
                    for (int i = 0; i < loader.instructionPool.size(); i++){
                        Opcode opcode = loader.instructionPool.get(i).a;
                        Integer opcode_arg = loader.instructionPool.get(i).b;
                        if(opcode_arg != null){
                            System.out.println(i+":" + opcode + " " + opcode_arg);
                        }else{
                            System.out.println(i+":" + opcode);
                        }
                    }
                }
                if(tasm){
                    CreateTasmFile TasmFile = new CreateTasmFile(loader.constantPool,loader.instructionPool,outputTasmFile);
                    TasmFile.writeTasmFile();
                    System.out.println("Saving TasmInstructions in: " + outputTasmFile);
                }
                System.out.println("Saving Bytecodes in: " + outputFile);
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }
    }
}
