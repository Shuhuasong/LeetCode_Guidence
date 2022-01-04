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


    // Time = O(n)   Space =  O(1)
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int maxP = Integer.MIN_VALUE;
        int max = 1, min = 1;

        for(int n : nums){
            if(n<1){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(n, max * n);
            min = Math.min(n, min * n);
            maxP = Math.max(maxP, max);
        }
        return maxP;
    }

  /*
  Approach 2: Dynamic Programming
  max_so_far is updated by taking the maximum value among:

Current number.
This value will be picked if the accumulated product has been really bad (even compared to the current number).
This can happen when the current number has a preceding zero (e.g. [0,4]) or is preceded by a single negative number (e.g. [-3,5]).
Product of last max_so_far and current number.
This value will be picked if the accumulated product has been steadily increasing (all positive numbers).
Product of last min_so_far and current number.
This value will be picked if the current number is a negative number and the combo chain has been disrupted
by a single negative number before (In a sense, this value is like an antidote to an already poisoned combo chain).
  */
}
