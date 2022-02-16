package Prefix_Sum;

/**
 * Created by Shuhua Song
 */
public class _RangeSumQuery2D {

    int[][] dp;
    int rows, cols;
    public _RangeSumQuery2D(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return;
        rows = matrix.length;
        cols = matrix[0].length;
        dp = new int[rows+1][cols+1];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1] + matrix[i][j]-dp[i][j];
            }
        }
        for(int i=0; i<=rows; i++){
            for(int j=0; j<=cols; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        System.out.println(dp[row2+1][col2+1]);
        System.out.println(dp[row1][col2+1]);
        System.out.println(dp[row2+1][col1]);
        System.out.println(dp[row1][col1]);
        return dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1] + dp[row1][col1];

    }
}
