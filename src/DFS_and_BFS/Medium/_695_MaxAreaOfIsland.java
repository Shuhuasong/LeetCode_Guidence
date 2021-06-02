package DFS_and_BFS.Medium;

public class _695_MaxAreaOfIsland {

    //DFS
    //Time = O(r*c) Space = O(r*c)
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        visited = new boolean[n][m];
        int maxArea = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        return (1 + dfs(grid, i-1, j) + dfs(grid, i+1, j) + dfs(grid, i, j+1) + dfs(grid, i, j-1));
    }


}
