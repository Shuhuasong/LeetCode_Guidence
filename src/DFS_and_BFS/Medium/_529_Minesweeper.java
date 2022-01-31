package DFS_and_BFS.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _529_Minesweeper {

       /*
    1) check the curr click whether is 'M', then set it to 'X', return
    2) Use 'B' 0r '1'-'8' mark visited;
    3) only add 'E' to queue, and mark it to 'B' as visited.
       so we don't need to check if cell=='M' */


    int rows, cols;
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        rows = board.length; cols = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(click);
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            int numMine = getNumMine(board, x, y);
            //the cell with at least one adjacent min is revealed, then change it
            //to digit to represent the number of mine around it
            if(numMine > 0){
                board[x][y] = (char)(numMine + '0');
                continue;
            }
            //there is no any mine in the neighbor
            board[x][y] = 'B';
            for(int[] dir : dirs){
                int nx = x + dir[0], ny = y + dir[1];
                if(nx < 0 || nx >= rows || ny < 0 || ny >= cols || board[nx][ny]=='B') continue;
                if(board[nx][ny]=='E'){
                    board[nx][ny] = 'B';
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return board;
    }

    private int getNumMine(char[][] board, int r, int c){
        int num = 0;
        for(int[] dir : dirs){
            int x = r + dir[0], y = c + dir[1];
            if(x < 0 || x >= rows || y < 0 || y >= cols) continue;
            if(board[x][y]=='M') num++;
        }
        return num;
    }
}
