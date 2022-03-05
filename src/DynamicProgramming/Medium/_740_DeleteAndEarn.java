package DynamicProgramming.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _740_DeleteAndEarn {

    //DFS + Memoization :
    //Time : O(N+k), K = max number
    //Space : O(N+k)
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> points = new HashMap<>();
        int maxNum = Integer.MIN_VALUE;
        for(int num : nums){
            points.put(num, points.getOrDefault(num, 0)+num);
            maxNum = Math.max(maxNum, num);
        }
        int[] maxPoints = new int[maxNum+1];
        maxPoints[1] = points.getOrDefault(1, 0);
        for(int i=2; i<=maxNum; i++){
            maxPoints[i] = Math.max(maxPoints[i-1], points.getOrDefault(i, 0)+maxPoints[i-2]);
        }
        return maxPoints[maxNum];
    }

    /*
    //DFS + Memoization :
    //Time : O(N+k), K = max number
    //Space : O(N+k)
    Map<Integer, Integer> cache;
    Map<Integer, Integer> points;
    public int deleteAndEarn(int[] nums) {
        cache = new HashMap<>();
        points = new HashMap<>();
        int maxNum = Integer.MIN_VALUE;
        for(int num : nums){
            points.put(num, points.getOrDefault(num, 0)+num);
            maxNum = Math.max(maxNum, num);
        }
        return dfs(nums, maxNum);
    }

    private int dfs(int[] nums, int num){
        if(num==0) return 0;
        if(num==1) return points.getOrDefault(num, 0);
        if(cache.containsKey(num)) return cache.get(num);
        int gain = points.getOrDefault(num, 0);
        int prevRes = dfs(nums, num-1);
        int currRes = gain + dfs(nums, num-2);
        cache.put(num, Math.max(currRes, prevRes));
        return cache.get(num);
    }

     */
}

/*
Solution:
1) group all the same number and store their points into map
2) For each element, we either take or don't take. if we take element x, then
   1> firstRes = gain(x) + maxPoint(x-2), take the current element
   2> secondRes = maxPoint(x-1), not take the current(x) element
 */
