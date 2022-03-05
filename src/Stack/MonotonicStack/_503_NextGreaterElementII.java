package Stack.MonotonicStack;

import java.util.Stack;


public class _503_NextGreaterElementII {
    //Time=O(n^2) Space: O(n)  =
  /*  public int[] nextGreaterElements(int[] nums){
        int n = nums.length;
        int[] doubleNums = new int[2 * n];
        int k =0;
        for(int a : nums){
            doubleNums[k++] = a;
        }
        for(int a : nums){
            doubleNums[k++] = a;
        }
        int[] results = new int[n];
        for(int i=0; i<n; i++){
            results[i] = -1;
            for(int j=i+1; j<2*n; j++){
                if(doubleNums[j] > nums[i]){
                    results[i] = doubleNums[j];
                    break;
                }
            }
        }
        return results;
    }

   */

 /*   public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            res[i]=-1;
            for(int j=1; j<nums.length; j++){
                if(nums[(i+j)%nums.length] > nums[i]){
                    res[i] = nums[(i+j) % nums.length];
                    break;
                }
            }
        }
        return res;
    }

  */

    //Use Stack

    //Time=O(n) Space: O(n)
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        for(int a : res){
            System.out.print(a + "  ");
        }
        return res;
    }
}
/*


 */