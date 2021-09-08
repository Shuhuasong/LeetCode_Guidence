package BinarySearch.Medium;

public class _154_FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1;
        int n = nums.length;
        while(lo + 1 < hi){
            while(lo < n-1 && nums[lo] == nums[lo+1]){
                lo++;
            }
            while(hi > 0 && nums[hi] == nums[hi-1]){
                hi--;
            }
            int mid = lo + (hi-lo)/2;
            if(nums[mid] < nums[hi]){
                hi = mid;
            }else{
                lo = mid;
            }
        }
        return Math.min(nums[hi], nums[lo]);
    }

/*   public int findMin(int[] nums){
        if(nums==null || nums.length==0) return -1;
        int start = 0, end = nums.length-1;
        while(start +1  < end){
            int mid = start + (end-start)/2;
            if(nums[end] < nums[mid]){
                start = mid;
            }else if(nums[end] > nums[mid]){
                end = mid;
            }else{
                end = end - 1;
            }

        }
        return Math.min(nums[0], Math.min(nums[start], nums[end]));
    } */
}
/*
break it down concisely into three cases
Case 1). nums[pivot] < nums[high]  ---> high = pivot
Case 2). nums[pivot] > nums[high]  ---> low = pivot
Case 3). nums[pivot] == nums[high] ---> high = high - 1 (to reduce the upper bound)

In this case, we are not sure which side of the pivot that the desired minimum element would reside.
To further reduce the search scope, a safe measure would be to reduce the upper bound by one (i.e. high = high - 1), rather than moving aggressively to the pivot point.
The above strategy would prevent the algorithm from stagnating (i.e. endless loop). More importantly, it maintains the correctness of the procedure, i.e. we would not end up with skipping the desired element.
To summarize, this algorithm differs to the classical binary search algorithm in two parts:

We use the upper bound of search scope as the reference for the comparison with the pivot element, while in the classical binary search the reference would be the desired value.
When the result of comparison is equal (i.e. Case #3), we further move the upper bound, while in the classical binary search normally we would return the value immediately.
 */