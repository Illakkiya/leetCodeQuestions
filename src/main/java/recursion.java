import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recursion {
    public int factorial(int n){
        if (n<=1){
            return n;
        }
        return n* factorial(n-1);
    }

    public int fibonacci(int n){
        if(n<=1){
            return n;
        }
        return fibonacci(n-1)+ fibonacci(n-2);
    }

    public List<Integer> sortOddEvenList(List<Integer> num){
        Integer[] arr = num.toArray(new Integer[num.size()-1]);
        Arrays.sort(arr, (a,b)->{
            boolean aEven = (a%2==0);
            boolean bEven = (b%2==0);
            if(aEven && !bEven){
                return -1;
            } else if (!aEven && bEven){
                return 1;
            } else{
                return 0;
            }
        });
        return Arrays.stream(arr).toList();
    }

    public static void main(String[] args) {
        recursion testObj = new recursion();
        System.out.println(testObj.factorial(4));
        System.out.println(testObj.fibonacci(5));
        System.out.println(testObj.sortOddEvenList(Arrays.asList(3, 2, 4, 1, 5, 12, 10, 11, 13)));
    }
}
