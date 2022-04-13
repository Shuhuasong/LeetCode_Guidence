package Array.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _1260_Shift2DGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        List<List<Integer>> results = new ArrayList<>();
        for(int i=0; i<rows; i++){
            List<Integer> rowList = new ArrayList<>();
            for(int j=0; j<cols; j++){
                rowList.add(0);
            }
            results.add(rowList);
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int newCol = (j+k)%cols;
                int row_incre = (j+k)/cols;
                int newRow = (i+row_incre)%rows;
                results.get(newRow).set(newCol, grid[i][j]);
            }
        }
        return results;
    }

    /*
     public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        List<List<Integer>> results = new ArrayList<>();
        for(int i=0; i<rows; i++){
            List<Integer> rowList = new ArrayList<>();
            for(int j=0; j<cols; j++){
                rowList.add(0);
            }
            results.add(rowList);
        }
        k = k%(rows*cols);
        int r = k/cols, c = k%cols;
        if(r>=rows) r=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                results.get(r).set(c, grid[i][j]);
                c++;
                if(c==cols && r<rows){
                   r++;
                   c=0;
                }
                if(r==rows) r = 0;
            }
        }
        return results;
    }
     */
}

/*
Use formula to calculate the newRow, newCol

newCol = (j+k)%cols
row_increment = (j+k)/cols;
newRow = (i+row_increment) % rows

case1:
[[1,2,3],[4,5,6],[7,8,9]]
9

case2:
[[1],[2],[3],[4],[7],[6],[5]]
23

*/
