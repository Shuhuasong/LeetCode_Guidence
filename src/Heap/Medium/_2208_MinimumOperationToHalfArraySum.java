package Heap.Medium;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _2208_MinimumOperationToHalfArraySum {
    //Note: Variable Type
    //It is always optimal to halve the largest element.
    //Use a heap or priority queue to maintain the current elements.
    public int halveArray(int[] nums) {
        long total = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            total += num;
            pq.offer((double)num);
        }
        double halfSum = total/2.0;
        int count = 0;
        while(!pq.isEmpty()){
            double val = pq.poll();
            double newVal = val/2;
            halfSum -= newVal;
            count++;
            if(halfSum <= 0) return count;
            pq.offer(newVal);
        }
        return count;
    }

}
