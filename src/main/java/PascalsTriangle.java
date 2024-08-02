import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    //formula for binomial expansion k*(line-i/i)
    public List<List<Integer>> constructTriangle(int rows){
        List<List<Integer>> result = new ArrayList<>();
        for(int line=1; line<=rows; line++){
            int k=1; // K is initialized for every row

            List<Integer> temp = new ArrayList<>();
            for(int i=1; i<=line; i++){
                temp.add(k);

                k = k* (line - i)/i;
            }
            result.add(temp);
        }
        return  result;


    }

    public static void main(String[] args) {
        PascalsTriangle testObj = new PascalsTriangle();
        System.out.println(testObj.constructTriangle(5));
        System.out.println(testObj.getRow(5));
    }

        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            long k = 1; // Use long to avoid integer overflow
            for (int i = 0; i <= rowIndex; i++) {
                result.add((int)k);
                k = k * (rowIndex - i) / (i + 1);  // Correct formula to avoid premature division
            }
            return result;
        }




}
