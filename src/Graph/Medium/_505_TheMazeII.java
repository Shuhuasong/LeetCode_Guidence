package Graph.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _505_TheMazeII {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length, cols = maze[0].length;
        int[][] distance = new int[rows][cols];
        for(int[] distRow : distance) Arrays.fill(distRow, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dijikstra(maze, start, distance);
        int dx = destination[0], dy = destination[1];
        if(distance[dx][dy]==Integer.MAX_VALUE) return -1;
        return distance[dx][dy];
    }

    private void dijikstra(int[][] maze, int[] start, int[][] dist){
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->a[2]-b[2]);
        minHeap.offer(new int[]{start[0], start[1], 0});

        while(!minHeap.isEmpty()){
            int[] cell = minHeap.poll();
            for(int[] dir : dirs){
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                int count = 0;
                while(x>=0 && x<maze.length && y>=0 && y<maze[0].length && maze[x][y]==0){
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                x -= dir[0];
                y -= dir[1];
                if(dist[cell[0]][cell[1]] + count < dist[x][y]){
                    dist[x][y] = dist[cell[0]][cell[1]] + count;
                    minHeap.add(new int[]{x, y, dist[x][y]});
                }
            }
        }
    }
}
