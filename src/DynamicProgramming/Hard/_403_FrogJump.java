package DynamicProgramming.Hard;

/**
 * Created by Shuhua Song
 */
public class _403_FrogJump {

    /*
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
