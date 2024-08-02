//import org.apache.commons.math3.util.Pair;
//
//import java.util.*;
//
//public class duplicateCardFinder {
//    public void findDuplicateCard(List<String> type, List<Integer> number){
//        // Check if the input lists are not null and of the same size
//        if (type == null || number == null || type.size() != number.size()) {
//            throw new IllegalArgumentException("Lists must not be null and must be of the same size.");
//        }
//        HashMap<Pair<String,Integer>,Integer> cardCounter = new HashMap<>();
//        for(int i = 0;i < type.size(); i++){
//            Pair<String,Integer> card = new Pair<>(type.get(i),number.get(i));
//            cardCounter.put(card,
//                    cardCounter.getOrDefault(card,0)+1);
//        }
//        for(Map.Entry<Pair<String,Integer>,Integer> entry: cardCounter.entrySet()){
//            if(entry.getValue()>1){
//                System.out.println("Duplicate"+ entry.getKey());
//                break;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        duplicateCardFinder testObj = new duplicateCardFinder();
//        List<String> type = new ArrayList<>(Arrays.asList("Heart","Clover","Diamond","Heart","Spade"));
//        List<Integer> number = new ArrayList<>(Arrays.asList(3,5,2,3,8));
//
//        testObj.findDuplicateCard(type,number);
//    }
//}

import org.apache.commons.math3.util.Pair;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class duplicateCardFinder {
    public void findDuplicateCard(List<String> type, List<Integer> number) {
        if (type == null || number == null || type.size() != number.size()) {
            throw new IllegalArgumentException("Lists must not be null and must be of the same size.");
        }

        Set<Pair<String, Integer>> cardSet = new HashSet<>();

        for (int i = 0; i < type.size(); i++) {
            Pair<String, Integer> card = new Pair<>(type.get(i), number.get(i));
            if (!cardSet.add(card)) {  // If add returns false, the card is a duplicate
                System.out.println("Duplicate found: " + card);
                return;  // Exit if a duplicate is found (remove this if you want to find all duplicates)
            }
        }
        System.out.println("No duplicates found.");
    }

    public static void main(String[] args) {
        duplicateCardFinder finder = new duplicateCardFinder();
        List<String> types = List.of("Spade", "Heart", "Spade", "Club");
        List<Integer> numbers = List.of(10, 2, 10, 3);
        finder.findDuplicateCard(types, numbers);
    }
}

