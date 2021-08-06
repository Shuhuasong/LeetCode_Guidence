package Golden_Sach_21FallOA;

/**
 * Created by Shuhua Song
 */
public class _724_FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if(nums.length==0) return -1;
        int n = nums.length;
        int leftSum = 0, sum = 0;
        for(int a : nums) sum += a;
        for(int i=0; i<n; i++){
            if(leftSum==sum-leftSum-nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
