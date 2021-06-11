package Greedy.Medium;

public class _55_JumpGame {

    //idea: to check if it can reach the last index, we just need to check the current if maxPos >= i,
    // if the maxPos < i, it means it cannot reach the current index
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0) return true;
        int maxPos = nums[0], n = nums.length;
        for(int i=0; i<n; i++){
            if(maxPos < i){
                return false;
            }
            maxPos = Math.max(maxPos, i+nums[i]);
        }
        return true;
    }
}
