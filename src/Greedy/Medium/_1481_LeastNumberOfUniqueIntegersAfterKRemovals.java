package Greedy.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _1481_LeastNumberOfUniqueIntegersAfterKRemovals {
    //Time = O(n*logn), Space = O(n)
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr)  map.put(a, map.getOrDefault(a, 0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->map.get(a)-map.get(b));
        for(int a : map.keySet()){
            pq.add(a);
        }
        while(k > 0 && !pq.isEmpty()){
            if(map.get(pq.peek()) <= k){
                k -= map.get(pq.peek());
                pq.poll();
            }else{
                k = 0;
            }
        }
        if(pq.isEmpty()) return 0;
        return pq.size();
    }
}
