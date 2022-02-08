package DynamicProgramming;

public class _152_MaximumProductSubarray {

    //brute force Time = O(n^2)   Space =  O(1)
  /*  public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int maxP = nums[0];
        for(int i=0; i<nums.length; i++){
            int prod = 1;
            for(int j=i; j<nums.length; j++){
                prod = prod * nums[j];
                maxP = Math.max(maxP, prod);
            }
        }
        return maxP;
    }

   */


    /*      Kadane Algorithm    */

    // Time = O(n)   Space =  O(1)
    public int maxProduct(int[] nums) {
        int maxP = Integer.MIN_VALUE;
        //use min and max to save the combo chain of
        //min value and max value
        int min = 1, max = 1;
        for(int num : nums){
            if(num < 1){
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(num, max*num);
            min = Math.min(num, min*num);
            maxP = Math.max(maxP, max);
            System.out.println(min + " "+ max + " " + maxP);
        }
        return maxP;
    }

/*
  Approach 2: Dynamic Programming
  max_so_far is updated by taking the maximum value among:


A problem get highest combo chain, which is build up from
prvious combo chains getting.
Two things can disrup the combo chain:
1) zeros ==> reset the combo chain,
2) negative numbers ==> can flip highest num to smallest num
   but if there is a second negative==> become a positive num again


Algorithm:

1)  Current number.
This value will be picked if the accumulated product has been really bad (even compared to the current number).
This can happen when the current number has a preceding zero (e.g. [0,4]) or is preceded by a single negative number (e.g. [-3,5]).
2) Product of last max_so_far and current number.
This value will be picked if the accumulated product has been steadily increasing (all positive numbers).
3) Product of last min_so_far and current number.
This value will be picked if the current number is a negative number and the combo chain has been disrupted
by a single negative number before (In a sense, this value is like an antidote to an already poisoned combo chain).
  */
}
