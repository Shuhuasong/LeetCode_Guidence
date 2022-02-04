package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _361_BombEnemy {
    //Time = O(3*N*M), each cell we visited 3 times; 1-outer loop, 2-rowHits, 3-colsHit
    //Space = O(M)
    //Save previous accumulate 'E' in the same rows ==> rowHits
    //     previous accumulate 'E' in the same column ==> colsHits[]
    public int maxKilledEnemies(char[][] grid) {
        if(grid.length==0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int[] colHits = new int[cols];
        int maxCount = 0;
        for(int row=0; row<rows; row++){
            int rowHits = 0;
            for(int col=0; col<cols; col++){
                if(grid[row][col]=='E'){
                    rowHits++;
                    colHits[col]++;
                }else if(grid[row][col]=='W'){
                    //when there is a wall, reset the variable
                    rowHits=0;
                    colHits[col] = 0;
                }else if(grid[row][col]=='0'){
                    //can place a bomb
                    int total = rowHits + colHits[col];
                    //extends to right
                    for(int c=col+1; c<cols && grid[row][c]!='W'; c++){
                        if(grid[row][c]=='E') total++;
                    }
                    for(int r=row+1; r<rows && grid[r][col]!='W'; r++){
                        if(grid[r][col]=='E') total++;
                    }
                    maxCount = Math.max(maxCount, total);
                }
            }
        }
        return maxCount;
    }
}
