package DFS_and_BFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _1730_ShortestPathToGetFood {
    public int getFood(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]=='*'){
                    q.add(new int[]{i, j});
                    break;
                }
            }
        }
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            for(int i=0; i<size; i++){
                int[] cell = q.poll();
                int x = cell[0], y = cell[1];
                for(int[] dir : dirs){
                    int nx = cell[0] + dir[0], ny =  cell[1] + dir[1];
                    if(nx<0 || nx>=rows || ny<0 || ny>=cols || grid[nx][ny] == 'X') continue;
                    if(grid[nx][ny]=='#')  return steps;
                    grid[nx][ny] = 'X';
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return  -1;
    }
}
