package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _256_PaintHouse {

    //Time = O(m*n*n), Space = O(m*n)
    int rows, cols;
    int[][] dp;
    public int minCost(int[][] costs) {
        rows = costs.length; cols = costs[0].length;
        dp = new int[rows][cols];
        int minIdx= -1, res = Integer.MAX_VALUE;
        for(int j=0; j<cols; j++){
            dp[0][j] = costs[0][j];
        }
        for(int i=1; i<rows; i++){
            for(int j=0; j<cols; j++){
                dp[i][j] = getMinCost(i-1, j) + costs[i][j];
            }
        }
        for(int c=0; c<cols; c++){
            res = Math.min(res, dp[rows-1][c]);
        }
        return res;
    }

    private int getMinCost(int row, int c){
        int res = Integer.MAX_VALUE;
        for(int j=0; j<cols; j++){
            if(j==c) continue;
            res = Math.min(dp[row][j], res);
        }
        return res;
    }
}
