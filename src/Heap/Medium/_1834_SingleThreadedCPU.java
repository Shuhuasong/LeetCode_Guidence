package Heap.Medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1834_SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        if(tasks.length==0) return new int[]{0};
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                new Comparator<int[]>(){
                    public int compare(int[] a, int[] b){
                        if(a[2] != b[2]){
                            return a[2]-b[2];
                        }else{
                            return a[0]-b[0];
                        }
                    }
                }
        );
        int n = tasks.length;
        int[] results = new int[n];
        PriorityQueue<int[]> enqueue = new PriorityQueue<int[]>((a, b)->a[1]-b[1]);
        for(int i=0; i<n; i++){
            enqueue.add(new int[]{i, tasks[i][0], tasks[i][1]});
        }
        int idx = 0;
        int enqueTime = enqueue.peek()[1];
        while(!pq.isEmpty() || !enqueue.isEmpty()){
            while(!enqueue.isEmpty() && enqueue.peek()[1] <= enqueTime){
                pq.offer(enqueue.poll());
            }
            if(pq.isEmpty()){
                enqueTime = enqueue.peek()[1];
                while(!enqueue.isEmpty() && enqueue.peek()[1] <= enqueTime){
                    pq.offer(enqueue.poll());
                }
            }
            int[] curr = pq.poll();
            if(curr != null){
                if(!enqueue.isEmpty()){
                    enqueTime += curr[2];
                }
                results[idx++] = curr[0];
            }
        }
        return results;
    }
}
