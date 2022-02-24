package Prefix_Sum.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _930_BinarySubarraysWithSum {
    //key:preSum, value: the occurence of the preSum
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0, res = 0;
        map.put(0, 1);
        for(int num : nums){
            preSum += num;
            if(map.containsKey(preSum-goal)){
                res += map.get(preSum-goal);
            }
            map.put(preSum, map.getOrDefault(preSum, 0)+1);
        }
        for(int k : map.keySet()){
            //  System.out.println(k + " " + map.get(k));
        }
        return res;
    }
}

/*
Solution: HashMap + prefix
When we iterate each nums[j], we want to check if there is a subarray
with sum=goal end at j. But where is the start i. There maybe several
start i. So how we check where is the start i.

when we deal with the sum of subarray, we usually use he prefix sum.
sum[i:j] = preSum[j]-preSum[i] = goal
if we fix at j, the prefix[j] is known, so we can use hash to store
prefix sum preSum[i]:
So we have : result += Map[prefix[i]-goal]
*/
