package Array.Hard;

/**
 * Created by Shuhua Song
 */
public class _2132_StampingTheGrid {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int rows = grid.length, cols = grid[0].length;
        int[][] up = new int[rows][cols];
        int[][] down = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
        for(int c=0; c<cols; c++){
            up[0][c] = 1 - grid[0][c]; // transfer from 0->1, 1->0
            for(int r=1; r<rows; r++){ // add from up row
                if(grid[r][c]==1) up[r][c] = 0;
                else
                    up[r][c] = up[r-1][c] + 1;
            }

            down[rows-1][c] = 1 - grid[rows-1][c]; // transfer from 0->1, 1->0
            for(int r=rows-2; r>=0; r--){
                if(grid[r][c]==1) down[r][c] = 0;
                else
                    down[r][c] = down[r+1][c] + 1;
            }
        }

        //get the Width and Height row by row
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c]==1 || visited[r][c]) continue;
                int upMin = Integer.MAX_VALUE;
                int downMin = Integer.MAX_VALUE;
                int end = c;
                for(int col=c; col<cols && grid[r][col] != 1; col++){
                    visited[r][col] = true;
                    end = col;
                    upMin = Math.min(up[r][col], upMin);
                    downMin = Math.min(down[r][col], downMin);
                }
                int width= end - c + 1;
                int height = upMin + downMin - 1;
                if(width < stampWidth || height < stampHeight) return false;
            }
        }
        return true;
    }
}


/*
Solution-Prefix Sum Solution
Two Passes:
1st pass: iterate grid, for each grid[i][j]==0, using prefix and suffix sum to record the max height it can
           expand upward and downward.
2nd pass: iterate grid, if grid[i][j] == 0 && !visited[i][j], expand rightward as far as possible, and record the
          minimum up height and minimum down height recorded in step 1.
 the current rectangle's width would be the length of how far moving right : width = end-j+1
                            height would be : (min up height) + (min down height)-1
                            (we calculate the grid itself twice when expanding upward and downward, so need minus 1)
                            Then, check if the width and height of the rectangle can fit a stamp, if not, return false
                            return true if no invalid grid is found
eg.
Grid:
  0  1  2  3
0 1  0  0  0
1 1  0  0  0
2 1  0  0  0
3 1  0  0  0
4 1  0  0  0

Up:
  0  1  2  3
0 0  1  1  1
1 0  2  2  2
2 0  3  3  3
3 0  4  4  4
4 0  5  5  5

Up:
  0  1  2  3
0 0  5  5  5
1 0  4  4  4
2 0  3  3  3
3 0  2  2  2
4 0  1  1  1
*/













