package Array.Easy;

/**
 * Created by Shuhua Song
 */
public class _1275_FindWinnerOnATicTacToeGame {

    int n = 3;
    public String tictactoe(int[][] moves) {
        int[] rows = new int[n];
        int[] cols = new int[n];
        int player = 1;
        int diagonal = 0, antiDiag = 0;
        for(int[] move : moves){
            int x = move[0];
            int y = move[1];
            rows[x] += player;
            cols[y] += player;
            if(x==y) diagonal += player;
            if(x+y==n-1) antiDiag += player;
            if(Math.abs(rows[x])==n || Math.abs(cols[y])==n ||
                    (x==y && Math.abs(diagonal)==n)
                    || (x+y==n-1 && Math.abs(antiDiag)==n)){
                return player==1 ? "A" : "B";
            }
            player *= -1;
        }
        return moves.length==n*n ? "Draw" : "Pending";
    }
}
