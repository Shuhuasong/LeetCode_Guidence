package Backtrack.Hard;

import java.util.HashSet;

/**
 * Created by Shuhua Song
 */
public class _37_SodokuSolver {


    HashSet<Integer>[] rowSet, colSet, boxSet;
    char[][] board;
    int n;
    boolean validSodoku = false;
    public void solveSudoku(char[][] board) {
        this.board = board;
        this.n = board.length;
        rowSet = new HashSet[n];
        colSet = new HashSet[n];
        boxSet = new HashSet[n];
        for(int i=0; i<n; i++){
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='.') continue;
                rowSet[i].add(board[i][j]-'0');
                colSet[j].add(board[i][j]-'0');
                boxSet[(i/3)*3+j/3].add(board[i][j]-'0');
            }
        }
        dfs(0, 0);
    }

    private char[][] dfs(int i, int j){
        if(j==9){
            i++;
            j = 0;
        }
        if(i==9) return board;
        if(board[i][j] != '.'){
            return dfs(i, j+1);
        }
        char[][] currBoard = null;
        for(int k=1; k<=9; k++){
            if(!rowSet[i].contains(k) && !colSet[j].contains(k) && !boxSet[(i/3)*3+j/3].contains(k)){
                //place number in cell
                rowSet[i].add(k);
                colSet[j].add(k);
                boxSet[(i/3)*3+j/3].add(k);
                board[i][j] = (char)(k+'0');
                //place next number
                currBoard = dfs(i, j+1);
                if(currBoard != null) return currBoard;

                //backtrack
                rowSet[i].remove(k);
                colSet[j].remove(k);
                boxSet[(i/3)*3+j/3].remove(k);
            }
        }
        board[i][j] = '.';
        return currBoard;
    }
}
