package Array.Medium;

import java.util.Stack;

public class _907_SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] A) {
        int n = A.length, MOD = (int)1e9+7;
        long res = 0;
        int[] left = new int[n], right = new int[n];
        Stack<int[]> s1 = new Stack<>(), s2 = new Stack<>();
        for(int i=0; i<n; i++){
            int count = 1;
            while(!s1.isEmpty() && s1.peek()[0] > A[i]){
                int[] top = s1.pop();
                count += top[1];
            }
            s1.push(new int[]{A[i], count});
            left[i] = count;
        }

        for(int i=n-1; i>=0; i--){
            int count = 1;
            while(!s2.isEmpty() && s2.peek()[0] >= A[i]){
                int[] top = s2.pop();
                count += top[1];
            }
            s2.push(new int[]{A[i], count});
            right[i] = count;
        }

        for(int i=0; i<n; i++){
            res = (res + (long)A[i] * left[i] * right[i])%MOD;
        }
        return (int)res;
    }
}

/*
Intuition:
I guess this is a general intuition for most solution.
res = sum(A[i] * f(i))
where f(i) is the number of subarrays,
in which A[i] is the minimum.

To get f(i), we need to find out:
left[i], the length of strict bigger numbers on the left of A[i],
right[i], the length of bigger numbers on the right of A[i].

Then,
left[i] + 1 equals to
the number of subarray ending with A[i],
and A[i] is single minimum.

right[i] + 1 equals to
the number of subarray starting with A[i],
and A[i] is the first minimum.

Finally f(i) = (left[i] + 1) * (right[i] + 1)

For [3,1,2,4] as example:
left + 1 = [1,2,1,1]
right + 1 = [1,3,2,1]
f = [1,6,2,1]
res = 3 * 1 + 1 * 6 + 2 * 2 + 4 * 1 = 17


Explanation:
To calculate left[i] and right[i],
we use two increasing stacks.

It will be easy if you can refer to this problem and my post:
901. Online Stock Span
I copy some of my codes from this solution.


Complexity:
All elements will be pushed twice and popped at most twice
O(n) time, O(n) space

Eg.  nums = {2, 9, 7, 8, 3, 4, 6, 1}
  hom many subarray with minimum value 3?  since there are 3 numbers(9,7,8) on left of 3 and two numbers(4, 6) greater than 3
  so: (left+1) * (right+1) = (3+1) * (2+1) = 4 * 3 = 12(subarray)
  9, 7, 8, 3,
  9, 7, 8, 3, 4
  9, 7, 8, 3, 4, 6
  7, 8, 3
  7, 8, 3, 4
  7, 8, 3, 4, 6
  8, 3
  8, 3, 4
  8, 3, 4, 6
  3,
  3, 4
  3, 4, 6
 */
