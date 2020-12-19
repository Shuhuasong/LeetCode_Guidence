package BinarySearch.Medium;

public class _240_SearchA2DMatrixII {

    //Time: O(m+n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0){
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = matrix[0].length-1;
        while(x<m && y>=0){
            if(matrix[x][y] < target){
                x++;
            }else if(matrix[x][y] > target){
                y--;
            }else{
                return true;
            }
        }
        return false;
    }
}
