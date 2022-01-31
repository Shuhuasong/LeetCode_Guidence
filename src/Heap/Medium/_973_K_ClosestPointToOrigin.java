package Heap.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _973_K_ClosestPointToOrigin {
    //Time = o(n*logk), Space = O(k)
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> list = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        for(int[] p : points){
            pq.add(p);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] results = new int[pq.size()][2];
        int i = 0;
        while(!pq.isEmpty()){
            results[i++] = pq.poll();
        }
        return results;
    }
}
