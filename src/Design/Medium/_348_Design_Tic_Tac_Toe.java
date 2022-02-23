package Design.Medium;

/**
 * Created by Shuhua Song
 */
public class _348_Design_Tic_Tac_Toe {
    int n;
    int[] rowsA, rowsB, colsA, colsB;
    int diagA, antiDiagA, diagB, antiDiagB;
    public _348_Design_Tic_Tac_Toe(int n) {
        this.n = n;
        rowsA = new int[n]; colsA = new int[n];
        rowsB = new int[n]; colsB = new int[n];
        diagA = 0; antiDiagA = 0;
        diagB = 0; antiDiagB = 0;
    }

    public int move(int row, int col, int player) {
        if(player==1){
            rowsA[row]++;
            colsA[col]++;
            if(row==col) diagA++;
            if(row+col==n-1) antiDiagA++;
            if(rowsA[row]==n || colsA[col]==n || diagA==n || antiDiagA==n) return player;
        }else{
            rowsB[row]++;
            colsB[col]++;
            if(row==col) diagB++;
            if(row+col==n-1) antiDiagB++;
            if(rowsB[row]==n || colsB[col]==n || diagB==n || antiDiagB==n) return player;
        }
        return 0;
    }

    /*
      int n;
    int[] rows, cols;
    int diagnal, antiDiag;
    public TicTacToe(int n) {
       this.n = n;
        rows = new int[n]; cols = new int[n];
        diagnal = 0; antiDiag = 0;
    }

    public int move(int row, int col, int player) {
         player = player == 1 ? 1 : -1;
         rows[row] += player;
         cols[col] += player;
         if(row==col) diagnal += player;
         if(row+col==n-1) antiDiag += player;
         if(Math.abs(rows[row])==n || Math.abs(cols[col])==n || Math.abs(diagnal)==n || Math.abs(antiDiag)==n){
             return player==1 ? 1 : 2;
         }
        return 0;
    }
     */
}
