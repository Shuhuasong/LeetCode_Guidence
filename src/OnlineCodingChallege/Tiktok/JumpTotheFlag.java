package OnlineCodingChallege.Tiktok;

/**
 * Created by Shuhua Song
 */
/*
Bob is trying to reach a flag that's some height above the ground. In his
attempt to reach the flag, Bob can make any number of jumps up the rock wall there is's mounted.
He can only move up the wall through, and he must end at exactly the height of hte flag.
There are 2 types of jumps
1. a jump of height 1
2. a jump of height j
Determine the minimum number of jumps it will take Bob to reach the flag's height
exactly.
For example, the flag is at heigh k = 8, and jump height j=3, starts at height 0,
takes two jumps of height j and two of height 1 to reach exactly 8 units in 4 jumps. Due to his movement
restriction, he could not jump 3 * j = 9 units and clim down
 */
public class JumpTotheFlag {

  /*  public static int jumps(int k, int j){
        int numJumps = 0;
        int idx = 0;
        while(idx <= k){
            if(idx+j==k || (idx+j)%j != 0){
                numJumps++;
                idx++;
            }else{
                idx += j;
                numJumps++;
            }
        }
        return numJumps;
    } */

    public static int jumps(int k, int j){
        int numJumps = 0;
        numJumps = k/j;
        numJumps += k%j;
        return numJumps;
    }

    public static void main(String[] args) {
        int res = jumps(8, 3);
        System.out.println("res = " + res);
    }
}
