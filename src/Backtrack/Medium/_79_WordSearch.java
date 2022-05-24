package Backtrack.Medium;

public class _79_WordSearch {
    //Time = O(N * 3^L), N = the number of cells in the board and L=word.length()
    //Space = O(L), the recursion call of the backtracking function
    char[][] board;
    int ROWS, COLS;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;
        if(word.length()>ROWS*COLS) return false;
        boolean find = false;
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(board[i][j]==word.charAt(0) && backtrack(i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int i, int j, String word, int index){
        //step1: check the bottom case
        if(index==word.length()){
            return true;
        }
        //step2: check the boundaries
        if(i<0 || i==ROWS || j<0 || j==COLS || board[i][j] != word.charAt(index)){
            return false;
        }
        //mark the path before exploration
        char temp = board[i][j];
        board[i][j] = '#';
        //explore the neightbors in DFS
        int[] rows = {0, 1, 0, -1};
        int[] cols = {1, 0, -1, 0};
        boolean find = false;
        for(int k=0; k<4; k++){
            int x = i+rows[k];
            int y = j+cols[k];
            find = backtrack(x, y, word, index+1);
            if(find) return true;
        }
        //Step4: clean up and return the result
        board[i][j] = temp;
        return false;
    }
}

/*
line from 36 - 44 is the same as:
boolean find = backtrack(i+1, j, word, index+1) ||
               backtrack(i-1, j, word, index+1) ||
               backtrack(i, j-1, word, index+1) ||
               backtrack(i, j+1, word, index+1)
 */
