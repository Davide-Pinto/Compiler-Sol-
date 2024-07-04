package tAssembler;

import Tasm.TasmBaseListener;
import Tasm.TasmParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.security.Key;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SemanticCheck extends TasmBaseListener {

    private Boolean hasHaltInstruction = false;
    public  int numberOfSemanticErrors = 0;
    private final Set<String> labels = new HashSet<>();
    private final HashMap<String, Token> jumpLabels = new HashMap<>();


    ErrorHandler errorHandler = new ErrorHandler();
    public void exitHalt(Tasm.TasmParser.HaltContext ctx) {
        hasHaltInstruction = true;
    }

    public void exitJump(Tasm.TasmParser.JumpContext ctx) {
        String label = ctx.LABEL().getText();
        jumpLabels.put(label, ctx.start);
    }
    public void exitJumpt(Tasm.TasmParser.JumptContext ctx) {
        String label = ctx.LABEL().getText();
        jumpLabels.put(label, ctx.start);
    }
    public void exitJumpf(Tasm.TasmParser.JumpfContext ctx) {
        String label = ctx.LABEL().getText();
        jumpLabels.put(label, ctx.start);
    }
    public void exitLabels(TasmParser.LabelsContext ctx) {
        for(TerminalNode label: ctx.LABEL()){
            String l = label.toString();
            if(labels.contains(l)){
                errorHandler.error(ctx.start,"Labels must be unique, error in Label: " + label);
            }
            else{
                labels.add(l);
            }
        }
    }

    public void exitS(TasmParser.SContext ctx) {
        for (Map.Entry<String, Token> entry : jumpLabels.entrySet()) {
            if (!labels.contains(entry.getKey())) {
                errorHandler.error(entry.getValue(), "Semantic Error, Label '" + entry.getKey() + "' not found.");
            }
        }
        if(!hasHaltInstruction){
            errorHandler.error(ctx.stop, "Semantic Error, missing halt command");
        }

        numberOfSemanticErrors += errorHandler.numberOfErrors;

        if(numberOfSemanticErrors > 0){
            System.err.println(numberOfSemanticErrors + " Semantic Errors Detected, exiting program");
            System.exit(1);
        }
    }
}