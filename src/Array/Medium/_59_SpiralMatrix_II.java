package Array.Medium;

/**
 * Created by Shuhua Song
 */
public class _59_SpiralMatrix_II {
    public int[][] generateMatrix(int n) {
        int top = 0, bottom = n-1;
        int left = 0, right = n-1;
        int val = 1;
        int[][] grid = new int[n][n];
        while(left<=right && top<=bottom){
            for(int c=left; c<=right; c++){
                grid[top][c] = val++;
            }
            top++;
            for(int r=top; r<=bottom; r++){
                grid[r][right] = val++;
            }
            right--;
            for(int c=right; c>=left; c--){
                grid[bottom][c] = val++;
            }
            bottom--;
            for(int r=bottom; r>=top; r--){
                grid[r][left] = val++;
            }
            left++;
        }
        return grid;
    }
}
