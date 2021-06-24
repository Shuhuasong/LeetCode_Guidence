package Backtrack.Medium;

import java.util.Arrays;

public class _473_MatchsticksToSquare {
    //Time = O(4^n) Space = O(n)
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks==null || matchsticks.length==0) return false;
        int perimeter = 0;
        for(int num : matchsticks){ perimeter += num; }
        if(perimeter%4 != 0) return false;
        Arrays.sort(matchsticks);
        return dfs(matchsticks, 0, perimeter/4, 0, 1, new boolean[matchsticks.length]);
    }

    private boolean dfs(int[] nums, int pos, int target, int tmpSum, int groupId, boolean[] visited){
        if(groupId==4) return true;
        if(tmpSum > target) return false;
        //if the current tempSum = target, we find the match for next group
        if(tmpSum==target){
            return  dfs(nums, 0, target, 0, groupId+1, visited);
        }
        //find a match from pos, and check if we visited it
        for(int i=pos; i<nums.length; i++){
            if(visited[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            if(dfs(nums, i+1, target, tmpSum+nums[i], groupId, visited)) return true;
            visited[i] = false;
        }
        return false;
    }


    /*
      //Time = O(4^n) Space = O(n)
    public boolean makesquare(int[]  matchsticks) {
       // if(matchsticks==null || matchsticks.length==0) return false;
        int perimeter = 0;
        for(int num : matchsticks){ perimeter += num; }
        if(perimeter%4 != 0) return false;
        Arrays.sort(matchsticks);
        return backtrack(matchsticks, 0,  perimeter/4,new int[4]);
    }

    private boolean backtrack(int[] nums, int pos, int target, int[] square){
        if(pos==nums.length){
            return square[0]==square[1] && square[1]==square[2] && square[2]==square[3];
        }
        if(nums[pos] > target) return false;
        for(int i=0; i<4; i++){
            if(square[i]+nums[pos] > target) break;
            square[i] += nums[pos];
            if(backtrack(nums, pos+1, target, square)){
                return true;
            }
            square[i] -= nums[pos];//backtrack
        }
        return false;
    }
     */
}
