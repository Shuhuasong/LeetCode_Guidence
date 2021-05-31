package BinarySearch.Medium;

public class _153_FindMinimumInRotatedSortedArray {

    //Two pointer : Time = O(logn)
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0){
            return -1;
        }
        int start = 0, end = nums.length-1;
        while(start+1<end){
            int mid = start+(end-start)/2;
            if(nums[mid] > nums[start]){ //the smaller element is at right side
                start = mid;
            }else{
                end = mid; //look for smaller answer at left side
            }
        }
        return Math.min(nums[0], Math.min(nums[start], nums[end]));
    }

/*
A = { 4, 5, 7, 0, 1, 2}
if(A[start] < A[mid]) == (4<7):
    it means the left side is acending, we ignore it, and find the minimum on the right side
if(A[start] >= A[mid]) == (4>0):
    it means the right side is acending, we ignore it, and find the minimum on the left side
 */


    /*
    public int findMin(int[] A) {
        // write your code here
         // write your code here
       if(A==null || A.length==0) return -1;
       int start = 0, end = A.length-1;
       int target = A[end];
       while(start+1 < end){
           int mid = start + (end-start)/2;
           if(A[mid] <= target){//
               end = mid;// looking for in the left side to find the smallest one
           }else{
               start = mid;
           }
       }
       return Math.min(A[start], A[end]);
    }


A = { 4, 5, 7, 0, 1, 2, 3}
if(A[mid] < A[end])==> (1<3) :
     it means the right side is acending, we dont't need to think about it.
     And we will find the minimum on left side, so set: end = mid
A = { 4, 5, 7, 0, 1, 2, 3}
if(A[mid] > A[end]) ==> (7 > 3):
     it means the left side is acending, we don't need to think about it,
     and we will find the minimum on the right side, so set: start = mid+1
until start==end, and get Math.min(A[start], A[end])
    */
}
