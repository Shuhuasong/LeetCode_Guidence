package Heap.Hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _1383_MamimumPerformanceOfATeam {
/*
idea:
 performance = sum( at most k speed) * min(k efficiency)
 -- we need to sort the candidate in decending order of efficiency, and then iterate each candidate one by one, to make sure
    each time's current efficiency is the minimum
 -- use a priority queue to maintain a number k of speed
*/
//Time = O(nlogn)--sorting, O(nlogk)--priority queue, Space = O(n)
public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    int[][]  engineers = new int[n][2];
    int MOD = (int)1e9+7;
    for(int i=0; i<n; i++){
        engineers[i] = new int[]{efficiency[i], speed[i]};
    }
    Arrays.sort(engineers, (a, b)->b[0]-a[0]);
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->a-b);
    long maxPerf = 0, sumSpeed = 0;
    for(int[] e : engineers){
        int curEff = e[0];
        int curSpeed = e[1];
        while(pq.size() > k-1){
            sumSpeed -= pq.remove();
        }
        pq.add(curSpeed);
        sumSpeed += curSpeed;
        maxPerf = Math.max(maxPerf, (sumSpeed * curEff));
    }
    return (int)(maxPerf%(long)(1e9+7));
}
}
