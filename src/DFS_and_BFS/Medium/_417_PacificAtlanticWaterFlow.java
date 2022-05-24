package DFS_and_BFS.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _417_PacificAtlanticWaterFlow {

    //Time = O(m*n), Space = O(m*n)
    int[][] heights;
    int rows, cols;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length; cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlant = new boolean[rows][cols];

        Queue<int[]> qPacif = new LinkedList<>();
        Queue<int[]> qAtlant = new LinkedList<>();
        for(int i=0; i<rows; i++){
            qPacif.add(new int[]{i, 0});
            qAtlant.add(new int[]{i, cols-1});
        }
        for(int j=0; j<cols; j++){
            qPacif.add(new int[]{0, j});
            qAtlant.add(new int[]{rows-1, j});
        }
        // Perform a BFS for each ocean to find all cells accessible by each ocean
        pacific = bfs(qPacif);
        atlant = bfs(qAtlant);

        // Find all cells that can reach both oceans
        List<List<Integer>> results = new ArrayList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(pacific[i][j] && atlant[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i); list.add(j);
                    results.add(list);
                }
            }
        }
        return results;
    }

    private boolean[][] bfs(Queue<int[]> q){
        boolean[][] ans = new boolean[rows][cols];
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            // This cell is reachable, so mark it
            ans[x][y] = true;
            for(int[] dir : dirs){ //// Check all 4 directions
                int nx = x + dir[0], ny = y + dir[1];
                if(nx < 0 || nx>=rows || ny < 0 || ny >= cols) continue;
                // Check that the new cell hasn't already been visited
                if(ans[nx][ny]) continue;
                // Check that the new cell has a higher or equal height,
                // So that water can flow from the new cell to the old cell
                if(heights[nx][ny] < heights[x][y]) continue;
                // If we've gotten this far, that means the new cell is reachable
                q.add(new int[]{nx, ny});
            }
        }
        return ans;
    }


    /*
    //DFS
    //Time = O(m*n), Space = O(m*n)
    int[][] heights;
    int rows, cols;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length; cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlant = new boolean[rows][cols];
         // Loop through each cell adjacent to the oceans and start a DFS
        for(int i=0; i<rows; i++){
            dfs(i, 0, pacific);  //left column === pacific
            dfs(i, cols-1, atlant); //right column == alantic
        }
        for(int j=0; j<cols; j++){
            dfs(0, j, pacific);  // top
            dfs(rows-1, j, atlant); // bottome
        }

         // Find all cells that can reach both oceans
        List<List<Integer>> results = new ArrayList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(pacific[i][j] && atlant[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i); list.add(j);
                    results.add(list);
                }
            }
        }
        return results;
    }

    private void dfs(int r, int c, boolean[][] visited){
         // This cell is reachable, so mark it
        visited[r][c] = true;
        for(int[] dir : dirs){ //// Check all 4 directions
                 int nx = r + dir[0], ny = c + dir[1];
                 if(nx < 0 || nx>=rows || ny < 0 || ny >= cols) continue;
                  // Check that the new cell hasn't already been visited
                 if(visited[nx][ny]) continue;
                  // Check that the new cell has a higher or equal height,
                 // So that water can flow from the new cell to the old cell
                 if(heights[nx][ny] < heights[r][c]) continue;
                  // If we've gotten this far, that means the new cell is reachable
                 dfs(nx, ny, visited);
         }
    }

     */
}

/*
Solution-1: backtrack(dfs)
        1. iterate each cell(node), we check
        1) if there is a path to Pacific,  x < 0 && y < 0
        2) if there is a path to Atlantic, x==row && y==col
        will TLE ==> repeat visited
        time complexity : 4^(mn)


        2. think in oppsite direction
        start from border, and remark visited cell(node)
        the water can flow from lower height to higher height


 */

/*
Solution-1: backtrack(dfs)
1. iterate each cell(node), we check
    1) if there is a path to Pacific,  x < 0 && y < 0
    2) if there is a path to Atlantic, x==row && y==col
   will TLE ==> repeat visited
   time complexity : 4^(mn)


2. think in oppsite direction
   start from border, and remark visited cell(node) : visited[][]
   the water can flow from lower height to higher height
   start Height = 0,
   dfs or bfs
   new height[i][j] < old height[i][j]

   https://docs.google.com/drawings/d/157Ee14FPBtUChv2Hs8fnUGxH18ouKVxOh4xVh83H8BU/edit

   https://docs.google.com/drawings/d/1qdG8_fjf6hWfsUzXaUEYWzYNKkFsEdNHt_qTaAAmulE/edit
   */



