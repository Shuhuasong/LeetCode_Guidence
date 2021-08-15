package CodeSignal;

/**
 * Created by Shuhua Song
 */
/*
Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing sequence by removing no more than one element from the array.

Note: sequence a0, a1, ..., an is considered to be a strictly increasing if a0 < a1 < ... < an. Sequence containing only one element is also considered to be strictly increasing.

Example

For sequence = [1, 3, 2, 1], the output should be
almostIncreasingSequence(sequence) = false.

There is no one element in this array that can be removed in order to get a strictly increasing sequence.

For sequence = [1, 3, 2], the output should be
almostIncreasingSequence(sequence) = true.

You can remove 3 from the array to get the strictly increasing sequence [1, 2]. Alternately, you can remove 2 to get the strictly increasing sequence [1, 3].

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer sequence

Guaranteed constraints:
2 ≤ sequence.length ≤ 105,
-105 ≤ sequence[i] ≤ 105.
 */
public class _AlmostIncreasingSequence {

    boolean almostIncreasingSequence(int[] nums){
        int n = nums.length;
        int count = 0;
        if(nums[0] >= nums[1]) count += 1;
        for(int i=2; i<nums.length; i++){
            if(nums[i-1] >= nums[i]){
                count += 1;
                if(nums[i-2] >= nums[i]){
                    nums[i] = nums[i-1];
                }
            }
        }
        return count<=1;
    }

    /*
    boolean almostIncreasingSequence(int[] nums){
    int n = nums.length;
    int count = 0;
    if(nums[0] >= nums[1]) count += 1;
    for(int i=2; i<nums.length; i++){
        if(nums[i-1] >= nums[i]){
            count += 1;
            if(count > 1) return false;

            if(nums[i-2] >= nums[i]){
                if(i!=n-1 && nums[i-1] >= nums[i+1]){
                    return false;
                }
           }
        }
    }
    return true;
}


    For [1, 2, 5, 4, 6], because 5 is the outlier, 4 should become the new maximum.

   for [1, 4, 5, 2, 6], because 2 is the outlier, 5 should remain as the maximum.
     */
}
