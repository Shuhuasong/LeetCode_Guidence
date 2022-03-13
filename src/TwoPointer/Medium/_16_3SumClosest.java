package TwoPointer.Medium;

import java.util.Arrays;

public class _16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int res = nums[0]+nums[1]+nums[2];
        //int diff = Math.abs(res-target);
        for(int i=0; i<n-2; i++){
            int left = i + 1, right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum-target) <= Math.abs(res-target)){
                    res = sum;
                }
                if(sum <= target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
