package OnlineCodingChallege.Cisco;

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
}
