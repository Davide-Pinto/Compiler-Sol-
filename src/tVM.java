import tVM.Decode;
import tVM.ExecuteVMInstructions;

public class tVM {

    public static void main(String[] args){
        boolean trace = false;
        // Check command-line arguments for trace mode
        for (String arg : args) {
            if ("-trace".equals(arg)) {
                trace = true;
                System.out.println("The program is in trace mode.");
            }
        }
        String inputFile = null;
        if (args.length > 0) {
            inputFile = args[0];
        }
        if (inputFile != null) {
            // Perform decoding
            Decode decode = new Decode();
            decode.execute(inputFile, trace);
            // Execute VM instructions
            ExecuteVMInstructions vm = new ExecuteVMInstructions(decode.constantPool, decode.instructionPool);
            vm.execute(trace);
        }else{
            System.err.println("inputFile is null");
            System.exit(1);
        }
    }
}
