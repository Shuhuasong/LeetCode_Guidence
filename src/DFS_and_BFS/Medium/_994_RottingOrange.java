package DFS_and_BFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _994_RottingOrange {

    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        int freshCnt = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    freshCnt++;
                }
            }
        }
        if(freshCnt==0) return 0;
        int time = 0;
        while(!q.isEmpty()){
            time++;
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.remove();
                int x = curr[0];
                int y = curr[1];
                for(int k=0; k<4; k++){
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny]==0 || grid[nx][ny]==2) continue;
                    q.add(new int[]{nx, ny});
                    freshCnt -= 1;
                    grid[nx][ny] = 2;
                }

            }
        }
        return (freshCnt==0 ? time-1 : -1);
    }
}
