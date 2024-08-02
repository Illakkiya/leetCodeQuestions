import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

//Given a string, sort it in decreasing order based on the frequency of characters.

public class freqSorterChar {
    public static void main(String[] args) {
        String s = "Hello everyone";
         s= s.toLowerCase();
        HashMap <Character, Integer> counter = new HashMap<>();
        HashMap<Character, Integer> index = new HashMap<>();
        int j=0;
        for(char c: s.toCharArray()){
            counter.put(c, counter.getOrDefault(c,0)+1);
            index.putIfAbsent(c, j);
            j++;
        }
// Convert from char[] to Character[]
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        Arrays.sort(chars, (a,b)->{
          int freqcount = counter.get(b).compareTo(counter.get(a));
          if(freqcount==0){
              return index.get(a).compareTo(index.get(b));
          }
          return freqcount;
        });

        String sort = Arrays.stream(chars).map(String::valueOf).collect(Collectors.joining());
        System.out.println(sort);



    }
}
