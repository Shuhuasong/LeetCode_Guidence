package Array.Medium;

/**
 * Created by Shuhua Song
 */
public class _289_GameOfLife {
    //10: 1-->0
    //20: 0-->1
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int numLive = getNumLives(board, i, j);
                if(board[i][j]==1){
                    if(numLive < 2 || numLive > 3){
                        board[i][j] = 10;
                    }
                }else{
                    if(numLive==3){
                        board[i][j] = 20;
                    }
                }
            }
        }
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(board[r][c]==10) board[r][c] = 0;
                else if(board[r][c]==20) board[r][c] =1;
            }
        }
    }

    private int getNumLives(int[][] board, int row, int col){
        int count = 0, rows = board.length, cols = board[0].length;
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int[] dir : dirs){
            int nx = row + dir[0], ny = col + dir[1];
            if(nx<0 || nx>=rows || ny<0 || ny>=cols) continue;
            if(board[nx][ny]==1 || board[nx][ny]==10) count++;
        }
        return count;
    }
}
