package Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _907_SumOfSubarryMinimum {

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = (int)1e9+7;
        int[] nextSmall = new int[n];
        int[] prevSmall = new int[n];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(prevSmall, -1);
        Arrays.fill(nextSmall, n);

        //get Next_Smaller element for current element
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                int idx = stack.pop();
                nextSmall[idx] = i;
            }
            stack.push(i);
        }

        stack.clear();

        //Get Prev_Smaller element for current element
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                int idx = stack.pop();
                prevSmall[idx] = i;
            }
            stack.push(i);
        }

        long res = 0;
        for(int i=0; i<n; i++){
            long count = (i - prevSmall[i]) * (nextSmall[i] - i) % MOD;
            res =  (res + arr[i] * count) % MOD;
        }
        return (int)res;
    }
}

/*
我们考虑对于每个元素A[i]，如果以它作为最小值，那么这样的subarray能有多大？显然，我们找在i之前的第一个
比A[i]小的数，比如说j；再找i之后第一个比A[i]小的数，比如说k，那么从[j+1,k-1]就是最大的subarray。并且，
以任意[j+1,i]为左边界、任意[i,k-1]为右边界的subarray，也都是以A[i]为最小值。所以，以A[i]为最小的subarray的个数就有(i-j)*(k-i)个。

所以，本题就演变成了求每个元素的next smaller element，以及previous smaller element.这些都是用单调栈算法的经典用法。

但是需要特别注意的是，如果一个subarray里面有多个相同的最小值，那么这个subarray的最小值到底归属于谁呢？
为了避免重复计算，我们需要做额外规定以做区分。比如认为如果有若干个相同的数，则最左边的那个才是最小值。
这样的话，类似[3,4,4,3,4,4,3]这样的subarray，只会在考察第一个3的时候被计入，而在考察其他的3的时候不会被计入。

所以本题确切的说，是求每个元素的next smaller element，以及previous smaller or equal element. 另外，
特别注意：如果一个数没有next smaller element，那么意味着它的左边界是可以到n；如果一个数没有prev smaller/equal element，
那么意味着它的左边界是可以到-1.
*/