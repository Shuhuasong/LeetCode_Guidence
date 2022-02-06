package Backtrack.Hard;

import java.util.HashSet;

/**
 * Created by Shuhua Song
 */
public class _37_SodokuSolver {

     /*
    Time complexity is constant since the board size is fixed(9);
    Time = (9!)^9, for each row, no more than 9 cells to fill. There are more
           than 9 possibilities for the first number to put, not more than 9*8
           for the second one, not more than 9*8*7 for the third one.
           In total, the results for one row possibility is 9!
           there are 9 rows, so Time = (9!)^9 */

    HashSet<Integer>[] rowSet, colSet, boxSet;
    char[][] board;
    boolean sodokuSolved = false;

    public void solveSudoku(char[][] board){
        this.board = board;
        storeOriginNum();
        solved();
    }

    private boolean solved(){
        for(int r=0; r<9; r++){
            for(int c=0; c<9; c++){
                if(board[r][c]=='.'){
                    for(char d='1'; d<='9'; d++){
                        if(isValid(r, c, d)){
                            board[r][c] = d;
                            addIntoSet(r, c, d);
                            if(solved()) return true;
                            //backtracking
                            board[r][c] = '.';
                            removeFromSet(r, c, d);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int r, int c, char d){
        return !rowSet[r].contains(d-'0') &&
                !colSet[c].contains(d-'0') &&
                !boxSet[(r/3)*3+c/3].contains(d-'0');
    }

    private void addIntoSet(int r, int c, char d){
        rowSet[r].add(d-'0');
        colSet[c].add(d-'0');
        boxSet[(r/3)*3+c/3].add(d-'0');
    }

    private void removeFromSet(int r, int c, char d){
        rowSet[r].remove(d-'0');
        colSet[c].remove(d-'0');
        boxSet[(r/3)*3+c/3].remove(d-'0');
    }

    private void storeOriginNum(){
        rowSet = new HashSet[9];
        colSet = new HashSet[9];
        boxSet = new HashSet[9];
        for(int i=0; i<9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.'){
                    int val = board[i][j]-'0';
                    int index = (i/3)*3+j/3;
                    rowSet[i].add(val);
                    colSet[j].add(val);
                    boxSet[index].add(val);
                }
            }
        }
    }

/*
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

 */
}
