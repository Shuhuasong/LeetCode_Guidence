package DynamicProgramming.Easy;

public class _53_MaximumSubarrray {

    /*
DP idea: Time = O(n)  Space = O(1)
    when we encounter a new value, we either take it or not take is
    if we take it, we add this value with previous result and compare with the curent
    value:
    previous + curVal < curVal, we only take curVal single element
    previous + curVal > curVal, we set the curVal = previous + curVal


    nums = [ -2,  1,  -3,  4,  -1,  2,  1,  -5,  4]
curSum       -2   1   -2   4   3    5   6    1   5
maxSum       -2   1   1    4   4    5   6    6   6
*/

    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int n = nums.length;
        int curSum = nums[0], maxSum = nums[0];
        for(int i=1; i<n; i++){
            if(nums[i-1] > 0){
                nums[i] += nums[i-1];//curSum
            }
            maxSum = Math.max(maxSum, nums[i]);
        }
        return maxSum;
    }


    //Greedy Time = O(n)  Space = O(1)
  /*  public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int n = nums.length;
        int curSum = nums[0], maxSum = nums[0];
        for(int i=1; i<n; i++){
            curSum = Math.max(curSum+nums[i], nums[i]);
            maxSum = Math.max(maxSum, curSum);
            System.out.println(curSum + "  " + maxSum);
        }
        return maxSum;
    }

   */

   /*
   // Divide And Conquer:   //Time = O(nlogn) Space = O(n)


       public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length-1);
     }

    private int helper(int[] nums, int left, int right){
        if(left==right) return nums[left];
        int mid = left + (right - left)/2;
        int leftSum = helper(nums, left, mid);
        int rightSum = helper(nums, mid+1, right);
        int crossSum = crossSum(nums, left, right, mid);
        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }

    private int crossSum(int[] nums, int left, int right, int mid){
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


    idea: Algorithm

maxSubArray for array with n numbers:

--If n == 1 : return this single element.

--left_sum = maxSubArray for the left subarray, i.e. for the first n/2 numbers (middle element
 at index (left + right) / 2 always belongs to the left subarray).

--right_sum = maxSubArray for the right subarray, i.e. for the last n/2 numbers.

---cross_sum = maximum sum of the subarray containing elements from both left and right subarrays
and hence crossing the middle element at index (left + right) / 2.

---Merge the subproblems solutions, i.e. return max(left_sum, right_sum, cross_sum).

    */

}


