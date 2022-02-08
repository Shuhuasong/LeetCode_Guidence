package DynamicProgramming.Medium;

public class _309_BestTimeToBuyAndSellStockWithCoolDown {

     /*
    dp[i][k][0] = max {dp[i-1][k][0], dp[i-1][k][1] + prices[i] }
    dp[i][k][1] = max {dp[i-1][k][1], dp[i-2][k-1][0] - prices[i] }
    since we need to cool one day, so before we buy a stock, we need to have one more day(rest)
    after previous sell day, so when buy it, it need transfer from i-2, which is dp[i-2][k-1][0] instead of dp[i-1][k-1][0]

    we can have many transactions(k), so k = infinity
    since k is infinity for all terms, dp[i-1][k-1][0] = dp[i-1][k][0] = 0,
    without effecting the result, so we reduce dimention by removing it

    dp[i][0] = max {dp[i-1][0], dp[i-1][1] + prices[i] }
    dp[i][1] = max {dp[i-1][1], dp[i-2][0] - prices[i] }   */


    public int maxProfit(int[] prices) {
        if(prices==null || prices.length <= 1) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        //股市刚开场， 手里0为空钱0
        dp[0][0] = 0;
        //股市刚开场，自己买入被套牢， 钱在股市不在你的手上
        dp[0][1] = -prices[0];
        //手里无股票 = max ( 昨天没有，今天没买； 或者把昨天买的卖掉 )
        dp[1][0] = Math.max(dp[0][0], dp[0][1]+prices[1]);
        //手里有股票 = max ( 昨天也有股票在手， 或者第二天买)  钱在股市不在你的手上
        dp[1][1] = Math.max(dp[0][1], dp[0][0]-prices[1]);
        for(int i=2; i<n; i++){
            //今天手里无股票 = max ( 昨天也没有，今天没买； 或者把昨天买的卖掉+票价 )
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            //今天手里有股票 = max ( 昨天也有股票在手； 前天没股票+cooldown之后今天交钱买了)  钱在股市不在你的手上
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
            //cool down = 1 天， 所以我们用的是前天没有股票的状态
        }
        return dp[n-1][0];
    }


 /*   public int maxProfit(int[] prices) {
        //if(prices==null || prices.length==0) return 0;
        //int maxProfit = 0,
        int n = prices.length;
        int[] MP = new int[n+2];
        for(int i=n-1; i>=0; i--){ //i == buy
            int c1 = 0;
            //case 1: buy and sell the stock
            for(int sell=i+1; sell<n; sell++){
                int profit = (prices[sell] - prices[i]) + MP[sell+2];
                c1 = Math.max(profit, c1);
            }
            //case 2: do no transaction with stock
            int c2 = MP[i+1];
            //wrap up the two cases
            MP[i] = Math.max(c1, c2);
        }
        return MP[0];
    } */
}
/*
Algorithm

With the final formula we derived for our target function \text{MP}(i)MP(i), we can now go ahead and translate it into any programming language.

Since the formula deals with subsequences of price that start from the last price point, we then could do an iteration over the price list in the
reversed order.

We define an array MP[i] to hold the values for our target function \text{MP}(i)MP(i). We initialize the array with zeros, which correspond to the
base case where the minimal profits that we can gain is zero. Note that, here we did a trick to pad the array with two additional elements, which
is intended to simplify the branching conditions, as one will see later.

To calculate the value for each element MP[i], we need to look into two cases as we discussed in the previous section, namely:

Case 1). we buy the stock at the price point price[i], then we sell it at a later point. As one might notice, the initial padding
 on the MP[i] array saves us from getting out of boundary in the array.

Case 2). we do no transaction with the stock at the price point price[i].

At the end of each iteration, we then pick the largest value from the above two cases as the final value for MP[i].

At the end of the loop, the MP[i] array will be populated. We then return the value of MP[0], which is the desired solution for the problem.
 */
