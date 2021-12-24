package Array.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _1706_WhereWillTheBallFall {

    public int[] findBall(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] result = new int[cols];
        Arrays.fill(result,-1);
        for(int j=0; j<cols; j++){
            int r = 0, c = j;
            while(r < rows){
                //drop from top-left side
                if(grid[r][c]==1){
                    //reach rightmost wall
                    if(c==cols-1){
                        break;
                    }else if(grid[r][c+1]==-1){
                        //the right side cell has opposite direction board,
                        //forming 'V' and stuck
                        break;
                    }else{
                        //the right side cell has same direction board, droping to
                        //next level
                        r++;
                        c++;
                    }
                }else{
                    //drop from top-right side
                    if(c==0){
                        break;
                    }else if(grid[r][c-1]==1){
                        break;
                    }else{
                        r++;
                        c--;
                    }
                }
                //the ball was drop to the last row
                if(r==rows){
                    result[j] = c;
                }
            }
        }
        return result;
    }
}

/*
Simulation：
1. when the ball is dropping from top-left, we need to think about
3 cases:
1) the adjacent cell has the same direct of board, then ball goes to next
   level (i+1, j+1)
2) if the adjacent cell has opposite direct of board, then ball will be stuck
3) the ball was stuck by the wall on the rightmost side

2. when the ball is dropping from top-right, we also need to think about
3 cases:
1) the adjacent cell has the same direct of board, then ball goes to next
   level (i+1, j-1)
2) if the adjacent cell has opposite direct of board, then ball will be stuck
3) the ball was stuck by the wall on the leftmost side

*/

