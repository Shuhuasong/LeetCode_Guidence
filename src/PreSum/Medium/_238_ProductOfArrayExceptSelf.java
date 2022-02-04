package PreSum.Medium;

/**
 * Created by Shuhua Song
 */
public class _238_ProductOfArrayExceptSelf {
    /*
   Note: 1) need to check how many zero has in the array, if zero number greater than 1,
            then, the whole array is zero;
         2) If only less or equal one zero, then check the current element if it is zero;
            if it is zero, then directly equal total;
            it zero==1, then current res[i] = 0, otherwise, res[i] = total/nums[i]
   */
    public int[] productExceptSelf(int[] nums) {
        int total = 1, zero = 0;
        for(int num : nums){
            if(num==0){
                zero++;
                continue;
            }
            total *= num;
        }
        int n = nums.length;
        int[] results = new int[n];
        if(zero > 1) return results;
        for(int i=0; i<n; i++){
            if(nums[i]==0) results[i] = total;
            else if(zero == 1) results[i] = 0;
            else
                results[i] = total/nums[i];
        }
        return results;
    }
}
