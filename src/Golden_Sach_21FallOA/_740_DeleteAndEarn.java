package Golden_Sach_21FallOA;

/**
 * Created by Shuhua Song
 */
public class _740_DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        if(nums.length==0) return 0;
        int range = 0;
        for(int a : nums) range = Math.max(range, a);
        int[] bank = new int[range+1];
        for(int num : nums){
            bank[num] += num;
        }
        return rob(bank);
    }

    public int rob(int[] bank){
        int dp1 = 0, dp2 = 0;
        for(int i=0; i<bank.length; i++){
            int dp = Math.max(dp2 + bank[i], dp1);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}
