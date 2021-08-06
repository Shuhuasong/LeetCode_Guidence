package Golden_Sach_21FallOA;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _ProfitTargets_twoSum {

    // Java O(nlogn)
    public static int getUniquePairs(int[] nums, int target){
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int ans = 0;
        while (i < j){
            int sum = nums[i]+ nums[j];
            if (sum < target){
                i++;
            } else if (sum > target){
                j--;
            } else {
                ans++;
                i++;
                j--;
                while (i < j && nums[i] == nums[i-1]){
                    i++;
                }
                while (i < j && nums[j] == nums[j+1]){
                    j--;
                }
            }
        }
        return ans;
    }
}
