package HashTable.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _692_TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w, map.getOrDefault(w, 0)+1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2)->{
            if(map.get(s1).equals(map.get(s2))){
                return s2.compareTo(s1);
            }else{
                return map.get(s1)-map.get(s2);
            }
        });
        for(String w : map.keySet()){
            minHeap.offer(w);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        LinkedList<String> list = new LinkedList<>();
        while(!minHeap.isEmpty()){
            list.addFirst(minHeap.poll());
        }
        return list;
    }
}
