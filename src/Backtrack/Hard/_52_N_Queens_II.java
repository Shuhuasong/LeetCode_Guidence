package Backtrack.Hard;

/**
 * Created by Shuhua Song
 */
public class _52_N_Queens_II {
    //Time = O(n^2n)==> O(n * n!)
    int res = 0;
    public int totalNQueens(int n) {
        if(n<=1) return n;
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        dfs(board, 0);
        return res;
    }

    private void dfs(char[][] board, int col){
        if(col==board.length){
            res++;
            //System.out.println("res = " + res);
            return;
        }
        for(int r=0; r<board.length; r++){
            if(isValid(board, r, col)){
                board[r][col] = 'Q';
                dfs(board, col+1);
                board[r][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int r, int c){
        for(int x=0; x<board.length; x++){
            for(int y=0; y<board.length; y++){
                //check if the position with Q is on the same diagnal direction,
                //or at the same row or col
                if(board[x][y]=='Q' && (x+y==r+c || x+c==r+y || r==x || c==y)) return false;
            }
        }
        return true;
    }
}
