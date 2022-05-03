package DFS_and_BFS.Medium;

import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _1102_PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[0]-a[0]);
        pq.add(new int[]{grid[0][0], 0, 0, grid[0][0]});
        visited[0][0] = true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int minVal = grid[0][0];
        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            int val = cell[0], x = cell[1], y = cell[2];
            minVal = Math.min(minVal, val);
            if(x==rows-1 && y==cols-1) return minVal;
            for(int[] dir : dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx<0 || nx>=rows || ny<0 || ny>=cols || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                pq.add(new int[]{grid[nx][ny], nx, ny});
            }
        }
        return -1;
    }
}
