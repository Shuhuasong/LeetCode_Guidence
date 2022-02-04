package Heap.Easy;

import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        for(int stone : stones){
            pq.add(stone);
        }
        while(pq.size() >= 2){
            int v1 = pq.poll();
            int v2 = pq.poll();
            //System.out.println(v1 + "==" + v2);
            if(v1==v2) continue;
            pq.add(v1-v2);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
