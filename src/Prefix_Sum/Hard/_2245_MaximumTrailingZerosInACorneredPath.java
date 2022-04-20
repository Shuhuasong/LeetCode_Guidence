package Prefix_Sum.Hard;

/**
 * Created by Shuhua Song
 */
public class _2245_MaximumTrailingZerosInACorneredPath {
    public int maxTrailingZeros(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        //left[i][j][0] : preSum of number of factor 2 from left
        //left[i][j][1] : preSum of number of factor 5 from left
        int[][][] left = new int[rows][cols][2];
        int[][][] right = new int[rows][cols][2]; // from right
        int[][][] top = new int[rows][cols][2];  //from top
        int[][][] bottom = new int[rows][cols][2]; //from bottom

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int two = numsFactor(grid[i][j], 2);
                int five = numsFactor(grid[i][j], 5);
                left[i][j][0] = (j==0) ? two : two+left[i][j-1][0];
                left[i][j][1] = (j==0) ? five : five+left[i][j-1][1];
                top[i][j][0] = (i==0) ? two : two+top[i-1][j][0];
                top[i][j][1] = (i==0) ? five : five+top[i-1][j][1];
            }
        }

        for(int i=rows-1; i>=0; i--){
            for(int j=cols-1; j>=0; j--){
                int two = numsFactor(grid[i][j], 2);
                int five = numsFactor(grid[i][j], 5);
                right[i][j][0] = (j==cols-1) ? two : two+right[i][j+1][0];
                right[i][j][1] = (j==cols-1) ? five : five+right[i][j+1][1];
                bottom[i][j][0] = (i==rows-1) ? two : two+bottom[i+1][j][0];
                bottom[i][j][1] = (i==rows-1) ? five : five+bottom[i+1][j][1];
            }
        }

        int res = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int two = numsFactor(grid[i][j], 2);
                int five = numsFactor(grid[i][j], 5);

                int val1 = Math.min(left[i][j][0]+top[i][j][0]-two, left[i][j][1]+top[i][j][1]-five);
                int val2 = Math.min(left[i][j][0]+bottom[i][j][0]-two, left[i][j][1]+bottom[i][j][1]-five);
                int val3 = Math.min(right[i][j][0]+top[i][j][0]-two, right[i][j][1]+top[i][j][1]-five);
                int val4 = Math.min(right[i][j][0]+bottom[i][j][0]-two, right[i][j][1]+bottom[i][j][1]-five);
                //System.out.println(val3 + " " + val4 + " " + val2 + " " + val1);
                res = Math.max(res, Math.max(Math.max(val1, val2), Math.max(val3, val4)));
            }
        }
        return res;
    }

    private int numsFactor(int val, int k){
        int count = 0;
        while(val>0 && val%k==0){
            count++;
            val = val/k;
        }
        return count;
    }
}
