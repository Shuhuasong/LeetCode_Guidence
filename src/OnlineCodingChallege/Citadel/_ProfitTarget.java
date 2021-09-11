package OnlineCodingChallege.Citadel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _ProfitTarget {

    //nums = stocksProfit
    public static int stockPairs(int[] nums, int target){
        int res = 0;
        HashSet<Integer> stock = new HashSet<>();
        HashSet<Integer> used = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (stock.contains(target - nums[i]) && !used.contains(nums[i])){
                res++;
                used.add(nums[i]);
                used.add(target - nums[i]);
            }
            stock.add(nums[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] stocksProfit = {5, 7, 7, 7, 5, 9, 13, 11, 6, 6, 3, 3};
        int target = 12;
        System.out.println(stockPairs(stocksProfit, target));
    }
}
