package DynamicProgramming.Medium;

public class _55_JumpGame {

    //Time = O(n)  Space = O(n)
    //DP
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
    //Greedy
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

    /*
     //Time = O(n), for evey number, we may select or not select
    //DFS + memozation
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        for(int i=1; i<nums.length; i++){
          //we reach the position
           if(i <= maxPos){
               //update the maximum position we can reach
               maxPos = Math.max(maxPos, i+nums[i]);
           }
        }
        return maxPos >= nums.length-1;
    }
     */



    /*
       //Time = O(2^n), for evey number, we may select or not select
       //Time Limit Exceeded
    public boolean canJump(int[] nums) {
        return canReach(0, nums);
    }

    private boolean canReach(int position, int[] nums){
        if(position==nums.length-1) return true;
        int farthest = Math.min(position+nums[position], nums.length-1);
        for(int i=position+1; i<=farthest; i++){
            if(canReach(i, nums)) return true;
        }
        return false;
    }
     */

    /*
     //Time = O(n^2), for evey number, we may select or not select
    //DFS + memozation

    Integer[] memo;
    public boolean canJump(int[] nums) {
        memo = new Integer[nums.length];
        //Arrays.fill(memo, -1);
        memo[nums.length-1] = 1;
        return canReach(0, nums)==1;
    }

    private int canReach(int pos, int[] nums){
        if(memo[pos] != null) return memo[pos];
        int farthest = Math.min(pos+nums[pos], nums.length-1);
        for(int i=pos+1; i<=farthest; i++){
            if(canReach(i, nums)==1){
                return memo[pos]=1;
            }
        }
        return memo[pos] = -1;
    }
     */
}

/*
One couldn't reach index i if the maximum position that one could reach starting from the previous cells is less than i.
*/
