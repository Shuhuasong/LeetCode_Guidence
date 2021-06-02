package BinarySearch.Medium;

public class _162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int start = 0, end = nums.length-1;
        while(start + 1 < end){
            int mid = start + (end-start)/2;
            if(nums[mid] < nums[mid+1]){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start]>=nums[end]) return start;
        return end;
    }
}
