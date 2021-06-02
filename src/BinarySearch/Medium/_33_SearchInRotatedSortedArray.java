package BinarySearch.Medium;

public class _33_SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        // write your code here
        if(A==null || A.length==0){
            return -1;
        }
        int left = 0, right = A.length-1;
        while(left + 1 < right){
            int mid = left + (right-left)/2;
            if(A[mid] > A[left]){ //increase part
                //left and mid are the acending  array side
                if((A[left] <= target) && (target < A[mid])){
                    right = mid; //find in left part
                }else{
                    left =  mid; //find in right part
                }
            }else{
                //left is on the left acending half array, mid is on the right acending half array
                // so the mid->right is in acending order
                if((A[mid] < target) && target <= A[right] ){
                    left = mid; //find in mid < target < right
                }else{
                    right = mid; //find in left < target < mid
                }
            }
        }
        if(A[left] == target) return left;
        if(A[right] == target) return right;
        return -1;
    }
}

/*
Algorithm

As in the normal binary search, we keep two pointers (i.e. start and end) to track the search scope. At each iteration, we reduce the search scope into half, by moving either the start or end pointer to the middle (i.e. mid) of the previous search scope.

Here are the detailed breakdowns of the algorithm:

1)  Initiate the pointer start to 0, and the pointer end to n - 1.

2)  Perform standard binary search. While start <= end:

Take an index in the middle mid as a pivot.

If nums[mid] == target, the job is done, return mid.

Now there could be two situations:

Pivot element is larger than the first element in the array, i.e. the subarray from the first element to the pivot is non-rotated, as shown in the following graph.
   - If the target is located in the non-rotated subarray:
  go left: `end = mid - 1`.

  - Otherwise: go right: `start = mid + 1`.
3)  Pivot element is smaller than the first element of the array, i.e. the rotation index is somewhere between 0 and mid. It implies that the sub-array from the pivot element to the last one is non-rotated, as shown in the following graph.
 - If the target is located in the non-rotated subarray:
  go right: `start = mid + 1`.

  - Otherwise: go left: `end = mid - 1`.
We're here because the target is not found. Return -1.

 */
