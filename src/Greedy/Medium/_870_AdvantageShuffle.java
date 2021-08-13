package Greedy.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _870_AdvantageShuffle {

    //Time = O(nlogn) Space = O(n)
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        int[] sortedB = B.clone();
        Arrays.sort(sortedA);
        Arrays.sort(sortedB);
        Map<Integer, Deque<Integer>> assign = new HashMap<>();
        Deque<Integer> remain = new ArrayDeque<>();
        for(int b : sortedB){
            assign.put(b, new ArrayDeque<>());
        }
        int i = 0;
        for(int a : sortedA){
            if(a > sortedB[i]){
                assign.get(sortedB[i]).add(a);
                i++;
            }else{
                remain.add(a);
            }
        }
        int[] results = new int[A.length];
        for(int j=0; j<B.length; j++){
            if(assign.get(B[j]).size() > 0){
                results[j] = assign.get(B[j]).pop();
            }else{
                results[j] = remain.pop();
            }
        }
        return results;
    }
}
