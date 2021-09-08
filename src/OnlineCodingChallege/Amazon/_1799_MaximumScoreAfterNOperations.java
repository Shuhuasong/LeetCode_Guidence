package OnlineCodingChallege.Amazon;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
/*

Since n<=14, it is intuitively to use bitmask to traverse all cases. We can use bitmask to record the positions where the numbers are used. For example, 3 ->00000011, it means the first and second number are used.

Then we employ an array dp to record the maximum score where dp[i] represents the maximum score we can get by using those numbers correponding to the bitmask of i. Then dp[(2^n-1] indicates the final answer.

Since each operation takes 2 numbers, so if the current bitcounts is odd, it can be skipped.

The steps of the solution are as follows:

Compute all candidate GCD pairs, and record the bitmask and GCD value.
Traverse i from 0 to 2^n-1, check for each GCD pair. If the bitmask k of such GCD pair is overlapped with i (e.g., i & k != 0), it means at least one number of this pair is already used, skip it. Otherwise, update dp[i^k] = Math.max(dp[i^k], dp[i] + GCD_value(k) * bitCounts(i) / 2 + 1). Here the bitCounts(i) / 2 means the number of operations for bitmask i.
*/

public class _1799_MaximumScoreAfterNOperations {
    // Time = O(4n^3 * 2^2n) = O(2.2*10^7)
    int[] dp;
    int[][] gcdNum;
    int n;
    public int maxScore(int[] nums) {
        n = nums.length;
        dp = new int[16384]; // 2^14 = 16384
        Arrays.fill(dp, -1);
        gcdNum = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                gcdNum[i][j] = gcd(nums[i], nums[j]);
            }
        }
        return getMax(nums, 0, 1);
    }

    private int getMax(int[] nums, int mask, int k){
        if(dp[mask] != -1) return dp[mask];
        int res = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int a = (1<<i) + (1<<j);
                if((mask & a)==0){
                    res = Math.max(res, k * gcdNum[i][j] + getMax(nums, mask|a, k+1));
                }
            }
        }
        dp[mask] = res;
        return res;
    }

    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
