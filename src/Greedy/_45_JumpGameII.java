package Greedy;

public class _45_JumpGameII {

    //Time = O(n) Space = O(1)
    public int jump(int[] nums) {
        if(nums==null || nums.length<=1) return 0;
        int n = nums.length;
        int maxSteps = nums[0], maxPos = nums[0];
        int jump = 1;
        for(int i=1; i<n; i++){
            if(maxSteps < i){
                jump++;
                maxSteps = maxPos;
            }
            maxPos = Math.max(maxPos, i+nums[i]);
        }
        return jump;
    }
}
