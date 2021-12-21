package DFS_and_BFS.Medium;

/**
 * Created by Shuhua Song
 */
//Time = O(m * n)
//Space = O(1)
public class _1254_NumberOfClosedIslands {

    int[][] grid;
    int rows, cols;
    public int closedIsland(int[][] grid) {
        this.grid = grid;
        rows = grid.length; cols = grid[0].length;

        for(int j=0; j<cols; j++){
            if(grid[0][j]==0){
                dfs(0, j);
            }
            if(grid[rows-1][j]==0){
                dfs(rows-1, j);
            }
        }

        for(int i=0; i<rows; i++){
            if(grid[i][0]==0){
                dfs(i, 0);
            }
            if(grid[i][cols-1]==0){
                dfs(i, cols-1);
            }
        }
        int res = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==0){
                    dfs(i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c){
        if(r<0 || r>=rows || c<0 || c>=cols || grid[r][c]==1){
            return;
        }
        grid[r][c] = 1;
        dfs(r+1, c);
        dfs(r-1, c);
        dfs(r, c+1);
        dfs(r, c-1);
    }

}
