package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _121_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] > minPrice){
                res = Math.max(res, prices[i]-minPrice);
            }else{
                minPrice = prices[i];
            }
        }
        return res;
    }


    /*

    dp[i][k][0] = max {dp[i-1][k][0], dp[i-1][k][1] + prices[i] }
    dp[i][k][1] = max {dp[i-1][k][1], dp[i-1][k-1][0] - prices[i] }

    since k = 1 for all terms, without effecting the result, so we reduce dimention by removing it

    dp[i][0] = max {dp[i-1][0], dp[i-1][1] + prices[i] }
    dp[i][1] = max {dp[i-1][1], 0 - prices[i] }  

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; //first day of stock, without stock, no any profit
        dp[0][1] = -prices[0]; //first day of stock, buy a stock (you pay off the money )
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] );
            dp[i][1] = Math.max(dp[i-1][1], 0 - prices[i]);
        }
        return dp[n-1][0];
    }

     */
}
