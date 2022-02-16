package DynamicProgramming.Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _403_FrogJump {

    //DP + Map
    //Time = O(n^2)
    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(stones[i], new HashSet<>());
        }
        map.get(stones[0]).add(1);
        int last = stones[n-1];
        for(int i=0; i<n; i++){
            for(int step : map.get(stones[i])){
                int temp = step + stones[i];
                if(temp==last) return true;
                if(map.get(temp) != null){
                    map.get(temp).add(step);
                    map.get(temp).add(step+1);
                    if(step-1>0) map.get(temp).add(step-1);
                }
            }
        }
        return false;
    }


    /*
    //DFS + Memoization
    //Time = O(n^3)
    public boolean canCross(int[] stones) {
        int n = stones.length;
        int[][] memo = new int[n][n];
        for(int[] row : memo) Arrays.fill(row, -1);
        return canReach(stones, 0, 0, memo)==1;
    }

    private int canReach(int[] stones, int idx, int preJumpLen, int[][] memo){
        if(memo[idx][preJumpLen] >= 0) return memo[idx][preJumpLen];
        for(int i=idx+1; i<stones.length; i++){
            int gap = stones[i]-stones[idx];
            if(gap >= preJumpLen-1 && gap <= preJumpLen+1){
                if(canReach(stones, i, gap, memo)==1) {
                    return memo[idx][preJumpLen] = 1;
                }
            }
        }
        return memo[idx][preJumpLen]=(idx==stones.length-1) ? 1 : 0;
    }
     */

    /*  Time = O(3^n)
     //Brute Force--Time Limit Exceeded
    public boolean canCross(int[] stones) {
        return canReach(stones, 0, 0);
    }

    private boolean canReach(int[] stones, int idx, int preJumpLen){
        for(int i=idx+1; i<stones.length; i++){
            int gap = stones[i]-stones[idx];
            if(gap >= preJumpLen-1 && gap <= preJumpLen+1){
                if(canReach(stones, i, gap)) return true;
            }
        }
        return idx==stones.length-1;
    }
     */
}


/*
stones = [0, 1, 3, 5, 6, 8, 12, 17]
map       0  1  2  2  3  3  4    5
                      1  2

*/
