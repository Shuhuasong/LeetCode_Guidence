package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _714_BestTimeToBuySellStockWithFee {

     /*
    dp[i][k][0] = max {dp[i-1][k][0], dp[i-1][k][1] + prices[i]-fee }
    dp[i][k][1] = max {dp[i-1][k][1], dp[i-1][k-1][0] - prices[i] }
    we can have many transactions(k), so k = infinity
    since k is infinity for all terms, dp[i-1][k-1][0] = dp[i-1][k][0] = 0,
    without effecting the result, so we reduce dimention by removing it

    dp[i][0] = max {dp[i-1][0], dp[i-1][1] + prices[i]-fee } //make less profit when sell a stock since there is fee exist
    dp[i][1] = max {dp[i-1][1], 0 - prices[i] }   */

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

  /*  public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0]-fee; //buy stack and pay the fee. the price of stock increase when there is fee
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]-fee);
        }
        return dp[n-1][0];
    } */

    /*
      //Space = O(1)
     public int maxProfit(int[] prices, int fee){
          int cash = 0, hold = -prices[0];
          for(int i=1; i<prices.length; i++){
              //ith day I don't own a share today (either did not have or sold today)
              cash = Math.max(cash, hold+prices[i]-fee);
              //ith day I own a share today (either already had or buy today)
              hold = Math.max(hold, cash-prices[i]);
          }
         return cash;
     }
     */
}
