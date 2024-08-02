import java.io.*;
//Read input file and copy it to new file if there are vowels present in the line
public class ReadWrite {
    private BufferedWriter bw;
    private BufferedReader br;

    public ReadWrite(String outputFile) {
        try {
            bw = new BufferedWriter(new FileWriter(outputFile));
        } catch (IOException e) {
            throw new RuntimeException("Error opening BufferedWriter: " + e.getMessage());
        }
    }

    public void readFile(String fileName){
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null) {
                if(line.matches(".*[aeiou].*")){
                  appendData(line);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void appendData(String inputString){
        try {
            bw.append(inputString);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error appending data: " + e.getMessage());
        }
    }

    public void closeWriter(){
        try {
            if (bw != null)
                bw.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing BufferedWriter: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ReadWrite rw = new ReadWrite("readWriteOut.txt");
        rw.readFile(System.getProperty("user.dir")+"/src/main/resources/input.txt");
        rw.appendData("New line");
        rw.closeWriter();
    }
}
