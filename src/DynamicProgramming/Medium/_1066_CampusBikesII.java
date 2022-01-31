package DynamicProgramming.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1066_CampusBikesII {

    //dfs + memo
    //Time = O(M!/(M-N)!)
    //Space = O(N+M), N=recursion stack space, M = bikeUsed
    Map<Integer, Integer> memo = new HashMap<>();
    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length, m = bikes.length;
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dist[i][j] = getDist(workers, i, bikes, j);
            }
        }
        return backtrack(n, 0, new boolean[m], dist);
    }

    private int backtrack(int n, int i, boolean[] bikeUsed, int[][] dist){
        if(i>=n) return 0;
        int key = Arrays.hashCode(bikeUsed);
        if(memo.containsKey(key)) return memo.get(key);
        int min = Integer.MAX_VALUE;
        for(int j=0; j<bikeUsed.length; j++){
            if(bikeUsed[j]) continue;
            bikeUsed[j] = true;
            min = Math.min(min, dist[i][j]+backtrack(n, i+1, bikeUsed, dist));
            bikeUsed[j] = false;
        }
        memo.put(key, min);
        return min;
    }

    private int getDist(int[][] workers, int j, int[][] bikes, int i){
        int[] w = workers[j], b = bikes[i];
        return Math.abs(w[0]-b[0]) + Math.abs(w[1]-b[1]);
    }

    /*
    //backtrack
    //Time = O(M!/(M-N)!)
    //Space = O(N+M), N=recursion stack space, M = bikeUsed
    int minRes = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = bikes.length;
        boolean[] bikeUsed = new boolean[n];
        backtrack(workers, 0, bikes, bikeUsed, 0);
        return minRes;
    }

    private void backtrack(int[][] workers, int start, int[][] bikes, boolean[] used, int sum){
        if(start >= workers.length){
            minRes = Math.min(minRes, sum);
            return;
        }
        if(sum > minRes) return;
        for(int i=0; i<used.length; i++){
            if(!used[i]){
                used[i] = true;
                backtrack(workers, start+1, bikes, used, sum+getDist(workers, start, bikes, i));
                used[i] = false;
            }
        }
    }

    private int getDist(int[][] workers, int j, int[][] bikes, int i){
        int[] w = workers[j], b = bikes[i];
        return Math.abs(w[0]-b[0]) + Math.abs(w[1]-b[1]);
    }

     */
}
