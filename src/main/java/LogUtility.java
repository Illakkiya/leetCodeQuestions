import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogUtility {
    final static String OutFile = "output.log";
    static BufferedWriter bw ;

    static {
        try{
            bw = new BufferedWriter(new FileWriter(OutFile));

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    static void appendToLogFile(String s){
        try{
            bw.append(s);
            bw.newLine();
            bw.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    static void closeFile(){
        try {
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        // Simulate different test cases
        appendToLogFile("Test case 1: This is the output for test case 1.");
        appendToLogFile("Test case 2: This is the output for test case 2.");
        appendToLogFile("Test case 3: This is the output for test case 3.");

        // Close the log file when done
        closeFile();
    }
}
