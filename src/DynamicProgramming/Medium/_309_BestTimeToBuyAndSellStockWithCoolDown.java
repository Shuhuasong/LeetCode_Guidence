package DynamicProgramming.Medium;

public class _309_BestTimeToBuyAndSellStockWithCoolDown {

    public int maxProfit(int[] prices) {
        //if(prices==null || prices.length==0) return 0;
        //int maxProfit = 0,
        int n = prices.length;
        int[] MP = new int[n+2];
        for(int i=n-1; i>=0; i--){
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
    }
}
/*
Algorithm

With the final formula we derived for our target function \text{MP}(i)MP(i), we can now go ahead and translate it into any programming language.

Since the formula deals with subsequences of price that start from the last price point, we then could do an iteration over the price list in the reversed order.

We define an array MP[i] to hold the values for our target function \text{MP}(i)MP(i). We initialize the array with zeros, which correspond to the base case where the minimal profits that we can gain is zero. Note that, here we did a trick to pad the array with two additional elements, which is intended to simplify the branching conditions, as one will see later.

To calculate the value for each element MP[i], we need to look into two cases as we discussed in the previous section, namely:

Case 1). we buy the stock at the price point price[i], then we sell it at a later point. As one might notice, the initial padding on the MP[i] array saves us from getting out of boundary in the array.

Case 2). we do no transaction with the stock at the price point price[i].

At the end of each iteration, we then pick the largest value from the above two cases as the final value for MP[i].

At the end of the loop, the MP[i] array will be populated. We then return the value of MP[0], which is the desired solution for the problem.
 */
