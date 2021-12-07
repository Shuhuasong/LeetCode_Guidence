package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _1737_MaximumNumberOfPointsWithCost {

    long[][] dp;
    public long maxPoints(int[][] points) {
        int rows = points.length, cols = points[0].length;
        dp = new long[rows][cols];
        for(int j=0; j<cols; j++){
            dp[0][j] = points[0][j];
        }

        for(int i=1; i<rows; i++){
            long leftMax = Long.MIN_VALUE;
            for(int j=0; j<cols; j++){
                leftMax = Math.max(leftMax, dp[i-1][j]+j);
                dp[i][j] = Math.max(dp[i][j], leftMax+points[i][j]-j);
            }

            long rightMax = Long.MIN_VALUE;
            for(int j=cols-1; j>=0; j--){
                rightMax = Math.max(rightMax, dp[i-1][j]-j);
                dp[i][j] = Math.max(dp[i][j], rightMax+points[i][j]+j);
            }
        }
        long res = Long.MIN_VALUE;
        for(int j=0; j<cols; j++){
            res = Math.max(res, dp[rows-1][j]);
        }
        return res;
    }

    /*
dp[i][j] : starting from the first row until i-th row, and you pick the max points[i][j]
// Time = O(n^3)===> TLE
for(int i=0; i<m; i++){
  for(int j=0; j<n; j++){
     for(int k=0; k<n; k++){
         dp[i][j] = max{dp[i-1][k] + points[i][j] - abs(j-k)};
     }
  }
}

dp[i][j] = max{dp[i-1][k]+k} + points[i][j]-j;  (k = 0, 1, 2, ..., j)

dp[i][j] = max{dp[i-1][k]-k} + points[i][j]+j;  (k = j, j+1, ..., n-1)
                |
                V
            rolling max

*/



    /*
     long[][] dp;
    public long maxPoints(int[][] points) {
        int rows = points.length, cols = points[0].length;
        long[] prev = new long[cols];
        for(int j=0; j<cols; j++) prev[j] = points[0][j];

        for(int i=1; i<rows; i++){
            long[] left = new long[cols], right = new long[cols], curr = new long[cols];
            left[0] = prev[0]; right[cols-1] = prev[cols-1];

            for(int j=1; j<cols; j++){
                left[j] = Math.max(left[j-1]-1, prev[j]);
            }
            for(int j=cols-2; j>=0; j--){
                right[j] = Math.max(right[j+1]-1, prev[j]);
            }
            for(int j=0; j<cols; j++){
                curr[j] = points[i][j] + Math.max(left[j], right[j]);
            }
            prev = curr;
        }
        long res = 0;
        for(int j=0; j<cols; j++){
            res = Math.max(res, prev[j]);
        }
        return res;
    }
     */
}
