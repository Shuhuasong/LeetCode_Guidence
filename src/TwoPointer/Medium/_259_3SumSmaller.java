package TwoPointer.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _259_3SumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length, count = 0;
        Arrays.sort(nums);
        for(int i=0; i<n-1; i++){
            int left = i+1, right = n-1;
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum < target){
                    count += right-left;
                    left++;
                }else{
                    right--;
                }
            }
        }
        return count;
    }
}
