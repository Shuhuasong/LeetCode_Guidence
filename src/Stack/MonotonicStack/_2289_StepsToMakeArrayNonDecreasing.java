package Stack.MonotonicStack;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _2289_StepsToMakeArrayNonDecreasing {
    public int totalSteps(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int n = nums.length, res = 0;
        for(int i=n-1; i>=0; i--){
            int count = 0;
            while(!stack.isEmpty() && nums[i] > stack.peek()[0]){
                count = Math.max(count+1, stack.peek()[1]);
                stack.pop();
            }
            res = Math.max(res, count);
            stack.push(new int[]{nums[i], count});
        }
        return res;
    }
}

/*
Solution: monotonik stack
Steps:
1) iterate the input A backward,
   then for each A[i], find how many round it can eat on its right
case-1
e.g
     [5,3,4,4,7,3,6,11,8,5,11]
eats  3       2     2       0

5 can eats right number 3,4,4 since they are smaller than 5

case-2:
       0  1  2  3 4  5  6  7  8  9
     [10, 1, 2, 3,4 ,5, 6, 1, 2, 3]
      6                 3
if the answer for 10 can each all right 9 numbers, then it is wrong
correct: 10 eats (1,2,3,4,5,6)
         6  eats (1,2,3)
Iterate from backward:

       dp[0] + 6 when pop all of them out
------
(1,0)
(2,0)
(3,0)
(4,0)
(5,0)
(6,3)
--------
(1,0)    dp[6]+1 when pop(1,0)
(2,0)    dp[6]+1 when pop(2,0)
(3,0)    dp[6]+1 when pop(3,0)

*/
