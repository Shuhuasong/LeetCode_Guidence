package DFS_and_BFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class _286_WallsAndGates {
    //BFS
    //Time = O(m*n)
    //Space = O(m * n)
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length==0) return;
        int rows = rooms.length, cols = rooms[0].length;
        int[] xdir = {0, 0, 1, -1};
        int[] ydir = {1, -1, 0, 0};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(rooms[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] gate = q.poll();
            int x = gate[0];
            int y = gate[1];
            for(int k=0; k<4; k++){
                int a = x + xdir[k];
                int b = y + ydir[k];
                if(a<0 || a>=rows || b<0 || b>=cols || rooms[a][b]!=Integer.MAX_VALUE){
                    continue;
                }
                rooms[a][b] = rooms[x][y] + 1;
                q.add(new int[]{a, b});
            }
        }
    }
}

