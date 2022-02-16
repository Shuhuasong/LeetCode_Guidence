package DFS_and_BFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _1306_JumpGame_III {
    //BFS. Time = O(n), Space = O(n)
    public boolean canReach(int[] arr, int start) {
        if(start<0 || start >= arr.length || arr[start] < 0) return false;
        if(arr[start]==0) return true;
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int node = q.poll();
            if(arr[node]==0) return true;
            if(arr[node] < 0) continue;
            if(node+arr[node] < n) q.offer(node+arr[node]);
            if(node-arr[node] >= 0) q.offer(node-arr[node]);
            arr[node] = -arr[node];
        }
        return false;
    }
}
