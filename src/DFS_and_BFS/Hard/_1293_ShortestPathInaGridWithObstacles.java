package DFS_and_BFS.Hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _1293_ShortestPathInaGridWithObstacles {

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //visited[x][y] == min obstacles to reach (x, y)
        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        if(grid[0][0]==1 && k<=0) return -1;
        int steps = 0;
        q.add(new int[]{0, 0, 0});
        visited[0][0]= 0;
        int res = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cell = q.poll();
                int x = cell[0], y = cell[1];
                int block = cell[2];
                if(x==m-1 && y== n-1){
                    return steps;
                }
                for(int j=0; j<4; j++){
                    int nx = x + dirs[j][0];
                    int ny = y + dirs[j][1];
                    if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
                    int obstacle = block + grid[nx][ny];
                    //if the curr obstacle is greater than old, or greater than k, it is invalid
                    if(obstacle >= visited[nx][ny] || obstacle > k) continue;
                    visited[nx][ny] = obstacle;
                    q.add(new int[]{nx, ny, obstacle});
                }
            }
            steps++;
        }
        return -1;
    }
}
