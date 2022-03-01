package BinarySearch.Medium;

/**
 * Created by Shuhua Song
 */
public class _167_TwoSumII_InputArrayIsSorted {

    //Two Pointer: Time = O(n)
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        while(left < right){
            if(nums[left]+nums[right]==target){
                return new int[]{left+1, right+1};
            }else if(nums[left]+nums[right]<target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    /*
    //Time = O(n*logn), Space = O(1)
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i=0; i<n-1; i++){
            int val = target-nums[i];
            int idx = binarySearch(nums, i+1, val);
            if(idx==-1) continue;
            return new int[]{i+1, idx+1};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int start, int target){
        int left = start, right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid] < target) left = mid + 1;
            else
                right = mid-1;
        }
        return -1;
    } */
}

/*
Solution:
1) fix the first element, the use target to get comp = target-nums[i]
2) use binary search to find the comp from the current position
   second_idx = binarySearch(nums, i, comp)
 */
