package Array.Medium;

public class _1749_MaximumAbsoluteSumOfAnySubarray {
    //Time = O(n)
    // Kadane's Algorithm
    public int maxAbsoluteSum(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n = nums.length;
        int result = 0, positive = 0, negative = 0;
        for(int i=0; i<n; i++){
            positive += nums[i];
            negative += nums[i];
            if(positive < 0) positive = 0;
            if(negative > 0) negative = 0;
            result = Math.max(result, Math.max(positive, -negative));
        }
        return result;
    }
}
