package TwoPointer.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
/*
Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with
nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.
Example 1:

Input: nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
Explanation: We can use 34 and 24 to sum 58 which is less than 60.
Example 2:

Input: nums = [10,20,30], k = 15
Output: -1
Explanation: In this case it is not possible to get a pair sum less that 15.


Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 1000
1 <= k <= 2000

 */
public class _1099_TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        int minDiff = Integer.MAX_VALUE, currDiff = 0;
        int res = Integer.MIN_VALUE;
        while(l < r){
            int sum = nums[l] + nums[r];
            if(sum >= k){
                r--;
            }else{
                currDiff = (k-sum);
                if(currDiff < minDiff){
                    res = Math.max(res, sum);
                }
                l++;
            }

        }
        return res==Integer.MIN_VALUE ? -1 : res;
    }
}
