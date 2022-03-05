package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _799_ChampagneToweer {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] grid = new double[query_row+2][query_row+2];
        grid[0][0] = poured;
        for(int r=0; r<=query_row; r++){
            for(int c=0; c<=r; c++){
                //if grid[r][c] > 1, then it is full and will flow exceed to next row
                //if grid[r][c] <=1, then it just right full, and not flow to next row
                double quantity = (grid[r][c]-1)/2;
                if(quantity > 0){
                    grid[r+1][c] += quantity;
                    grid[r+1][c+1] += quantity;
                    //mark the curr glass as full
                    grid[r][c] = 1;
                }
            }
        }
        return grid[query_row][query_glass];
    }
}
