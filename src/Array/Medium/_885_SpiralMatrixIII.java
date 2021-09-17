package Array.Medium;

/**
 * Created by Shuhua Song
 */

/*
Algorithm

Examining the lengths of our walk in each direction, we find the following pattern: 1, 1, 2, 2, 3, 3, 4, 4, ... That is,
 we walk 1 unit east, then 1 unit south, then 2 units west, then 2 units north, then 3 units east, etc. Because our walk
  is self-similar, this pattern repeats in the way we expect.
 */
public class _885_SpiralMatrixIII {

    public int[][] spiralMatrixIII(int rows, int cols, int r0, int c0) {
        int len = rows * cols;
        int[][] res = new int[len][2];
        res[0][0] = r0; res[0][1] = c0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 1, step = 0, i = 0;

        while(count < len){
            if(i%2==0) step++;
            int dir = i%4;
            for(int j=0; j<step; j++){
                r0 += dirs[dir][0];
                c0 += dirs[dir][1];
                if(r0 < 0 || r0 >= rows || c0 < 0 || c0 >= cols){
                    continue;
                }
                res[count][0] = r0;
                res[count][1] = c0;
                count++;
            }
            i++;
        }
        return res;
    }
}
