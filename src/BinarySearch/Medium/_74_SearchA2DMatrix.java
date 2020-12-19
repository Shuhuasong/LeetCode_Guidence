package BinarySearch.Medium;

public class _74_SearchA2DMatrix {

    //Binary Search: Time = O(m*n) Space= O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0){
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        int mid = 0, midValue = 0;
        while(start <= end){
            mid = start+(end-start)/2;
            midValue = matrix[mid/n][mid%n];
            if(midValue < target){
                start = mid+1;
            }else if(midValue > target){
                end = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
