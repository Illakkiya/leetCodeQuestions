import java.util.*;

public class Compartor {
    public static void main(String[] args) {
        List<String> test = Arrays.asList("ello", "hi", "you");
        List<Integer> numList = new ArrayList<>(Arrays.asList(5, 9, 2, 8, 0));
        Collections.sort(test, (s1, s2) -> s1.compareTo(s2));
        Collections.sort(numList, Comparator.reverseOrder());
        //numList.sort(Comparator.naturalOrder());
        Collections.sort(numList, Comparator.comparingInt(i-> i));
        System.out.println(test);

        System.out.println(numList);
        numList.add(10);
        numList.add(0,1);
        System.out.println(numList);

    }
}
