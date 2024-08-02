import java.util.*;

public class frequencySorter {

        public static void main(String[] args) {
            int[] arr = {0, 0, 5, 5, 5, 5, 5, 8, 8, 1, 2, 2, 2, 6, 6, 6, 9};
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            Map<Integer, Integer> firstIndices = new HashMap<>();
            for(int i=0; i< arr.length; i++) {
                frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
                firstIndices.putIfAbsent(arr[i], i);
            }
            Integer[] Arr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            Arrays.sort(Arr, (a,b)-> {
               int freqCompare =  frequencyMap.get(b).compareTo(frequencyMap.get(a));
               if(freqCompare==0){
                   return firstIndices.get(a).compareTo(firstIndices.get(b));
               }
               return freqCompare;
            });
            int[] answer = Arrays.stream(Arr).mapToInt(Integer::intValue).toArray();
            System.out.println(Arrays.toString(answer));

            frequencySorter testObj = new frequencySorter();
            System.out.println("sorter method");

            testObj.sorter(arr);


        }

        public void sorter(int[] array){
            HashMap<Integer,Integer> frequencyMap = new HashMap<>();
            for(int i=0; i< array.length; i++) {
                frequencyMap.put(array[i], frequencyMap.getOrDefault(array[i], 0) + 1);
            }
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                    (a,b)->frequencyMap.get(b)-frequencyMap.get(a));
            for(int val : frequencyMap.keySet()){
                maxHeap.offer(val);

            }
            while (!maxHeap.isEmpty()) {
                int val = maxHeap.poll();
                int frequency = frequencyMap.get(val);
                for (int i = 0; i < frequency; i++) {
                    System.out.print(val + " ");
                }
            }
            System.out.println();
        }
    }

