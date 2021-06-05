package BINARYSEARCH_Web.DynamicProgramming;

public class _MaximumProductPathinMatrix {
    public int solve(int[][] matrix) {
        if(matrix==null || matrix.length==0) return -1;
        int m = matrix.length, n = matrix[0].length;
        long[][] minDp = new long[m][n];
        long[][] maxDp = new long[m][n];
        minDp[0][0] = matrix[0][0];
        maxDp[0][0] = matrix[0][0];
        for(int j=1; j<n; j++){
            minDp[0][j] = minDp[0][j-1] * matrix[0][j];
            maxDp[0][j] = maxDp[0][j-1] * matrix[0][j];
        }
        for(int i=1; i<m; i++){
            minDp[i][0] = minDp[i-1][0] * matrix[i][0];
            maxDp[i][0] = maxDp[i-1][0] * matrix[i][0];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] >= 0){
                    maxDp[i][j] = Math.max(maxDp[i-1][j] * matrix[i][j], maxDp[i][j-1]* matrix[i][j]);
                    minDp[i][j] = Math.min(minDp[i-1][j] * matrix[i][j], minDp[i][j-1]* matrix[i][j]);
                }else{
                    maxDp[i][j] = Math.max(minDp[i-1][j] * matrix[i][j], minDp[i][j-1]* matrix[i][j]);
                    minDp[i][j] = Math.min(maxDp[i-1][j] * matrix[i][j], maxDp[i][j-1]* matrix[i][j]);
                }
            }
        }
        if(maxDp[m-1][n-1] < 0) return -1;
        return (int)(maxDp[m-1][n-1]%(1e9+7));
    }
}
