package Backtrack.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _698_PartitionToKequalSumSubsets {

    //Time = O(k * 2^N), the total number of recursive calls is: N * (N-1) * (N-2) ....* 2 * 1 = N!
    //and in each recursive call we need perform O(N) time operation
    boolean[] seen;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE, total = 0;
        int n = nums.length;
        for(int a : nums){
            total += a;
            maxVal = Math.max(maxVal, a);
        }
        seen = new boolean[n];
        int t = total/k;
        // If total sum not divisible by k, we can't make subsets.
        if(k<=0 || t < maxVal || total%k != 0) return false;
        //Sort array in decending order. This is because when the change in subset-sum is small,
        //more branches will be repeatedly created during the backtracking process.
        Arrays.sort(nums);
        reverse(nums);
        return backtrack(nums, k, total/k, 0, 0);
    }

    private void reverse(int[] nums){
        int n = nums.length;
        for(int i=0; i<n/2; i++){
            int tmp = nums[i];
            nums[i] = nums[n-i-1];
            nums[n-i-1] = tmp;
        }
    }

    private boolean backtrack(int[] nums, int k, int targetSum, int curSum, int idx){
        if(k==1) return true;//when there is only one bucket left, we can put the rest of number into the bucket
        // When curr sum reaches target then one subset is made.
        // Increment count and reset current sum.
        if(curSum==targetSum){
            return backtrack(nums, k-1, targetSum, 0, 0);
        }
        //if(curSum > targetSum) return false;
        // Try not picked elements to make some combinations.
        for(int i=idx; i<nums.length; i++){
            if(!seen[i] && curSum+nums[i] <= targetSum){
                // Include this element in current subset.
                seen[i] = true;
                // If using current jth element in this subset leads to make all valid subsets.
                if(backtrack(nums, k,  targetSum, curSum+nums[i], i+1)){
                    return true;
                }
                // Backtrack step.
                seen[i] = false;
            }
        }
        // We were not able to make a valid combination after picking each element from the array,
        // hence we can't make k subsets.
        return false;
    }

   /*
    boolean[] seen;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE, total = 0;
        int n = nums.length;
        for(int a : nums){
            total += a;
            maxVal = Math.max(maxVal, a);
        }
        seen = new boolean[n];
        int t = total/k;
        if(k<=0 || t < maxVal || total%k != 0) return false;
        return backtrack(nums, k, total/k, 0, 0, 0);
    }

    private boolean backtrack(int[] nums, int k, int targetSum, int curSum, int idx, int numEle){
        if(k==1) return true;//when there is only one bucket left, we can put the rest of number into the bucket
        if(curSum==targetSum && numEle>0){
            return backtrack(nums, k-1, targetSum, 0, 0, 0);
        }
        // if(curSum > targetSum) return false;
        for(int i=idx; i<nums.length; i++){
            if(!seen[i] && curSum+nums[i] <= targetSum){
                seen[i] = true;
                if(backtrack(nums, k,  targetSum, curSum+nums[i], i+1, numEle++)){
                    return true;
                }
                seen[i] = false;
            }
        }
        return false;
    }
    */
}
