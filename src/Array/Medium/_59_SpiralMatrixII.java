package Array.Medium;

/**
 * Created by Shuhua Song
 */
public class _59_SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, left = 0;
        int bottom = n-1, right = n-1;
        int val = 1;
        while(top < bottom && left < right){
            for(int j=left; j<right; j++) { matrix[top][j] = val; val++; }
            for(int i=top; i<bottom; i++) { matrix[i][right] = val; val++; }
            for(int j=right; j>left; j--) { matrix[bottom][j] = val; val++; }
            for(int i=bottom; i>top; i--) { matrix[i][left] = val; val++; }
            left++;
            right--;
            top++;
            bottom--;
        }


        if(left==right){
            for(int i=top; i<=bottom; i++) { matrix[i][left] = val; val++; }
        }else if(top==bottom){
            for(int j=left; j<=right; j++) { matrix[top][j] = val; val++; }
        }

        return matrix;
    }
}
