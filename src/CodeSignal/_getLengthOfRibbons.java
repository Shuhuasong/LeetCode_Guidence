package CodeSignal;

/**
 * Created by Shuhua Song
 */

/*
You are given an array of integers a, where each element a[i] represents the length of a ribbon.
Your goal is to obtain k ribbons of the same length, by cutting the ribbons into as many pieces as you want.
Your task is to calculate the maximum integer length L for which it is possible to obtain at least k ribbons of length L by cutting the given ones.
For a = [5, 2, 7, 4, 9] and k = 5, the output should be cutTheRibbons(a, k) = 4.
For a = [1, 2, 3, 4, 9] and k = 6, the output should be cutTheRibbons(a, k) = 2.
 */
public class _getLengthOfRibbons {
     public static int getLength(int[] nums, int k){
         int lo = 1, hi = 0;
         for(int num : nums) hi = Math.max(hi, num);
         System.out.println(hi);
         int  res = -1;
         while(lo <= hi){
             int mid = lo + (hi-lo)/2;
             int count = 0;
             for(int num : nums){
                 count += num/mid;
             }
             System.out.println("count = " + count + " " + mid);
             if(count >= k){
                 res = mid;
                 lo = mid + 1;
             }else{
                 hi = mid - 1;
             }
         }
         return res;
     }

    public static void main(String[] args) {
        int[] nums1 = {5, 2, 7, 4, 9};
        int[] nums2 = {1, 2, 3, 4, 9};
        int k1 = 5, k2 = 6;
       System.out.println(getLength(nums1, k1));
        System.out.println(getLength(nums2, k2));
    }
}
