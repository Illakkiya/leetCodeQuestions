import java.util.Arrays;

public class EvenOddSorter {
    public int[] sorter(int[] arr){
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedArr, (a,b)->{
            boolean isAeven = a%2==0;
            boolean isBEven = b%2==0;
            if(isAeven && !isBEven){
                return -1; // a comes before b
            } else if (isBEven && !isAeven){
                return 1; // b comes after a
            } else{
                return a - b; // if both even/odd sort in natural order
            }

        });
        int[] result = Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        EvenOddSorter testObj = new EvenOddSorter();
        testObj.sorter(new int[]{4,7,8,3,9,1,0});
    }
}
