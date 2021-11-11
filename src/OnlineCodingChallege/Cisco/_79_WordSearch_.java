package OnlineCodingChallege.Cisco;

/**
 * Created by Shuhua Song
 */
public class _79_WordSearch_ {

    //Time : O(mn * 3^L), mn = the size of board, L = word.length
    //Space :O(L) , recursion call of the backtracking
    int rows, cols;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        rows = board.length; cols = board[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]==word.charAt(0) && dfs(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int idx, int i, int j){
        //Bottom Case-1: check if we reach the bottom case of the recursion, where
        //the wordis empty
        if(idx == word.length()) return true;
        //Case-2: check if the current state is invalid, either the position of the cell is out of boundary of the board or the current letter not match
        if(i==rows || i<0 || j==cols || j<0 || word.charAt(idx) != board[i][j] ){
            return false;
        }
        //If the current step is valid, we then start the exploration of backtracking with the strategy of DFS
        //mark the current position before jumping into the next step
        board[i][j] = '#';
        boolean isValid = false;
        //Iterate through 4 directions
        for(int k=0; k<4; k++){
            isValid = dfs(board, word, idx+1, i+dirs[k][0], j+dirs[k][1]);
            if(isValid){
                break;
            }
        }
        //at the end of each step, revert our marking, so that we can have a clean
        //state to try another direction
        board[i][j] = word.charAt(idx);
        return isValid;
    }
}
