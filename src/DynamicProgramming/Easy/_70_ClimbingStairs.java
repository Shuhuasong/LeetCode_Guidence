package DynamicProgramming.Easy;

/**
 * Created by Shuhua Song
 */
public class _70_ClimbingStairs {

    //DP: Time = O(n), Space = O(n)
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /*
      //Recursive+memoization: Time = O(n), Space = O(n)
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return dfs(n, memo);
    }

    private int dfs(int idx, int[] memo){
        if(idx==0) return 1;
        if(idx==1) return 1;
        if(memo[idx] > 0) return memo[idx];
        memo[idx] = dfs(idx-1, memo) + dfs(idx-2, memo);
        return memo[idx];
    }
     */
}
