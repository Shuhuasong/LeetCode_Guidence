package Array.Medium;

/**
 * Created by Shuhua Song
 */
public class _723_CandyCrush {

    //O((R*C)^2) complexity because each function call scans the board three times so it's 3(R*C). If we only crush 3 candies each time, the function will be called (R*C)/3 times.
    public int[][] candyCrush(int[][] board) {
        int rows = board.length, cols = board[0].length;
        boolean stable = true;
        //mark each rows
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols-2; j++){
                int val = Math.abs(board[i][j]);
                if(val!=0 && Math.abs(board[i][j+1])==val && Math.abs(board[i][j+2])==val){
                    stable = false;
                    board[i][j] = -val;
                    board[i][j+1] = -val;
                    board[i][j+2] = -val;
                }
            }
        }
        //mark each col
        for(int j=0; j<cols; j++){
            for(int i=0; i<rows-2; i++){
                int val = Math.abs(board[i][j]);
                if(val!=0 && Math.abs(board[i+1][j])==val && Math.abs(board[i+2][j])==val){
                    stable = false;
                    board[i][j] = -val;
                    board[i+1][j] = -val;
                    board[i+2][j] = -val;

                }
            }
        }
        //remove
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] < 0){
                    board[i][j] = 0;
                }
            }
        }
        //drop
        for(int j=0; j<cols; j++){
            int bottom = rows-1;
            for(int top=rows-1; top>=0; top--){
                if(board[top][j] > 0){
                    board[bottom--][j] = board[top][j];
                }
            }
            while(bottom >= 0){
                board[bottom][j] = 0;
                bottom--;
            }
        }
        return stable ? board : candyCrush(board);
    }
}
