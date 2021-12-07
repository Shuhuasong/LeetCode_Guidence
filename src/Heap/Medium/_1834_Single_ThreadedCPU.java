package Heap.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _1834_Single_ThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] comTask = new int[n][3];
        for(int i=0; i<n; i++){
            comTask[i][0] = i;
            comTask[i][1] = tasks[i][0];
            comTask[i][2] = tasks[i][1];
        }
        Arrays.sort(comTask, (a, b)->a[1]-b[1]);
        Queue<int[]> pq= new PriorityQueue<>((a, b)->{
            if(a[2]==b[2]) return a[0]-b[0];
            else
                return a[2]-b[2];
        });
        int time = 0, idx = 0, k = 0;
        int[] res = new int[n];
        while(k < n){
            while(idx < n && comTask[idx][1] <= time){
                pq.add(comTask[idx]);
                idx++;
            }
            if(pq.isEmpty()){
                time = comTask[idx][1];
                continue;
            }
            int[] cell = pq.poll();
            time += cell[2];
            res[k++] = cell[0];
        }
        return res;
    }
}
