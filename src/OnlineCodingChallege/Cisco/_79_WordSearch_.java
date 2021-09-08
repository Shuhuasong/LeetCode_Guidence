package OnlineCodingChallege.Cisco;

/**
 * Created by Shuhua Song
 */
public class _79_WordSearch_ {
    int[] rows = {0, 0, 1, -1};
    int[] cols = {1, -1, 0, 0};
    char[][] board;
    int m, n;
    public boolean exist(char[][] board, String word) {
        if(word.length()==0) return true;
        this.board = board;
        m = board.length; n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0) == board[i][j] && backtrack(i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int i, int j, String word, int index){
        if(index==word.length()) return true;
        if(i<0 || i==m || j<0 || j==n || board[i][j] != word.charAt(index)){
            return false;
        }
        board[i][j] = '#';
        boolean isValid = false;
        for(int k=0; k<4; k++){
            isValid = backtrack(i+rows[k], j+cols[k], word, index+1);
            if(isValid){
                break;
            }
        }
        board[i][j] = word.charAt(index);
        return isValid;
    }
}
