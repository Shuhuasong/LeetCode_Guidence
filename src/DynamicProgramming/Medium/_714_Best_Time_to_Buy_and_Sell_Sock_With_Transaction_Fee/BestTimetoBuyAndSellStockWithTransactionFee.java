package DynamicProgramming.Medium._714_Best_Time_to_Buy_and_Sell_Sock_With_Transaction_Fee;

public class BestTimetoBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int hold = Integer.MIN_VALUE, sold = 0;
        for(int p : prices){
            hold = Math.max(hold, sold-p);
            sold = Math.max(sold, hold+p-fee);
        }
        return sold;
    }
}
