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

    /*
     public String tictactoe(int[][] moves) {
        int[] rowA = new int[3], rowB = new int[3];
        int[] colA = new int[3], colB = new int[3];
        int diagA = 0, diagB = 0, antiDirA = 0, antiDirB = 0;
        for(int i=0; i<moves.length; i++){
            int[] m = moves[i];
            //A term
            if(i%2==0){
                rowA[m[0]]++;
                colA[m[1]]++;
                if(m[0]==m[1]) diagA++;
                if(m[0]+m[1]==2) antiDirA++;
                if(rowA[m[0]]==3 || colA[m[1]]==3 || diagA==3 || antiDirA==3) return "A";
            }else{
            //B term
                rowB[m[0]]++;
                colB[m[1]]++;
                if(m[0]+m[1]==2) antiDirB += 1;
                if(m[0]==m[1]) diagB++;
                if(rowB[m[0]]==3 || colB[m[1]]==3 || diagB==3 || antiDirB==3) return "B";
            }
        }
         if(moves.length < 9) return "Pending";
        return "Draw";
    }
     */
}
