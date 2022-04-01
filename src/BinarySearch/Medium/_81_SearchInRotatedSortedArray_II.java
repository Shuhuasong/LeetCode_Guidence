package BinarySearch.Medium;

/**
 * Created by Shuhua Song
 */
public class _81_SearchInRotatedSortedArray_II {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start+1<end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target) return true;
            if(nums[start] < nums[mid]){
                if(nums[start]<=target && target<=nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else if(nums[start] > nums[mid]){
                if(nums[mid]<=target && target<=nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }else{
                start++;
            }
        }
        if(nums[start]==target || nums[end]==target) return true;
        return false;
    }
}
