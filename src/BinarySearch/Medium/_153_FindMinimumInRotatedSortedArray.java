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
}
