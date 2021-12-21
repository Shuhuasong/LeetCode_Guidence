package DFS_and_BFS.Medium;

public class _695_MaxAreaOfIsland {

    //DFS
    //Time = O(r*c) Space = O(r*c)

    //Time : O(m*n)
    //Space: O(m*n)
    int[][] grid;
    int rows, cols;
    int maxRes = 0, sum = 0;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        rows = grid.length; cols = grid[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                sum = 0;
                if(grid[i][j]==1){
                    dfs(i, j);
                }
            }
        }
        return maxRes;
    }

    private void dfs(int r, int c){
        if(r<0 || r>=rows || c<0 || c>=cols || grid[r][c]==0){
            // maxRes = Math.max(maxRes, sum);
            return;
        }
        sum++;
        // System.out.println(maxRes + " " + sum + " " + r + "--" + c);
        grid[r][c] = 0;
        dfs(r+1, c);
        dfs(r-1, c);
        dfs(r, c+1);
        dfs(r, c-1);
        maxRes = Math.max(maxRes, sum);

    }

    /*
     //BFS
    //Time : O(m*n)
    //Space: O(1)
    int[][] grid;
    int rows, cols;
    int maxRes = 0, sum = 0;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        rows = grid.length; cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0,-1}, {-1, 0}};
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
              if(grid[i][j]==1){
                   queue.add(new int[]{i, j, 1});
                   grid[i][j] = 0;
                  int area = 1;
                 while(!queue.isEmpty()){
                     int[] cell = queue.poll();
                     int x = cell[0], y = cell[1];
                     maxRes = Math.max(maxRes, area);
                     //System.out.println(maxRes + " " + area + " " + x + "--" + y);
                     for(int[] dir : dirs){
                         int nx = x + dir[0];
                         int ny = y + dir[1];
                         if(nx<0 || nx>=rows || ny<0 || ny>=cols || grid[nx][ny]==0) continue;
                         grid[nx][ny] = 0;
                         area++;
                         queue.add(new int[]{nx, ny});
                     }
                 }
               }
            }
        }

        return maxRes;
    }
     */



  /*  boolean[][] visited;
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
    }  */


}
