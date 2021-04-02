package BinarySearch.Easy;

import java.util.Arrays;

//Time = O(nlogn) space = O(1)

public class _1608_SpecialArrayWithXElementGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int left =1, right = nums.length;
        Arrays.sort(nums);
        int result = -1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(counts(nums, mid) == mid){
                result = mid;
                break;
            }else if(counts(nums, mid) > mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }

    public int counts(int[] nums, int target){
        int result = 0;
        for(int a : nums){
            if(a >= target){
                result++;
            }
        }
        return result;
    }
}

// Similar question: 274 - H-index
//                   275 - H-index II
