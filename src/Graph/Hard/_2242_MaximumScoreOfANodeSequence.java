package Graph.Hard;

import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _2242_MaximumScoreOfANodeSequence {

    //Keep 3 largest scores for each node
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        PriorityQueue<Integer>[] pqs = new PriorityQueue[n];
        for(int i=0; i<n; i++){
            pqs[i] = new PriorityQueue<>((a, b)->scores[a]-scores[b]);
        }
        for(int[] e : edges){
            pqs[e[0]].offer(e[1]);
            pqs[e[1]].offer(e[0]);
            if(pqs[e[0]].size() > 3) pqs[e[0]].poll();
            if(pqs[e[1]].size() > 3) pqs[e[1]].poll();
        }
        int res = -1;
        for(int[] e : edges){
            for(int i : pqs[e[0]]){
                for(int j : pqs[e[1]]){
                    if(i!=j && i!=e[1] && j!=e[0]){
                        res = Math.max(res, scores[i]+scores[j]+scores[e[0]]+scores[e[1]]);
                    }
                }
            }
        }
        return res;
    }
}
