package BinarySearch.Medium;

/**
 * Created by Shuhua Song
 */
public class _378_KthSmallestElementInASortedMatrix {
    //Binary Search: Time = (m+n)*log(Max);
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n-1][n-1];
        while(start <= end){
            int mid = start + (end-start)/2;
            int count = countSmallerOrEqual(matrix, mid);
            if(count < k){
                start = mid+1;
            }else{ //count >= k
                end = mid-1;
            }
        }
        return start;
    }

    private int countSmallerOrEqual(int[][] matrix, int mid){
        int n = matrix.length;
        int row = n-1, col = 0;
        int count = 0;
        while(row >= 0 && col < n){
            if(matrix[row][col]<=mid){
                count += row+1;
                col++;
            }else{
                row--;
            }
        }
        return count;
    }
}
