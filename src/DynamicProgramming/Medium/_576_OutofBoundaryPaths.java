package DynamicProgramming.Medium;

import java.util.Arrays;

public class _576_OutofBoundaryPaths {

    //Dynamic Programming
    //# of paths from (i,j) to out of boundary <==> # of paths start from out of boundary to (i, j)
    //Time = O(m*n*N), N = # of moves
    //Space = O(m*n*N)
    public int findPaths(int m, int n, int N, int i, int j) { // i = startRow, j = startColumn, N = maxMoves
        int MOD = (int)1e9+7;
        int[][][] dp = new int[N+1][m][n];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for(int move = 1; move<=N; move++){
            for(int x=0; x<m; x++){
                for(int y=0; y<n; y++){
                    for(int k=0; k<4; k++){
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(nx < 0 || nx >= m || ny < 0 || ny >= n){
                            dp[move][x][y] += 1;
                        }else{
                            dp[move][x][y] = (dp[move][x][y] + dp[move-1][nx][ny]) % MOD;
                        }
                    }
                }
            }
        }
        return dp[N][i][j];
    }

    //Solutin-#2
    //Recursion with Memoization
    //Time = O(m*n*N), n = # of moves
    //Space = O(m*n*N), the depth of the recursion tree can go upto n
  /*   public int findPaths(int m, int n, int maxMove, int i, int j) { // i = startRow, j = startColumn
        int[][][] memo= new int[m][n][maxMove+1];
        for(int[][] arr : memo){
            for(int[] a : arr){
                Arrays.fill(a, -1);
            }
        }
        return dfs(m, n, maxMove, i, j, memo);
    }
    private int dfs(int m, int n, int maxMove, int i, int j, int[][][] memo){
        int MOD = (int)1e9+7;
        if(i==m || j==n || i<0 || j<0) return 1;
        if(maxMove==0) return 0;
        if(memo[i][j][maxMove] >= 0) return memo[i][j][maxMove];
        memo[i][j][maxMove] = ( (dfs(m, n, maxMove-1, i-1, j, memo) +
                dfs(m, n, maxMove-1, i+1, j, memo))%MOD +
                (dfs(m, n, maxMove-1, i, j-1, memo) +
                        dfs(m, n, maxMove-1, i, j+1, memo))%MOD ) % MOD;
        return memo[i][j][maxMove];
    } */


    //Solutin-#1
    //Recursion with Memoization(Time Limit Exceeded)
    //Time = O(m*n*N), n = # of moves
    //Space = O(n), the depth of the recursion tree can go upto n
 /*   public int findPaths(int m, int n, int maxMove, int i, int j) { // i = startRow, j = startColumn
        int[][][] memo= new int[m][n][maxMove+1];
        for(int[][] arr : memo){
            for(int[] a : arr){
                Arrays.fill(a, -1);
            }
        }
        return dfs(m, n, maxMove, i, j, memo);
    }
    private int dfs(int m, int n, int maxMove, int i, int j, int[][][] memo){
        int MOD = (int)1e9+7;
        if(i==m || j==n || i<0 || j<0) return 1;
        if(maxMove==0) return 0;
        if(memo[i][j][maxMove] > 0) return memo[i][j][maxMove];
        memo[i][j][maxMove] = ( (dfs(m, n, maxMove-1, i-1, j, memo) +
                dfs(m, n, maxMove-1, i+1, j, memo))%MOD +
                (dfs(m, n, maxMove-1, i, j-1, memo) +
                        dfs(m, n, maxMove-1, i, j+1, memo))%MOD ) % MOD;
        return memo[i][j][maxMove];
    }
  */
}
