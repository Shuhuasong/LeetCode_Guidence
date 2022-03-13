package SlidingWindow.Medium;

/**
 * Created by Shuhua Song
 */
public class _209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for(int r=0; r<nums.length; r++){
            sum += nums[r];
            while(sum >= target){
                res = Math.min(res, r-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return res==Integer.MAX_VALUE ? 0 : res;
    }
}

/*
Solution:
set a left pointer, and iterative right pointer,
for each element, we add it into sum(window).
whenever the condition is satisfy(sum >= target),
we update the result.
*/
