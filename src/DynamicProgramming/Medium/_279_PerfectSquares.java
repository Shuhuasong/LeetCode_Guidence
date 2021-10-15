package DynamicProgramming.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
/*
rephrase the problem as follows:

Given a list of square numbers and a positive integer number n, one is asked to find a
combination of square numbers that sum up to n, and the combination should contain the
least numbers among all possible solutions.
Note: one could reuse the square numbers in the combination.
 */
public class _279_PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for(int i=1; i<=n; i++){
            for(int s=1; s*s<=i; s++){
                dp[i] = Math.min(dp[i], dp[i-s*s]+1);
            }
        }
        return dp[n];
    }
}
