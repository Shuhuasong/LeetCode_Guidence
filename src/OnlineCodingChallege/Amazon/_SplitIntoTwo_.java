package OnlineCodingChallege.Amazon;

/**
 * Created by Shuhua Song
 */
public class _SplitIntoTwo_ {

    // Given an array of integers, determine the number of ways the entire array be split into two non-empty subarrays,
    // left and right, such that the sum of elements in the left subarray is greater than the sum of elements in the right
    // subarray.

// Example
// arr =  [10, 4, -8, 7]
// There are three ways to split it into two non-empty subarrays:
// [10] and [4, -8, 7], left sum = 10, right sum = 3
// [10, 4] and [-8, 7], left sum = 10 + 4 = 14, right sum = -8 + 7 = -1
// [10, 4, -8] and [7], left sum = 6, right sum = 7
// The first two satisfy the condition that left sum > right sum, so the return value should be 2.

    private static int splitIntoTwo(int[] nums){
        if(nums==null || nums.length==0) return 0;
        int sum = 0, left = 0, res = 0;
        for(int num : nums) sum += num;
        for(int i=0; i<nums.length; i++){
            if(left > sum-left) res++;
            left += nums[i];
        }
        return res;
    }


   /* private static int splitIntoTwo(int[] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        int n  = nums.length;
        int[] preSum = new int[n];
        int[] sufSum = new int[n];
        preSum[0] = nums[0];
        sufSum[n-1] = nums[n-1];
        for(int i=1; i<n; i++){
            preSum[i] = preSum[i-1] + nums[i];
        }
        for(int i=n-2; i>=0; i--){
            sufSum[i] = sufSum[i+1] + nums[i];
        }
        int res = 0;
        for(int i=0; i<n-1; i++){
            if(preSum[i] > sufSum[i+1]) res++;
        }
        return res;
    } */

    public static void main(String[] args) {
        int[] nums = { 10, 4, -8, 7};
        //int[] nums = { 10, 4, -8, 7, 5};
        System.out.println(splitIntoTwo(nums));
    }
}
