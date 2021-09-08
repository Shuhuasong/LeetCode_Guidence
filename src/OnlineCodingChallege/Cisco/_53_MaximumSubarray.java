package OnlineCodingChallege.Cisco;

/**
 * Created by Shuhua Song
 */
public class _53_MaximumSubarray {
    //Time = O(n) Space = O(1)
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int max = nums[0], cur = nums[0];
        for(int i=1; i<nums.length; i++){
            cur = Math.max(cur+nums[i], nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }

    /*
      //Divide and Conquer
    //Time = O(n*logn) Space = O(1)
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public int helper(int[] nums, int left, int right){
        if(left == right) return nums[left];
        int mid = left + (right-left)/2;
        int leftSum = helper(nums, left, mid);
        int rightSum = helper(nums, mid+1, right);
        int crossSum = cross(nums, left, right, mid);
        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }

    public int cross(int[] nums, int left, int right, int mid){
        if(left==right) return nums[left];
        int leftSubSum = Integer.MIN_VALUE;
        int curSum = 0;
        for(int i=mid; i>left-1; i--){
            curSum += nums[i];
            leftSubSum = Math.max(leftSubSum, curSum);
        }
        curSum = 0;
        int rightSubSum = Integer.MIN_VALUE;
        for(int i=mid+1; i<right+1; i++){
            curSum += nums[i];
            rightSubSum = Math.max(rightSubSum, curSum);
        }
        return leftSubSum + rightSubSum;
    }
     */
}
