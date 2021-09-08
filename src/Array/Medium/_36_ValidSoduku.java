package Array.Medium;

import java.util.HashSet;

/**
 * Created by Shuhua Song
 */
public class _36_ValidSoduku {

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxs = new HashSet[9];
        for(int i=0; i<9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxs[i] = new HashSet<>();
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){

                if(board[i][j]=='.') continue;

                char ch = board[i][j];
                if(rows[i].contains(ch)) return false;
                rows[i].add(ch);

                if(cols[j].contains(ch)) return false;
                cols[j].add(ch);

                if(boxs[(i/3)*3+j/3].contains(ch)) return false;
                boxs[(i/3)*3+j/3].add(ch);
            }
        }
        return true;
    }
}
