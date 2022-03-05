package Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _1856_MaximumSubarrayMin_Product {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length, MOD = (int)1e9+7;
        int[] nextSmall = new int[n], prevSmall = new int[n];

        Arrays.fill(nextSmall, n);
        Arrays.fill(prevSmall, -1);

        Stack<Integer> stack = new Stack<>();
        //get next smaller element's index for current element
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                int idx = stack.pop();
                nextSmall[idx] = i;
            }
            stack.push(i);
        }

        stack.clear();
        //get prev smaller element's index for current element
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                int idx = stack.pop();
                prevSmall[idx] = i;
            }
            stack.push(i);
        }

        long[] preSum = new long[n];
        preSum[0] = nums[0];
        for(int i=1; i<n; i++){
            preSum[i] = preSum[i-1] + nums[i];
        }
        long res = 0, sum = 0;
        for(int i=0; i<n; i++){
            long leftSum = prevSmall[i]==-1 ? 0 : preSum[prevSmall[i]];
            long rightSum = preSum[nextSmall[i]-1];
            sum = (rightSum-leftSum) * (long)nums[i];
            res = Math.max(res, sum);
        }
        return (int)(res%MOD);
    }
}

/*
此题和LC 907.Sum-of-Subarray-Minimums非常相似，场景也更为直观。传统思维是遍历所有subarray，
寻找每个subarray的最小值。这需要o(N^2)的复杂度。

逆向思维是，遍历每个元素nums[i]，思考以它为最小值的subarray最大是什么。显然，
满足条件的subarray的左右边界之外都应该是恰比nums[i]小的元素，也就是
prev smaller element和next greater element. 这两个位置都是可以用经典的
单调栈算法以均摊o(1)的时间来完成。确定了subarray的边界后，那么subarray sum显然也是
可以用预处理的前缀和以o(1)计算出来。
*/
