package Prefix_Sum.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _535_ContinuousSubarraySum {
    /*
  Solution: for each prefix sum, we store the reminder into map,
  because we need to check the sum which can be multiplied by k.
  if there are two preSum into two position, that means the sum
  in this two position are multiple of k */
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int rem = k==0 ? sum : sum%k;
            if(map.containsKey(rem)){
                if(map.get(rem) <= i-2)
                    return true;
            }else{
                map.put(rem, i);
            }
        }
        return false;
    }
}

/*
case-1:
[5,0,0,0] k = 3
case-2:
[0]  1
*/
