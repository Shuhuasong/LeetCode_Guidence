package Array.Medium;

/**
 * Created by Shuhua Song
 */
public class _1539_KthMissingPositiveNumber {

    public int findKthPositive(int[] A, int k) {
        //if the kth missing is less than arr[0]
        if(k <= A[0]-1) return k;
        k -= A[0]-1;
        int n = A.length;
        //search kth missing between the array numbers
        for(int i=0; i<n-1; i++){
            //missing between arr[i] and arr[i+1]
            int currMissing = A[i+1]-A[i]-1;
            //if the kth missing is between arr[i] and
            //arr[i+1] --> return
            if(currMissing >= k){
                return A[i]+k;
            }
            //otherwise, proceed further
            k -= currMissing;
        }
        //if the missing number greater than arr[n-1]
        return A[n-1]+k;
    }

    /*
    public int findKthPositive(int[] A, int k) {
       int lo = 0, hi = A.length-1;
       while(lo <= hi){
           int mid = lo + (hi-lo)/2;
           //if number of positive integer which are missing before
           //arr[mid] is less than k, then
           //continue to search on the right
           if(A[mid]-mid-1 < k){
               lo = mid + 1;
               //otherwise, go left
           }else{
               hi = mid - 1;
           }
       }
        //At the end of the loop, left = right + 1
        //the kth missing is in-between A[right] and A[left]
        //The number of integer missing before A[right] is
        //A[right] - right -1
        //return: A[right]+k - (A[right]-right-1) = k + left
        return lo + k;
    }
     */
}
