package Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _2104_SumOfSubarrayRanges {
    public long subArrayRanges(int[] A) {
        int n = A.length;
        int[] nextSmaller = new int[n], prevSmaller = new int[n];
        Arrays.fill(nextSmaller, n);
        Arrays.fill(prevSmaller, -1);
        Stack<Integer> stack = new Stack<>();
        //Get next_smaller
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && A[i]<A[stack.peek()]){
                int idx = stack.pop();
                nextSmaller[idx] = i;
            }
            stack.push(i);
        }
        stack.clear();
        //Get prev_smaller
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && A[i]<=A[stack.peek()]){
                int idx = stack.pop();
                prevSmaller[idx] = i;
            }
            stack.push(i);
        }
        stack.clear();

        int[] nextGreater = new int[n], prevGreater = new int[n];
        Arrays.fill(nextGreater, n);
        Arrays.fill(prevGreater, -1);
        //Get next_greater
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && A[i] > A[stack.peek()]){
                int idx = stack.pop();
                nextGreater[idx] = i;
            }
            stack.push(i);
        }
        stack.clear();
        //Get prev_greater
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && A[i] >= A[stack.peek()]){
                int idx = stack.pop();
                prevGreater[idx] = i;
            }
            stack.push(i);
        }
        long res = 0;
        for(int i=0; i<n; i++){
            int left = prevGreater[i], right = nextGreater[i];
            res += (long)A[i] * (i-left) * (right-i);
        }
        for(int i=0; i<n; i++){
            int left = prevSmaller[i], right = nextSmaller[i];
            res -= (long)A[i] * (i-left) * (right-i);
        }
        return res;
    }
}
/*
此题和907.Sum-of-Subarray-Minimums非常相似。我们不是根据每个区间来考察它的最大值（或最小值）。
而是根据根据最大值（或最小值）来考察对应的区间。

我们考察每个元素nums[i]，它作为区间最大值时，可以是哪些区间？假设有a个。另外，它作为区间最小值时，
可以是哪些区间？假设有b个。那么该元素对于最终答案的贡献就是nums[i]*a-nums[i]*b.

那么怎么求解a呢？只要用单调栈，来算出nums[i]的prevSmaller所在的位置l，nextSmaller所在的位置r，
那么这样的区间的数目就有a=(i-l)*(r-i)个。求解b同理。

特别注意的是，对于区间内如果存在多个相同的最大值，我们需要约定，比如只有最靠右边的那个才是最大值。
在这样的情况下，我们实际计算的应该是prevSmallerOrEqual而不是prevSmaller.
 */
