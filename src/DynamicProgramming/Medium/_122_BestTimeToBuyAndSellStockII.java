package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _122_BestTimeToBuyAndSellStockII {
 /*
    dp[i][k][0] = max {dp[i-1][k][0], dp[i-1][k][1] + prices[i] }
    dp[i][k][1] = max {dp[i-1][k][1], dp[i-1][k-1][0] - prices[i] }
    we can have many transactions(k), so k = infinity
    since k is infinity for all terms, dp[i-1][k-1][0] = dp[i-1][k][0] = 0,
    without effecting the result, so we reduce dimention by removing it

    dp[i][0] = max {dp[i-1][0], dp[i-1][1] + prices[i] }
    dp[i][1] = max {dp[i-1][1], 0 - prices[i] }   */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }


   /* public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    } */
}
