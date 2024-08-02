import org.apache.commons.math3.util.Pair;

import java.util.*;

class sortedSquares {
    public int[] squares(int[] nums) {
        int[] result = new int[nums.length -1];
        result = Arrays.stream(nums).map(i->i*i).sorted().
                toArray();
        Arrays.stream(result).forEach(System.out::print);
        return result;
    }

    public static void main(String[] args) {
        sortedSquares testObj = new sortedSquares();
        testObj.squares(new int[]{4,-1,6,-2});
    }
            public int maximumUnits(int[][] boxTypes, int truckSize) {
                Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
                int unitCount = 0;
                for (int[] boxType : boxTypes) {
                    int boxCount = Math.min(truckSize, boxType[0]);
                    unitCount += boxCount * boxType[1];
                    truckSize -= boxCount;
                    if (truckSize == 0)
                        break;
                }
                return unitCount;
            }


}