package Backtrack.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _698_PartitionToKequalSumSubsets {

    //BackTracking + Memoization
    //Time = O(k*2^N), for each recursion call, we iterate over N elements and make another recursion call. After pick one element, we iterate over the array and make recursive calls for the next N-1 elems.
    //Space = O(N)
    Map<String, Boolean> memo;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0, maxVal = Integer.MIN_VALUE;
        for(int num : nums){
            total += num;
            maxVal = Math.max(maxVal, num);
        }
        if(k<=0 || maxVal > total/k || total%k != 0) return false;
        int sum = total/k, n = nums.length;
        char[] taken = new char[n];
        for(int i=0; i<n; i++) taken[i] = '0';
        Arrays.sort(nums);
        reverse(nums);
        memo = new HashMap<>();
        return dfs(nums, 0, total/k, k, taken, 0);
    }

    private boolean dfs(int[] nums, int currSum, int target, int k, char[] taken, int idx){
        if(k==1) return true;
        String takenStr = new String(taken);
        if(memo.containsKey(takenStr)) return memo.get(takenStr);
        if(currSum == target){
            boolean res = dfs(nums, 0, target, k-1, taken, 0);
            memo.put(takenStr, res);
            return res;
        }
        for(int i=idx; i<nums.length; i++){
            if(taken[i] == '0' && currSum+nums[i] <= target){
                taken[i] = '1';
                if(dfs(nums, currSum+nums[i], target, k, taken, i+1)){
                    return true;
                }
                taken[i] = '0';
            }
        }
        return false;
    }

    private void reverse(int[] nums){
        int n = nums.length;
        for(int i=0; i<nums.length/2; i++){
            int temp = nums[i];
            nums[i] = nums[n-i-1];
            nums[n-i-1] = temp;
        }
    }



    //Time = O(k * 2^N), the total number of recursive calls is: N * (N-1) * (N-2) ....* 2 * 1 = N!
    //and in each recursive call we need perform O(N) time operation
 /*   boolean[] seen;
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
        //If a current element did not fit in the subset earlier, it would not fit element later
        Arrays.sort(nums);
        reverse(nums);
        //start from 0th index and include it in our current subset
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
                // If using current ith element in this subset leads to make all valid subsets.
                // continue traverse from the next index of the previously picked index instead of
                // traverse again and again from the beginning
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
    } */



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
