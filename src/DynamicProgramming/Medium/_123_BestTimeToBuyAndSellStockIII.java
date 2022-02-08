package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _123_BestTimeToBuyAndSellStockIII {

     /*
    maximum for k = 2
    dp[i][k][0] = max {dp[i-1][k][0], dp[i-1][k][1] + prices[i] }
    dp[i][k][1] = max {dp[i-1][k][1], dp[i-1][k-1][0] - prices[i] }
    为什么 k 要从大到小呢 ？
    因为随着交易次数， 交易次数上限 k 是不断减少
     */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0]; //允许你买多少次，不影响你只能负债一次

        for(int i=1; i<n; i++){
            for(int k=2; k>=1; k--){
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        //k 指代的是累计到现在的交易次数
        return dp[n-1][2][0];
    }
}
