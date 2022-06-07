package Backtrack.Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _51_N_Queens {

    //Time = O(N*N!), N = # of rows, each row has N! option
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        dfs(board, 0, results);
        return results;
    }

    private void dfs(char[][] board, int col, List<List<String>> res){
        if(col==board.length){
            List<String> currList = construct(board);
            res.add(new ArrayList<>(currList));
            return;
        }

        for(int r=0; r<board.length; r++){
            if(isValid(board, r, col)){
                board[r][col] = 'Q';
                dfs(board, col+1, res);
                board[r][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col){
        for(int x=0; x<board.length; x++){
            for(int y=0; y<board.length; y++){
                //check if the position with Q is on the same diagnal direction,
                //or at the same row or col
                if(board[x][y]=='Q' && (x+y==row+col || x+col==row+y || x==row || y==col)) return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(int r=0; r<board.length; r++){
            list.add(new String(board[r]));
        }
        return list;
    }
}
