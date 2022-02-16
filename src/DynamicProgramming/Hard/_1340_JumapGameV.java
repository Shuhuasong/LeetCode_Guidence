package DynamicProgramming.Hard;

/**
 * Created by Shuhua Song
 */

public class _1340_JumapGameV {

    /*
   Use dynamic programming:  Time = O(n^2)
   dp[i] = max jumps you can do starting from index i,
   answer is max(dp[i])
   dp[i] = 1 + max(dp[j]) where j is all indices you can reach
           from i. */
    int[] arr;
    int d, n;
    Integer[] memo;
    public int maxJumps(int[] arr, int d) {
        this.n = arr.length;  this.d = d;
        this.arr = arr; this.memo = new Integer[n];
        int res = 1;
        for(int i=0; i<n; i++){
            res = Math.max(res, dfs(i));
        }
        return res;
    }

    private int dfs(int start){
        if(memo[start] != null) return memo[start];
        int steps = 1;
        for(int i=start+1; i<=Math.min(start+d, n-1) && arr[i] < arr[start]; i++){
            steps = Math.max(steps, 1 + dfs(i));
        }
        for(int i=start-1; i>=Math.max(start-d, 0) && arr[i] < arr[start]; i--){
            steps = Math.max(steps, 1 + dfs(i));
        }
        return memo[start] = steps;
    }
}
