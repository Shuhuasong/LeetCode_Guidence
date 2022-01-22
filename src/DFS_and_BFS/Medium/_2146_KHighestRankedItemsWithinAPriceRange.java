package DFS_and_BFS.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _2146_KHighestRankedItemsWithinAPriceRange {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int row = grid.length, col = grid[0].length;
        List<List<Integer>> results = new ArrayList<>();
        //minHeap
        Queue<int[]> pq = new PriorityQueue<>((a, b)->{
            if(a[2] != b[2]) return a[2]-b[2]; //distance
            else if(grid[a[0]][a[1]] != grid[b[0]][b[1]]){
                return grid[a[0]][a[1]] - grid[b[0]][b[1]];
            }else if(a[0] != b[0]) return a[0]-b[0];
            else
                return a[1]-b[1];
        });
        //don't need to create another array, we set a cell with 0 in original array
        //boolean[][] visited = new boolean[row][col];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        pq.offer(new int[]{start[0], start[1], 0});
        //   visited[start[0]][start[1]] = true;

        while(!pq.isEmpty() && k>0){
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], dist = cell[2];
            // System.out.println(x + "== " + y);
            if(grid[x][y] == 0) continue;

            if(grid[x][y] >= pricing[0] && grid[x][y] <= pricing[1]){
                results.add(List.of(x, y));
                --k;
            }

            for(int[] dir : dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                pq.add(new int[]{nx, ny, dist+1});
                //visited[nx][ny] = true;
                grid[x][y] = 0;
            }

        }
        return results;
    }
}

/*
int[row, col, dist]
Distance, defined as the length of the shortest path from the start (shorter distance has a higher rank).
Price (lower price has a higher rank, but it must be in the price range).
The row number (smaller row number has a higher rank).
The column number (smaller column number has a higher rank).
Solution:
1) Use PriorityQueue to sort the item efficiently with above metrics
2) We can perform a BFS search from the starting position, and know the length of the shortest path from
   start to every item.
3) when a cell poll from queus and it is valid(val in pricing range), we then add them into result.
*/
