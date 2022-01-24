package Array.Medium;

/**
 * Created by Shuhua Song
 */
public class _794_ValidTicTacToeState {

    public boolean validTicTacToe(String[] board) {
        int m = board.length, n = board[0].length();
        int[] rows = new int[3], cols = new int[3];
        int diag = 0, antiDiag = 0, turns = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i].charAt(j)=='X'){
                    rows[i]++; cols[j]++;
                    turns++;
                    if(i==j) diag++;
                    if(i+j==2) antiDiag++;
                }else if(board[i].charAt(j)=='O'){
                    turns--; rows[i]--; cols[j]--;
                    if(i==j) diag--;
                    if(i+j==2) antiDiag--;
                }
            }
        }
        boolean xWin = (rows[0]==3 || rows[1]==3 || rows[2]==3 ||
                cols[0]==3 || cols[1]==3 || cols[2]==3 ||
                diag==3 || antiDiag==3);
        boolean oWin = (rows[0]==-3 || rows[1]==-3 || rows[2]==-3 ||
                cols[0]==-3 || cols[1]==-3 || cols[2]==-3 ||
                diag==-3 || antiDiag==-3);
        //(2)
        if(xWin && turns==0 || oWin && turns==1) return false;
        return (turns==0 || turns==1) && !(xWin && oWin);
    }
}

/*
Solution:
1) when X move, turn increase 1, O move, turn decrease 1.
   Arrays rows[] and cols[] store the number of X or O in each of column.
  diag = # of X or O in diagonal,
  antidiag = # of X or O in anti-diagonal
  when any of them gets to 3(X wins) or -3(O wins)
2) when X wins, O cannot move, so turn must be 1.
   when O wins, X cannot move, so turn must be 0.
   finally, turn must be 0 or 1, and X and O cannot win at the same time

["XOX","O O","XOX"]
["XOX"," X ","   "]
["O  ","   ","   "]

*/
