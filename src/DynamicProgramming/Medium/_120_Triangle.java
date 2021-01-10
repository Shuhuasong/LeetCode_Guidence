package DynamicProgramming.Medium;

import java.util.List;

public class _120_Triangle {

    //DP-rolling array: Time = O(n^2)  space = O(1)
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0) return -1;
        int n = triangle.size();
        //state: dp[x][y] = minimum path value from (0,0) to (x, y)
        int[][] dp = new int[2][n];

        //initialize
        dp[0][0] = triangle.get(0).get(0);

        //top down
        for(int i=1; i<n; i++){
            dp[i%2][0] = dp[(i-1)%2][0] + triangle.get(i).get(0);
            dp[i%2][i] = dp[(i-1)%2][i-1] + triangle.get(i).get(i);
            for(int j=1; j<i; j++){
                dp[i%2][j] = Math.min(dp[(i-1)%2][j], dp[(i-1)%2][j-1]) + triangle.get(i).get(j);
            }
        }
        //get answer
        int minVal = dp[(n-1)%2][0];
        for(int i=1; i<n; i++){
            minVal = Math.min(minVal, dp[(n-1)%2][i]);
        }
        return minVal;
    }

    //DP: Time = O(n^2)  space = O(n)
 /*   public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0) return -1;
        int n = triangle.size();
        //state: dp[x][y] = minimum path value from (0,0) to (x, y)
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        //initialize
        for(int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        //top down
        for(int i=1; i<n; i++){
            for(int j=1; j<i; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
            }
        }
        //get answer
        int minVal = dp[n-1][0];
        for(int i=1; i<n; i++){
            minVal = Math.min(minVal, dp[n-1][i]);
        }
        return minVal;
    }

  */

    //Time = O(n^2) Space = O(n)
 /*   public int minimunTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) return -1;
        if (triangle[0] == null || triangle[0].length == 0) return -1;
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
        }
        int minVal = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            minVal = Math.min(minVal, dp[n - 1][i]);
        }
        return minVal;
    }
  */
}
