package Heap.Hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _1235_MaximumProfitInJobScheduling {
    //Sort + Heap
    //Time = O(NlogN)
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] timeProfit = new int[n][3];
        for(int i=0; i<startTime.length; i++){
            timeProfit[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(timeProfit, (a, b)->a[0]-b[0]);
        return getMaxProfit(timeProfit);
    }
    private int getMaxProfit(int[][] jobs){
        int n = jobs.length, prevMaxProfit = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        for(int i=0; i<n; i++){
            int start = jobs[i][0], end = jobs[i][1], profit = jobs[i][2];
            while(!pq.isEmpty() && start >= pq.peek()[0]){
                prevMaxProfit = Math.max(prevMaxProfit, pq.peek()[1]);
                pq.remove();
            }
            int[] cell = new int[]{end, profit + prevMaxProfit};
            pq.add(cell);
        }
        while(!pq.isEmpty()){
            prevMaxProfit  = Math.max(prevMaxProfit, pq.poll()[1]);
        }
        return prevMaxProfit;
    }
}
