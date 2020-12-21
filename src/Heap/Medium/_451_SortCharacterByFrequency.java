package Heap.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _451_SortCharacterByFrequency {

    //Heap + HashMap
    //  Time = O(nlogn) Space: O(n)
    public String frequencySort(String s) {
        if(s==null || s.length()==0) return "";
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((e1, e2)->e2.getValue()-e1.getValue());
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            pq.add(entry);
        }
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> newMap = pq.poll();
            for(int i=0; i<newMap.getValue(); i++){
                sb.append(newMap.getKey());
            }
        }
        return sb.toString();
    }

    //Heap + array
    /*
    public String frequencySort(String s) {
        if(s==null || s.length()==0) return "";
        StringBuilder sb = new StringBuilder();
        int[] bank = new int[256];
        for(char c : s.toCharArray()){
            bank[c]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y)->bank[y]-bank[x]);
        for(int i=0; i<256; i++){
            if(bank[i]!=0){
                pq.add(i);
            }
        }
        while(!pq.isEmpty()){
            int index = pq.poll();
            for(int i=0; i<bank[index]; i++){
                sb.append((char)index);
            }
        }
        return sb.toString();
    }
     */

}
