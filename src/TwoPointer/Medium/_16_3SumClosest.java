package TwoPointer.Medium;

import java.util.Arrays;

public class _16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int result = 0, diff = 0, minDiff = Integer.MAX_VALUE;

        int n = nums.length;
        for(int i=0; i<n; i++){
            int l = i+1, r = n-1;
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];
                diff = Math.abs(target-sum);
                if(minDiff > diff){
                    minDiff = diff;
                    result = sum;
                }
                if(sum < target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return result;
    }
}
