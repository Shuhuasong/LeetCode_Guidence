package Greedy;

import java.util.Arrays;

public class _45_JumpGameII {

    //Time = O(n) Space = O(1)
    public int jump(int[] nums) {
        int n = nums.length;
        int jump = 0, currEnd = 0, farthest = 0;
        for(int i=0; i<n-1; i++){
            farthest = Math.max(farthest, i+nums[i]);
            if(currEnd == i){
                jump++;
                currEnd = farthest;
            }
        }
        return jump;
    }
   /*
   //DP - Similar with 'longest palindrom substring;
   //Time = O(n^2)
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(j+nums[j] >= i){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[n-1];
    }
    */

}
