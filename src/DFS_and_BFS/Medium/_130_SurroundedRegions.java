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
     char[][] board;
    int rows, cols;
    public void solve(char[][] board) {

        this.board = board;
        rows = board.length; cols = board[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<rows; i++){
           if(board[i][0]=='O'){
               q.add(new int[]{i, 0});
           }
           if(board[i][cols-1]=='O'){
               q.add(new int[]{i, cols-1});
           }
        }
        for(int j=0; j<cols; j++){
             if(board[0][j]=='O'){
                 q.add(new int[]{0, j});
             }
            if(board[rows-1][j]=='O'){
                q.add(new int[]{rows-1, j});
            }
        }

        bfs(q);

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='C'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(Queue<int[]> q){
       int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            board[x][y] = 'C';
            for(int[] dir : dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx<0 || nx>=rows || ny<0 || ny>=cols || board[nx][ny] != 'O') continue;
                board[nx][ny] = 'C';
                q.add(new int[]{nx, ny});
            }
        }
    }

 */
}
