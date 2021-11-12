package DFS_and_BFS.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _694_NumberOfDstinctIslands {
    //Time = O(M * N), Space = O(M*N)
    public int numDistinctIslands(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Set<String> results = new HashSet<>();
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, '0', sb, visited);
                    if(sb.length()==0) continue;
                    results.add(sb.toString());
                    System.out.println(sb.toString());
                }
            }
        }
        return results.size();
    }

    public void dfs(int[][] grid, int i, int j, char dir, StringBuilder sb,
                    boolean[][] visited){
        int rows = grid.length, cols = grid[0].length;
        if(i<0 || i==rows || j<0 || j==cols || grid[i][j]==0
                || visited[i][j]) return;

        visited[i][j] = true;
        sb.append(dir);
        dfs(grid, i-1, j, 'U', sb, visited);
        dfs(grid, i+1, j, 'D', sb, visited);
        dfs(grid, i, j-1, 'L', sb, visited);
        dfs(grid, i, j+1, 'R', sb, visited);
        sb.append('0');
    }
}
