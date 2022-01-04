package DynamicProgramming.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _983_MinimumCostForTickets {

    //Bottom-up : DP
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        Set<Integer> daySet = new HashSet<>();
        for(int d : days) daySet.add(d);
        int n = days.length;
        dp[0] = 0;
        for(int i=1; i<=days[n-1]; i++){
            if(!daySet.contains(i)){
                dp[i] = dp[i-1];
                continue;
            }else{
                int v1 = dp[Math.max(0, i-1)] + costs[0];
                int v2 = dp[Math.max(0, i-7)] + costs[1];
                int v3 = dp[Math.max(0, i-30)] + costs[2];
                dp[i] = Math.min(v1, Math.min(v2, v3));
            }
        }
        return dp[days[n-1]];
    }


/*
dp[i] : the cost for the first i days we can travel
if(i not in days) dp[i] = dp[i-1]
dp[i] = min(dp[i-1]+cost[0], dp[i-7]+costs[1], dp[i-30]+costs2)

*/


    //Top Down : recursion + memoization
/*
     int[] memo;
    Set<Integer> daySet;
    public int mincostTickets(int[] days, int[] costs) {
        memo = new int[366];
        daySet = new HashSet<>();
        Arrays.fill(memo, -1);
        for(int d : days) daySet.add(d);
        return minCost(days, 0, costs);
    }

    private int minCost(int[] days, int idx, int[] costs){
        if(idx > 365) return 0;
        if(memo[idx] != -1) return memo[idx];
        int minRes = Integer.MAX_VALUE;
        if(daySet.contains(idx)){
            minRes = Math.min(minRes, costs[0]+minCost(days, idx+1, costs));
            minRes = Math.min(minRes, costs[1]+minCost(days, idx+7, costs));
            minRes = Math.min(minRes, costs[2]+minCost(days, idx+30, costs));
        }else{
            minRes = minCost(days, idx+1, costs);
        }
        memo[idx] = minRes;
        return  minRes;
    }  */
}


