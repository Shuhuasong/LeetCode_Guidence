package Sorting.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
//
public class _451_SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b)->map.get(b)-map.get(a));
        for(char k : map.keySet()) pq.offer(k);
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char c = pq.poll();
            int times = map.get(c);
            for(int i=0; i<times; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /*
    //Bucket Sort
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        List<Character>[] bucket = new List[s.length()+1];
        for(char key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for(int pos=bucket.length-1; pos>=0; pos--){
            if(bucket[pos]==null) continue;
            for(char c : bucket[pos]){
                for(int i=0; i<pos; i++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
     */
}
