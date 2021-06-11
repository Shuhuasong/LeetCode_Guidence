package Greedy.Medium;

public class _45_JumpGame_II {
   //Time = O(n) , Space = O(1)
    public int jump(int[] nums) {
        int jumps = 0, curJumpEnd = 0, farthest = 0;
        for(int i=0; i<nums.length-1; i++){
            farthest = Math.max(farthest, i+nums[i]);
            if(i==curJumpEnd){
                jumps++;
                curJumpEnd = farthest;
            }
        }
        return jumps;
    }

}

/*
Algorithm

--Initialize three integer variables: jumps to count the number of jumps, currentJumpEnd to mark the end of the range that we can jump to, and farthest to mark the farthest place that we can reach. Set each variable to zero.
--Iterate over nums. Note that we exclude the last element from our iteration because as soon as we reach the last element, we do not need to jump anymore.
    -Update farthest to i + nums[i] if the latter is larger.
    -If we reach currentJumpEnd, it means we finished the current jump, and can begin checking the next jump by setting currentJumpEnd = farthest.
--Return jumps.
 */
