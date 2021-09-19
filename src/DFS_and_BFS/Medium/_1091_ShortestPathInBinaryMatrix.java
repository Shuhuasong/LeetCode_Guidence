package DFS_and_BFS.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _1091_ShortestPathInBinaryMatrix {


    //BFS : without overwrite the input array
    private static final int dirs[][] = {{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==0 || grid[0].length==0) return -1;
        int rows = grid.length, cols = grid[0].length;
        if(grid[0][0] != 0 || grid[rows-1][cols-1] != 0) return -1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        q.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            int dist = cell[2];
            if(x==rows-1 && y==cols-1) return dist;
            for(int[] next : getNeighbors(x, y, grid)){
                int nx = next[0];
                int ny = next[1];
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, dist+1});
            }
        }
        return -1;
    }

    private List<int[]> getNeighbors(int x, int y, int[][] grid){
        List<int[]> results = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        for(int i=0; i<dirs.length; i++){
            int nx = dirs[i][0] + x;
            int ny = dirs[i][1] + y;
            if(nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 0){
                continue;
            }
            results.add(new int[]{nx, ny});
        }
        return results;
    }


    /*
    //BFS : with overwrite the input array
     private static final int dirs[][] = {{-1,-1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==0 || grid[0].length==0) return -1;
        int n = grid.length;
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        grid[0][0] = 1;
        while(!q.isEmpty()){
               int[] curr = q.remove();
                int x = curr[0];
                int y = curr[1];
                int dist = grid[x][y];
                if(x==n-1 && y==n-1) return dist;

                for(int[] next : getNeighbors(x, y, grid)){
                    int nx = next[0], ny = next[1];
                    q.add(new int[]{nx, ny});
                    grid[nx][ny] = dist + 1;
                }
        }
        return -1;
    }

    private List<int[]> getNeighbors(int x, int y, int[][] grid){
        List<int[]> results = new ArrayList<>();
        for(int i=0; i<dirs.length; i++){
            int nx = x + dirs[i][0];
            int ny = y + dirs[i][1];
            if(nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || grid[nx][ny] != 0){
                continue;
            }
            results.add(new int[]{nx, ny});
        }
        return results;
    }
     */

}
