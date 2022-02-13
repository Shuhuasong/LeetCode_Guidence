package Graph.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _490_TheMaze {
    //BFS
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        int rows = maze.length, cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = {{0, 1}, {0,-1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            if(x==dest[0] && y == dest[1]) return true;
            //if(cell[0]==dest[0] && cell[1]==dest[1]) return true;
            for(int[] dir : dirs){
                x = cell[0] + dir[0];
                y = cell[1] + dir[1];
                while(x>=0 && y>=0 && x<rows && y<cols && maze[x][y]==0){
                    x += dir[0];
                    y += dir[1];
                }
                //take a step back from wall to empty cell
                x = x - dir[0];
                y = y - dir[1];
                if(!visited[x][y]){
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
