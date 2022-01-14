package BinarySearch.Easy;

/**
 * Created by Shuhua Song
 */
public class _704_BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}

/*
case:

[5]
5
need to use condition: l<=r
 */