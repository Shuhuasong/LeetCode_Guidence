package Array.Medium;

/**
 * Created by Shuhua Song
 */
public class _287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int idx = 0;
        while(idx < n){
            if(nums[idx] < 0) return idx;
            nums[idx] = -nums[idx];
            idx = Math.abs(nums[idx]);
        }
        return -1;
    }
}
