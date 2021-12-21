package DFS_and_BFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _1631_PathWithMinimumEffort {

    //4.Binary Search Using BFS
    //Time = O(m*n)
    //Space = O(m*n)
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int[][] grid;
    public int minimumEffortPath(int[][] grid) {
        this.grid = grid;
        int left = 0, right = 1000000;
        int result = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canReach(mid)){
                result = Math.min(result, mid);
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return result;
    }

    boolean canReach(int mid){
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            if(x==rows-1 && y==cols-1) return true;
            for(int[] dir : dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx<0 || nx>=rows || ny<0 || ny>=cols || visited[nx][ny]){
                    continue;
                }
                int currDiff = Math.abs(grid[nx][ny]-grid[x][y]);
                if(currDiff <= mid){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    /*
      //3.Binary Search Using DFS
    //use DFS to find if there exists a path from the source to destination cell for a given mid
    //Time = O(m*n)
    //Space = O(m*n)
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int[][] grid;
    int rows, cols;
    public int minimumEffortPath(int[][] grid) {
        this.grid = grid;
        int left = 0, right = 1000000;
        rows = grid.length; cols = grid[0].length;
        int result = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(dfsHelper(mid)){
                result = Math.min(result, mid);
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return result;
    }

    private boolean dfsHelper(int mid){
        boolean[][] visited = new boolean[rows][cols];
        return canReach(0, 0, visited, mid);
    }

    boolean canReach(int r, int c, boolean[][] visited, int mid){
        if(r==rows-1 && c==cols-1){
            return true;
        }
        visited[r][c] = true;
        for(int[] dir : dirs){
            int nx = r + dir[0], ny = c + dir[1];
            if(nx<0 || nx>=rows || ny<0 || ny>=cols || visited[nx][ny]){
                continue;
            }
            int currDiff = Math.abs(grid[nx][ny]-grid[r][c]);
            if(currDiff <= mid){
                if(canReach(nx, ny, visited, mid)){
                    return true;
                }
            }
        }
        return false;
    }
     */


    /*
     //2. Dijkstra's Algorithm: finding the shortest path from a source cell to a destination cell
    // shortest path == with minimum absolute difference between the cells
    // Math.abs(A-B) == the weight of (A, B)
    // Time = O(m*n*log(m*n))
    // Space = O(m*n)
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int minimumEffortPath(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        //sort all the reachable cells by its value in diffGrid, the cell with mini abs diff with its adjacent cells will be at the top of queue.
        Queue<int[]> q = new PriorityQueue<>((a, b)->a[2]-b[2]);
        //diffGrid[i][j] : the minimum effort required to reach the cell from all the path
        int[][] diffGrid = new int[rows][cols];
        for(int[] d : diffGrid){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        diffGrid[0][0] = 0;
        boolean[][] visited = new boolean[rows][cols];
        q.add(new int[]{0, 0, diffGrid[0][0]});
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0], y = cell[1], currMinDiff = cell[2];
            visited[x][y] = true;
            if(x==rows-1 && y==cols-1) return currMinDiff;
            for(int[] dir :dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx<0 || nx>=rows || ny<0 || ny>=cols || visited[nx][ny]) continue;
                int currDiff = Math.abs(grid[nx][ny]-grid[x][y]);
                //for each of 4 cells adjacent, get the max abs diff from curr cell to adjacent
                int currMaxDiff = Math.max(currDiff, diffGrid[x][y]);
                //if diffGrid[nx][ny] > currMaxDiff, must update it with currMaxDiff
                //That is, we have found that path from curr cell to adjacent cell takes lesser efforts than the older path
                if(currMaxDiff < diffGrid[nx][ny]){
                    diffGrid[nx][ny] = currMaxDiff;
                    q.add(new int[]{nx, ny, currMaxDiff});
                }
           }
        }
         return diffGrid[rows-1][cols-1];
    }
     */




    //1. BackTrack:
    //Time = O(3^(mn)), considering 3 possible for every cell
    //Space = O(m*n), recursion stack
/*    int minRes = Integer.MAX_VALUE;
    int[][] grid;
    int rows, cols;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int minimumEffortPath(int[][] grid) {
        this.grid = grid;
        rows = grid.length; cols = grid[0].length;
        backtrack(0, 0, 0);
        return minRes;
    }

    private int backtrack(int r, int c, int diff){
        if(r==rows-1 && c==cols-1){
            minRes = Math.min(minRes, diff);
            return diff;
        }
        int currHight = grid[r][c];
        grid[r][c] = 0;
        int minEffort = Integer.MAX_VALUE;
        for(int[] dir : dirs){
            int nx = r+dir[0], ny = c+dir[1];
            if(nx<0 || nx>=rows || ny<0 || ny>=cols || grid[nx][ny]==0) continue;
            int currMaxDiff = Math.max(diff, Math.abs(grid[nx][ny]-currHight));
            if(currMaxDiff < minRes){
                int nextRes = backtrack(nx, ny, currMaxDiff);
                minEffort = Math.min(minEffort, nextRes);
            }

        }
        grid[r][c] = currHight;
        return minEffort;
    } */
}
