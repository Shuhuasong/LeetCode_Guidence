package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _188_BestTimeToBuyAndSellStockIV {
     /*
    K is a variable now
    dp[i][k][0] = max {dp[i-1][k][0], dp[i-1][k][1] + prices[i] }
    dp[i][k][1] = max {dp[i-1][k][1], dp[i-1][k-1][0] - prices[i] }
    为什么 k 要从大到小呢 ？
    因为随着交易次数， 交易次数上限 k 是不断减少

    Note: the corner case ==> when K is greater than n/2, it because
    best Time To Buy and Sell Stock II, which can help us to save memory
     */

    public int maxProfit(int K, int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int n = prices.length;
        if(K > n/2){
            int res = 0;
            for(int i=1; i<n; i++){
                if(prices[i] > prices[i-1]){
                    res += prices[i]-prices[i-1];
                }
            }
            return res;
        }

        int[][][] dp = new int[n][K+1][2];
        for(int i=0; i<n; i++){
            for(int k=K; k>=1; k--){
                if(i==0){
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n-1][K][0];
    }
}
