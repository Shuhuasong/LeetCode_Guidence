package TwoPointer.Easy;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _1099_TwoSumLessThanK {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        int maxSum = Integer.MIN_VALUE;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum < k){
                maxSum = Math.max(sum, maxSum);
                left++;
            }else{
                right--;
            }
        }
        return maxSum==Integer.MIN_VALUE ? -1 : maxSum;
    }
}
