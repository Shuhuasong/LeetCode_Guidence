package DFS_and_BFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _130_SurroundedRegions {
 //DFS
    Queue<int[]> q;
    int m,n;
    public void solve(char[][] board) {
        m = board.length; n = board[0].length;
        q = new LinkedList<>();
        for(int i=0; i<m; i++){
            q.add(new int[]{i, 0});
            q.add(new int[]{i, n-1});
        }
        for(int j=0; j<n; j++){
            q.add(new int[]{0, j});
            q.add(new int[]{m-1, j});
        }
        for(int[] cell : q){
            dfs(cell[0], cell[1], board);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'Y'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board){
        if(i<0 || i>=m || j<0 || j>=n || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'Y';
        dfs(i+1, j, board);
        dfs(i-1, j, board);
        dfs(i, j+1, board);
        dfs(i, j-1, board);
    }


/* //BFS
    Queue<int[]> q;
    int m,n;
    public void solve(char[][] board) {
        m = board.length; n = board[0].length;
        q = new LinkedList<>();
        for(int i=0; i<m; i++){
            q.add(new int[]{i, 0});
            q.add(new int[]{i, n-1});
        }
        for(int j=0; j<n; j++){
            q.add(new int[]{0, j});
            q.add(new int[]{m-1, j});
        }
        for(int[] cell : q){
            if(board[cell[0]][cell[1]]=='O'){
                bfs(cell[0], cell[1], board);
            }

        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'Y'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(int i, int j, char[][] board){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            if(board[x][y] != 'O') continue;
            board[x][y] = 'Y';
            if(x+1 < m){
                q.add(new int[]{x+1, y});
            }
            if(x > 0){
                q.add(new int[]{x-1, y});
            }
            if(y+1 < n){
                q.add(new int[]{x, y+1});
            }
            if(y > 0){
                q.add(new int[]{x, y-1});
            }
        }
    }

 */
}
