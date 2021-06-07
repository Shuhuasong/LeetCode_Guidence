package Heap.Medium;

import java.util.*;

public class _692_TopKFrequentWords {
    /*
if s1 > s2, it returns positive number
if s1 < s2, it returns negative number
if s1 == s2, it returns 0
*/


    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String w : words){
            freq.put(w, freq.getOrDefault(w, 0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2)->{
            if(freq.get(w1)!=freq.get(w2)){
                return freq.get(w1)-freq.get(w2);
            }else{
                return w2.compareTo(w1);
            }
        });
        for(String st : freq.keySet()){
            pq.add(st);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<String> results = new ArrayList<>();
        while(!pq.isEmpty()){
            results.add(pq.poll());
        }
        Collections.reverse(results);
        return results;
    }
}
