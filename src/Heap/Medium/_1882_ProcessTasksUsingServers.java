package Heap.Medium;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _1882_ProcessTasksUsingServers {
    //Time = O((m+n)*logn)
    //Space = O(n)
    public int[] assignTasks(int[] servers, int[] tasks) {
        Queue<int[]> freeHeap = new PriorityQueue<>((a, b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else
                return a[1]-b[1];
        });
        Queue<int[]> usedHeap = new PriorityQueue<>((a, b)->{
            if(a[2]!=b[2]) return a[2]-b[2];
            else if(a[0]!=b[0]) return a[0]-b[0];
            else
                return a[1]-b[1];
        });
        int m = servers.length, n = tasks.length;
        for(int i=0; i<m; i++){
            freeHeap.add(new int[]{servers[i], i, 0});
        }
        int[] res = new int[n];
        for(int time=0; time<n; time++){
            while(!usedHeap.isEmpty() && usedHeap.peek()[2] <= time){
                freeHeap.add(usedHeap.poll());
            }
            if(!freeHeap.isEmpty()){
                int[] curr = freeHeap.poll();
                curr[2] = time + tasks[time];
                res[time] = curr[1];
                usedHeap.add(curr);
            }else{
                //if there is no free servers, we can find server with smallest available time
                int[] curr = usedHeap.poll();
                curr[2] += tasks[time];
                res[time] = curr[1];
                usedHeap.add(curr);
            }
        }
        return res;
    }
}

/*
idea:
For each task, we need to find which server should be assigned.
We will have two heap,
freeHeap is for sort the servers according to
the weight and index;
usedHeap if for soting the useed servers by
available time
Every time, we first pop from used heap and add them to free server heap if the
availble time is smaller or equal to current task time. If the free server is empty, then we
use the used server with smallest available time
*/


