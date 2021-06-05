package BINARYSEARCH_Web.Greedy;


/*
idea:
-- On any given day, we have two choice, either buy some stock to sell later, or sell the stock we have now
-- We can use two variable to track the value for each
-- Each day, we compare and tradeoff between the cashing in a stock we have already bought VS investing in a new stock
   assuming we don't hold any previous stock
-- At the end of all days, return the cash in hand

Time = O(n) Space = o(1)
two states :
  Buy ==> invest
  Don't Buy(Sell) == > cash_own
 */
public class _BrokerOfWallStreet {
    public int maxProfit(int[] stock, int fee){
        if(stock.length < 2) return 0;
        int n = stock.length;
        int cash_own = 0;
        int invest = -stock[0];
        for(int day=1; day<n; day++){
            //get cash when sell the stock
            cash_own = Math.max(cash_own, invest+stock[day]-fee);
            //spend cash when buy a stock
            invest = Math.max(invest, cash_own - stock[day]);
        }
        return cash_own;
    }
}
