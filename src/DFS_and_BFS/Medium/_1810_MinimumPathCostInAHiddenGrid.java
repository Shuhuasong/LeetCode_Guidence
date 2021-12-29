package DFS_and_BFS.Medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _1810_MinimumPathCostInAHiddenGrid {

    class GridMaster {
        boolean canMove(char direction) {
            return false;
        }
        int move(char direction) {
            return 0;
        }
        boolean isTarget() {
            return false;
        }
    }

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int UNVISITED = 0;
    int PATH = 1;
    int BLOCKED = -1;
    char[] forward = {'U', 'D', 'L', 'R'};
    char[] backward = {'D', 'U', 'R', 'L'};
    int[] target = null;
    GridMaster master;
    int[][] grid;
    int n = 100;
    public int findShortestPath(GridMaster master) {
        this.master = master;
        grid = new int[2*n+1][2*n+1];

        dfs(n, n);

        return target==null ? -1 : bfs();
    }

    private void dfs(int r, int c){
        if(master.isTarget()){
            target = new int[]{r, c};
        }
        //grid[r][c] = PATH; //mark current cell
        for(int i=0; i<4; i++){
            int nx = r + dirs[i][0];
            int ny = c + dirs[i][1];

            if(grid[nx][ny] != UNVISITED) continue;

            char front = forward[i]; //direction for moving
            char back = backward[i];  //direction for backtracking

            if(!master.canMove(front)){
                grid[nx][ny] = BLOCKED;
            }else{
                int cost = master.move(front);
                grid[nx][ny] = cost;
                dfs(nx, ny);
                master.move(back);
            }
        }
    }

    private int bfs(){
        int[][] costs = new int[2*n+1][2*n+1];
        for(int[] costRow : costs){
            Arrays.fill(costRow, Integer.MAX_VALUE);
        }
        costs[n][n] = 0;
        Queue<int[]> q = new PriorityQueue<>((a, b)->a[2]-b[2]);
        q.add(new int[]{n, n, 0});

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            int curCost = cell[2];

            if(x==target[0] && y==target[1]) return curCost;

            for(int[] dir : dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(grid[nx][ny] == BLOCKED) continue;

                int newCost = curCost + grid[nx][ny];
                if(newCost >= costs[nx][ny]) continue;
                costs[nx][ny] = newCost;

                q.add(new int[]{nx, ny, newCost});
            }
        }
        return -1;
    }
}
