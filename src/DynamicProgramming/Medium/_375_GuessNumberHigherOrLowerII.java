package DynamicProgramming.Medium;

public class _375_GuessNumberHigherOrLowerII {

    public int getMoneyAmount(int n) {
        //dp ; refers to the minimum cost of finding the worst number given only the number in the range(i, j)
        int[][] dp = new int[n+1][n+1];
        return dfs(dp, 1, n);
    }

    public int dfs(int[][] dp, int low, int high){
        if(low >= high){
            return 0;
        }
        if(dp[low][high] != 0){
            return dp[low][high];
        }
        int res = Integer.MAX_VALUE;
        for(int i=low; i<=high; i++){
            int cost = i + Math.max(dfs(dp, low, i-1), dfs(dp, i+1, high));
            res = Math.min(res, cost);
        }
        dp[low][high] = res;
        return res;
    }
}
