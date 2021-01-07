package BinarySearch.Medium;

public class _33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {

        int start = 0, end = nums.length-1;
        while(start + 1 < end){
            int mid = start + (end-start)/2;
            if(nums[mid] > nums[start]){
                if(nums[start]<=target && target<nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if(nums[mid]<target && target <= nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        if(nums[start]==target) return start;
        if(nums[end]==target) return end;
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
