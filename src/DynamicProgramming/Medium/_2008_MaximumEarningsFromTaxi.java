package DynamicProgramming.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
//Similar Question: LC-1235, LC-1751

//Time = O(n), Space = O(m)
public class _2008_MaximumEarningsFromTaxi {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] ride : rides){
            int start = ride[0], end = ride[1], gain = ride[1]-ride[0] + ride[2];
            map.putIfAbsent(end, new ArrayList<int[]>());
            List<int[]> list = map.get(end);
            list.add(new int[]{start, gain});
        }
        //dp[i] : means the maximum earning at ith point
        long[] dp = new long[n+1];
        //i = end
        for(int i=1; i<=n; i++){
            dp[i] = dp[i-1];
            if(map.containsKey(i)){
                for(int[] ride : map.get(i)){
                    int begin = ride[0], gain = ride[1];
                    //max(not take current rides, take the current rides)
                    dp[i] = Math.max(dp[i], dp[begin]+gain);
                }
            }
        }
        return dp[n];
    }


    /*
     //Time = O(m+n), m = rides.lenght
    public long maxTaxiEarnings(int n, int[][] rides) {
        //sort the rides by start point
        Arrays.sort(rides, (a, b)->a[0]-b[0]);
        long[] dp = new long[n+1];
        int end = 0;
        for(int s=1; s<=n; s++){
            dp[s] = Math.max(dp[s], dp[s-1]);
            // consider all rides starting at i i.e. rides[j][0]==s
            // and update the earning at ending point
            while(end<rides.length && rides[end][0]==s){
                int gain = rides[end][1]-rides[end][0] + rides[end][2];
                dp[rides[end][1]] = Math.max(dp[rides[end][1]], dp[s] + gain);
                end++;
            }
        }
        for(long d : dp){
            System.out.print(d + " ");
        }
        return dp[n];
    }
     */


    /* //Time  = O(n + mlogm)
     long[] memo;
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b)->a[0]-b[0]);
        int m = rides.length;
        memo = new long[m];
        Arrays.fill(memo, -1);
        return dfs(rides, 0);
    }

    private long dfs(int[][] rides, int i){
        if(i >= rides.length) return 0;
        if(memo[i] != -1) return memo[i];
        long take = rides[i][1]-rides[i][0]+rides[i][2] + dfs(rides, findNextIdx(rides, i));
        long notTake = dfs(rides, i+1);
        memo[i] = (long)Math.max(take, notTake);
        return memo[i];
    }

    private int findNextIdx(int[][] rides, int i){
        int start = i+1, end = rides.length-1;
        int res = rides.length;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(rides[mid][0] >= rides[i][1]){
                end = mid - 1;
                res = mid;
            }else{
                start = mid + 1;
            }
        }
        return res;
    }
     */
}

/*
Note: we can't use Greedy for this question
Greedy usually use the question:
 1) The maximum non-overlapping intervals
 2) The minimum intervals that cover the whole range
Therefore, the question need to use Dynamic Programming.

<1>  Map + DP
   1. Use Map store all the rides with the same end point together
   2. Iterate each ith point from 1 to n as end point, and pick the maximum gain from all rides end at ith point
   3. Compare the value (take the current ride, not take the current ride)

[[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]
    7        9        5         3         5          6
    7        9        14       14         19
                                 9                    6

<2> DP-Solution:
   what make the earning different is at end point for each rides,
   so we only need to focus on updating the earning at end point
   the range from [start, end) doesn't make any impact for earning

   -- the max of dp[i] will switch to new point
   -- for every next switch check

   n = 5, rides = [[2,5,4],[1,5,1]]
   rides = {[1,5,1],[2,5,4]}
   dp[0] = 0
   dp[5] = 5
   dp[5] = max(5, 7)
*/









