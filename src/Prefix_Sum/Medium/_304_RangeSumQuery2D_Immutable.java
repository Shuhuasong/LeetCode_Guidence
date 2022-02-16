package Prefix_Sum.Medium;

/**
 * Created by Shuhua Song
 */
public class _304_RangeSumQuery2D_Immutable {

    //Cache Region: Sum(ABCD)=Sum(OD)−Sum(OB)−Sum(OC)+Sum(OA)
    int[][] dp;
    public _304_RangeSumQuery2D_Immutable(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        dp = new int[rows+1][cols+1];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1] + matrix[i][j] - dp[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
        return sum;
    }

    /*
     //Cache Rows
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        dp = new int[rows][cols+1];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                dp[i][j+1] = dp[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int r=row1; r<=row2; r++){
            sum += dp[r][col2+1] - dp[r][col1];
        }
        return sum;
    }
     */
}
