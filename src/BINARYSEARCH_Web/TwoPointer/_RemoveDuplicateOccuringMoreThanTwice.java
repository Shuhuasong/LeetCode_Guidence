package BINARYSEARCH_Web.TwoPointer;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
/*
 Solution:
 1) mark the duplicate number that are two more than once
 2) than move all the numbers which is once or twice from right to left
 */
public class _RemoveDuplicateOccuringMoreThanTwice {

    public int[] solve(int[] nums) {
        if(nums==null || nums.length<=2) return nums;
        int count = 1, n = nums.length, l = 0;
        int prev = nums[0];
        for(int r=1; r<n; r++){
            if(nums[r]==prev){
                count++;
                if(count>2){
                    nums[r] = -1;
                }
            }else{
                count = 1;
                prev = nums[r];
            }
        }
      /* for(int a : nums){
             System.out.print(a + " ");
         } */
        l = 0;
        for(int r=0; r<n; r++){
            if(nums[r] != -1){
                nums[l] = nums[r];
                l++;
            }
        }
        /*for(int a : nums){
             System.out.print(a + " ");
         } */
        return Arrays.copyOfRange(nums, 0, l);
    }
}
