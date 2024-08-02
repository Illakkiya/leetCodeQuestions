import java.io.*;

public class temp {
    static String filePath = "temp.out";
    static BufferedWriter buffWriter;
    static {
        try {
            buffWriter  = new BufferedWriter(new FileWriter(filePath));
        } catch (IOException ignored) {

        }
    }

    synchronized static void appendToFile(String s)
    {
        try {
            buffWriter.append(s);
            buffWriter.flush();
            buffWriter.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    static void closeWriter()
    {
        try {
            buffWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        temp.appendToFile("Hello");
        temp.appendToFile("Test Passed");
        temp.appendToFile("failed");
        temp.closeWriter();

    }


}
