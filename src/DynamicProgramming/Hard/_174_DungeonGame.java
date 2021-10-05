package DynamicProgramming.Hard;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _174_DungeonGame {
    public int calculateMinimumHP(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows+1][cols+1];
        for(int i=0; i<=rows; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        //To acheive this position, it at least need 1 health
        dp[rows][cols-1] = 1;
        dp[rows-1][cols] = 1;
        for(int i=rows-1; i>=0; i--){
            for(int j=cols-1; j>=0; j--){
                int minHP = Math.min(dp[i+1][j], dp[i][j+1])-grid[i][j];
                //it is not valid when minimum health is less than 1, so we set it at less 1
                if(minHP < 1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = minHP;
                }
            }
        }
        return dp[0][0];
    }
}
