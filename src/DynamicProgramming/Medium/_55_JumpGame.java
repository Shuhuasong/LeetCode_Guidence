package DynamicProgramming.Medium;

public class _55_JumpGame {

    //Time = O(n)  Space = O(n)
  /*  public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(dp[j] && j+nums[j]>=i){
                    dp[i] = true;
                }
            }
        }
        return dp[n-1];
    } */

    //Time = O(n)  Space = O(1)
    public boolean canJump(int[] nums) {
        int n = nums.length;
        //max position one could reach
        //Starting from index <= i
        int maxPos = nums[0];
        for(int i=1; i<n; i++){
            //if one couldn't reach this position
            if(maxPos < i){
                return false;
            }
            maxPos = Math.max(maxPos, i + nums[i]);
        }
        return true;
    }
}

/*
One couldn't reach index i if the maximum position that one could reach starting from the previous cells is less than i.
*/
