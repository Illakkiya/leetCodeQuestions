import java.util.*;

public class Test {

    public static void main(String[] args) {
        String s = "Illakkiya Ravichandran Automation Engineer";
        HashMap<Character, Integer> counter = new HashMap<>();
        int maxCount = 0;
        for (char c : s.toCharArray()) {
            counter.put(c, (counter.getOrDefault(c, 0) + 1));
            maxCount = Math.max(counter.get(c), maxCount);

        }
        List<Map.Entry<Character, Integer>> temp = new ArrayList<>(counter.entrySet());
        temp.sort(Comparator.comparingInt(Map.Entry::getValue));
        System.out.println(temp.get(temp.size()-1));
        for(Map.Entry<Character, Integer> entry: counter.entrySet()){
            if(entry.getValue()==maxCount){
                System.out.println("Max Char:"+entry.getKey()+"  count : " + maxCount);
                break;
            }
        }

    }
}
