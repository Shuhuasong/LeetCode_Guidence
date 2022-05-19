package Backtrack.Medium;

/**
 * Created by Shuhua Song
 */
public class _1219_PathWithMaximumGold {

    //Time = O(k * 3^k), k = the number of cells
    //space = O(k)
    private final static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int rows, cols;
    int maxRes = 0;
    public int getMaximumGold(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        for(int r=0;r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c]==0) continue;
                int sum = dfs(grid, r, c);
                maxRes = Math.max(maxRes, sum);
            }
        }
        return maxRes;
    }

    private int dfs(int[][] grid, int r, int c){
        if(r<0 || r>=rows || c<0 || c>=cols || grid[r][c]==0){
            return 0;
        }
        int currSum = grid[r][c];
        grid[r][c] = 0;
        int maxSum = 0;
        for(int[] dir : dirs){
            int x = dir[0] + r;
            int y = dir[1] + c;
            maxSum = Math.max(maxSum, dfs(grid, x, y));
        }
        grid[r][c] = currSum;
        return currSum+maxSum;
    }
}

/*
Solution -- brute force(DFS)
1) iterate each cell and dfs for each cell which if greater than 0
2) return a total of number of gold
3) update with global varaible max

Note: we can't use memo array to store the previous max value,
      because to explore a path is not one direction
      */
