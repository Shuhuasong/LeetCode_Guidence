package OnlineCodingChallege.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */

// Given a list of integers, partition it into two subsets S1 and S2 such that the sum of S1 is greater than that of S2.
// And also the number of elements in S1 should be minimal.
// Return S1 in increasing order.
// Notice if more than one subset A exists, return the one with the maximal sum.

// Examples:
// Input:
// nums = [4, 5, 2, 3, 1, 2]
// Output:
// [4, 5]
// Explanation:
// We can divide the numbers into two subsets A = [4, 5] and B = [1, 2, 2, 3]. The sum of A is 9 which is greater than
// the sum of B which is 8. There are other ways to divide but A = [4, 5] is of minimal size of 2.

// Input:
// nums = [10, 5, 3, 1, 20]
// Output:
// [20]

// Input:
// nums = [1, 2, 3, 5, 8]
// Output:
// [5, 8]

public class _BoxWeight_ {

    private static int[] boxWeight(int[] nums){
        if(nums==null ||  nums.length==0) return new int[0];
        int sum = 0, left = 0, right = 0, n = nums.length;
        for(int a : nums) sum += a;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i=n-1; i>=0; i--){
            if(right > sum-right){
                int[] results = new int[list.size()];
                int k = 0;
                for(int a : list){
                    results[k++] = a;
                }
                return results;
            }
            right += nums[i];
            list.add(nums[i]);
        }
        return new int[0];
    }
    public static void main(String[] args) {
         //int[] nums = {4, 5, 2, 3, 1, 2};
         int[] nums = {10, 5, 3, 1, 20};
         int[] results = boxWeight(nums);
        for(int a : results){
            System.out.print(a + " ");
        }
    }
}
