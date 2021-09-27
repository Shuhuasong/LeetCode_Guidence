package Heap.Medium;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _1167_MinimumCostToConnectSticks {

    public int connectSticks(int[] sticks) {
        if(sticks.length<=1) return 0;
        // if(sticks.length==1) return sticks[0];
        Queue<Integer> q = new PriorityQueue<>();
        for(int stick : sticks) q.add(stick);
        int res = 0, sum = 0;
        while(q.size()>=2){
            int val1 = q.poll();
            int val2 = q.poll();
            sum = val1 + val2;
            res += sum;
            q.add(sum);
            // System.out.println(sum);
        }
        //res += q.peek();
        return res;
    }
}
