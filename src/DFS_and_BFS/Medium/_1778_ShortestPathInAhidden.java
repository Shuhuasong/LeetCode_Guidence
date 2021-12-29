package DFS_and_BFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */


public class _1778_ShortestPathInAhidden {
    class GridMaster {
        boolean canMove(char direction) {
            return false;
        }
        void move(char direction) {
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
    int n = 500;
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
        grid[r][c] = PATH; //mark current cell
        for(int i=0; i<4; i++){
            int nx = r + dirs[i][0];
            int ny = c + dirs[i][1];

            if(grid[nx][ny] != UNVISITED) continue;

            char front = forward[i]; //direction for moving
            char back = backward[i];  //direction for backtracking

            if(!master.canMove(front)){
                grid[nx][ny] = BLOCKED;
            }else{
                master.move(front);
                dfs(nx, ny);
                master.move(back);
            }
        }
    }

    private int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, n});
        grid[n][n] = BLOCKED; //mark the current cell have been visited
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cell = q.poll();
                int x = cell[0], y = cell[1];
                if(x==target[0] && y==target[1]) return dist;

                for(int[] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if(grid[nx][ny] == BLOCKED) continue;

                    grid[nx][ny] = BLOCKED;
                    q.add(new int[]{nx, ny});
                }
            }
            dist++;
        }
        return dist;
    }
}


/*
Intuitive: BFS + DFS
Normally, we can use BFS to find a shortest path, but the problem here is
the grid is hidden for us, we don't know where is the start point,
where is the target point, we cannot freely run the BFS;
So Use DFS==>
use DFS to find where is the start(r, c) and target(x, y)by using backtrack

Note:
1. the size of board should be 1001 * 1001 and we start from the center (500, 500)
2. the outer rows and columns will all be marked as BLOCK;
Thus there's no need to check boundaries in dfs
Then the key to solve these type of questions is to reconstruct the board using dfs; After we know the board, the rest is very straightforward. This solutions works very well in these questions:

1810. Minimum Path Cost in a Hidden Grid
1778. Shortest Path in a Hidden Grid
Note: if we don't know the size of board, we may use the technique in 489. Robot Room Cleaner: use a HashMap to store the visited "coordinates".
*/