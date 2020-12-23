package Array.Medium;

import java.util.*;

public class _692_TopKFrequentWords {

    //Sort
    //Time = O(nlogn)  Space: O(n)
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> count = new HashMap<>();
        for(String s : words){
            count.put(s, count.getOrDefault(s, 0)+1);
        }
        List<String> results = new ArrayList<>(count.keySet());
        Collections.sort(results, (s1, s2)->{
                    if(count.get(s1)==count.get(s2)){
                        return s1.compareTo(s2);
                    }else{
                        return count.get(s2) - count.get(s1);
                    }
                }
        );
        return results.subList(0, k);
    }

    //Heap  Time = O(nlogk)

 /*   public List<String> topKFrequent(String[] words, int k) {
        List<String> results = new ArrayList<>();
        if(words.length==0 || k==0) return results;
        Map<String, Integer> map = new HashMap<>();
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2)->{
                if(map.get(s1)==map.get(s2)){
                return s2.compareTo(s1);
            }else{
                return map.get(s1)-map.get(s2);
            }
        });

        for(String str : map.keySet()){
            pq.add(str);
            if(pq.size() > k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            results.add(pq.poll());
        }
        Collections.reverse(results);
        return results;
    }


  */

}
