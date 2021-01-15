package DynamicProgramming.Medium;

import java.sql.Time;

public class _718_MaximumLengthOfRepeatedSubarray {
    //Time = O(m * n)  Space = O(m * n)
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m+1][n+1];
        int maxLen = 0;
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(A[i]==B[j]){
                    dp[i][j] = dp[i+1][j+1] + 1;
                    maxLen = Math.max(dp[i][j], maxLen);
                }
            }
        }
        return maxLen;
    }
}
