package OnlineCodingChallege.Amazon;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _973_KclosestPointsToOrigin_ {

    private static int[][] kClosest(int[][] points, int k){
        Queue<int[]>  pq = new PriorityQueue<>((a, b)->
             b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1]
        );
        for(int[] p : points){
            pq.add(p);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.toArray(new int[pq.size()][2]);
    }
}
