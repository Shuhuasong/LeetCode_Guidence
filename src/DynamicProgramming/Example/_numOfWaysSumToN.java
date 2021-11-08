package DynamicProgramming.Example;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
/*
Given 3 numbers {1, 3, 5}, we need to tell
the total number of ways we can form a number 'N'
using the sum of the given three numbers.
(allowing repetitions and different arrangements).

Analyze:
Total number of ways to form 6 is: 8
1+1+1+1+1+1
1+1+1+3
1+1+3+1
1+3+1+1
3+1+1+1
3+3
1+5
5+1
Let’s think dynamically about this problem. So, first of all, we decide a state for the given problem. We will take a parameter n to decide state as it can uniquely identify any subproblem. So, our state dp will look like state(n). Here, state(n) means the total number of arrangements to form n by using {1, 3, 5} as elements.
Now, we need to compute state(n).

How to do it?
So here the intuition comes into action. As we can only use 1, 3 or 5 to form a given number. Let us assume that we know the result for n = 1,2,3,4,5,6 ; being termilogistic let us say we know the result for the
state (n = 1), state (n = 2), state (n = 3) ……… state (n = 6)
Now, we wish to know the result of the state (n = 7). See, we can only add 1, 3 and 5. Now we can get a sum total of 7 by the following 3 ways:

1) Adding 1 to all possible combinations of state (n = 6)
Eg : [ (1+1+1+1+1+1) + 1]
[ (1+1+1+3) + 1]
[ (1+1+3+1) + 1]
[ (1+3+1+1) + 1]
[ (3+1+1+1) + 1]
[ (3+3) + 1]
[ (1+5) + 1]
[ (5+1) + 1]

2) Adding 3 to all possible combinations of state (n = 4);
Eg : [(1+1+1+1) + 3]
[(1+3) + 3]
[(3+1) + 3]



3) Adding 5 to all possible combinations of state(n = 2)
Eg : [ (1+1) + 5]

Now, think carefully and satisfy yourself that the above three cases are covering all possible ways to form a sum total of 7;
Therefore, we can say that result for
state(7) = state (6) + state (4) + state (2)
or
state(7) = state (7-1) + state (7-3) + state (7-5)
In general,
state(n) = state(n-1) + state(n-3) + state(n-5)
So, our code will look like:
 */
public class _numOfWaysSumToN {
    public static int[] dp;
    public static int numWays(int n){
        if(n < 0) return 0;
        if(n == 0) return 1;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        if(dp[n] != -1){

            return dp[n];
        }
        //System.out.println(n + " " + dp[n]);
        return dp[n] = numWays(n-1) + numWays(n-3) + numWays(n-5);
    }


    /*
    //Method #1:
    //code seems exponential as it is calculating the same state again and again.
    public int numWays(int n){
        if(n < 0) return 0;
        if(n==0) return 1;
        return numWays(n-1)+numWays(n-3)+numWays(n-5);
    }  */

    public static void main(String[] args) {
        System.out.println(numWays(6));
    }
}
