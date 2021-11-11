package DynamicProgramming.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _935_KnightDialer {
    //Time = O(kmn), space = O(kmn) = O(mn)
    //dp[k][i][j] : the number of ways ends on position (i,j) after k hops
    //init : dp[0][*][*] = 1, except dp[3][0] = d[3][2] = 0
    //Transition : dp[k][i][j] = sum(dp[k-1][i'][j']);
    //(i',j') -> (i,j) is a valid knight move and (i',j') is a valid number
    // ans = sum(dp[n-1])
    public int knightDialer(int n) {
        int MOD = (int)1e9+7;
        int[][] dirs = {{-2, -1}, {-2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}, {2, -1}, {2, 1}};
        int[][] dp = new int[4][3];
        for(int[] d : dp) Arrays.fill(d, 1);
        dp[3][0] = 0; dp[3][2] = 0;
        for(int k=1; k<n; k++){
            int[][] temp = new int[4][3];
            for(int i=0; i<4; i++){
                for(int j=0; j<3; j++){
                    if(i==3 && j!=1) continue;
                    for(int[] dir : dirs){
                        int x = i + dir[0];
                        int  y = j + dir[1];
                        if(x<0 || x>=4 || y <0 || y>=3) continue;
                        temp[i][j] = (temp[i][j] + dp[x][y]) % MOD;
                    }
                }
            }
            dp = temp;
        }
        int res = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++){
                res = (res+dp[i][j]) % MOD;
            }
        }
        return res;
    }
}
