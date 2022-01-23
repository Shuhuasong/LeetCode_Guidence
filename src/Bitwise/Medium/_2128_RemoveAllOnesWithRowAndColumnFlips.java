package Bitwise.Medium;

/**
 * Created by Shuhua Song
 */
public class _2128_RemoveAllOnesWithRowAndColumnFlips {
    public boolean removeOnes(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if(rows==1) return true; //only one row
        for(int i=1; i<rows; i++){
            boolean same = grid[i-1][0]==grid[i][0];
            for(int j=0; j<cols; j++){
                if((grid[i-1][j] == grid[i][j] != same)){
                    return false;
                }
            }
        }
        return true;
    }
    /*
    public boolean removeOnes(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if(rows==1) return true; //only one row
        for(int i=1; i<rows; i++){
            for(int j=0; j<cols; j++){
                if((grid[0][0]^grid[i][0]) != (grid[i][j]^grid[0][j])){
                    return false;
                }
            }
        }
        return true;
    } */
}

/*

Examples for matrix 4*4:
case-1: flip the col 1
0100
0100
0100
0100
case-2: flip the row 1
0100
1011
0100
0100
case-3: flip row 3
0100
1011
0100
1011
case-4: flip col 3
0110
1001
0110
1001
case-5: flip col 4
0111
1000
0111
1000
from above example, we find the pattern that
each row is either the same with first row or complement
with first row:
grid[i][0]^grid[0][0] = grid[i][j]^grid[0][j] (j>0)
*/

