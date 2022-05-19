package DFS_and_BFS.Medium;

/**
 * Created by Shuhua Song
 */
public class _1905_CountSubIsland {

    int rows, cols;
    private final static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        rows = grid2.length;
        cols = grid2[0].length;
        int count = 0;
        boolean[][] visited = new boolean[rows][cols];
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid2[r][c]==1 && !visited[r][c]){
                    if(isSubIsland(grid1, r, c, visited, grid2)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isSubIsland(int[][] grid1, int r, int c, boolean[][] visited, int[][] grid2){
        if(r<0 || r>=rows || c<0 || c>=cols || grid2[r][c]==0 || visited[r][c]){
            return true;
        }
        if(grid1[r][c]==0) return false;
        visited[r][c] = true;
        boolean res = true;
        for(int[] dir : dirs){
            int x = r + dir[0];
            int y = c + dir[1];
            res &= isSubIsland(grid1, x, y, visited, grid2);
        }
        return res;
    }
}

/*
Solution-1:
1) find each island in grid2 by collecting (x, y) for each cell:
   e.g  list = {(0, 0), {0, 1}, {0, 2}, {0, 3}......}
2) then check the list, to see if every cell is exist in grid1

Solution-2:
1) iterate each cell for each island, once find one cell is not
   exist in the grid1, we exist
2) if iterate all the cells in this island, and every cell in
   grid1, then we can sure the

   */
