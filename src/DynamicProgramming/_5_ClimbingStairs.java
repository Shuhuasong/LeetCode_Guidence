package DynamicProgramming;

public class _5_ClimbingStairs {

    /*
    Approach 1: Brute Force  Time = O(2^n)
    In this brute force approach we take all possible step combinations i.e. 1 and 2, at every step.
    At every step we are calling the function climbStairsclimbStairs for step 11 and 22, and return the
    sum of returned values of both functions.
     climbStairs(i,n)=(i + 1, n) + climbStairs(i + 2, n)

      //Recursion
    public int climbStairs(int n) {
      return climb(0, n);
    }

    private int climb(int i, int n){
        if(i>n) return 0;
        if(i==n) return 1;
        return climb(i+1, n) + climb(i+2, n);
    }

     */

    //#2 Recursion with memory
    //Recursion with memo. Time = O(n) Space = O(n)
  /*  public int climbStairs(int n) {
        int[] memo = new int[n];
        return climb(0, n, memo);
    }

    private int climb(int i, int n, int[] memo){
        if(i>n) return 0;
        if(i==n) return 1;
        if(memo[i] > 0) return memo[i];
        memo[i] =  climb(i+1, n, memo) + climb(i+2, n, memo);
        return memo[i];
    }

   */


    //#Dynamic Programming
    //Time = O(n)  Space = O(n)
    public int climbStairs(int n) {
        if(n<=2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];

        }
        return dp[n];
    }


}
