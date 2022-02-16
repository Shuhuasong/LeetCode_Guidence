package DFS_and_BFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _994_RottingOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int fresh = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==2) q.add(new int[]{i, j});
                else if(grid[i][j]==1)
                    fresh++;
            }
        }
        if(q.size()==0 && fresh > 0) return -1;
        if(fresh==0) return 0;
        int steps = 0;
        while(!q.isEmpty()){
            steps++;
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cell = q.poll();
                int x = cell[0], y = cell[1];
                for(int[] dir : dirs){
                    int  nx = x + dir[0], ny = y + dir[1];
                    if(nx < 0 || nx >= rows || ny < 0 || ny >= cols || grid[nx][ny] != 1) continue;
                    //decrease the number of fresh
                    fresh -= 1;
                    grid[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
            //If we have rotten all the fresh orange, then we can skip here
            if(fresh==0) break;

        }
        //check if all the orange have been rotten, some fresh oranges can't be rotten, then return -1
        return fresh==0 ? steps : -1;
    }
}
