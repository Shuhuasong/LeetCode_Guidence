package TwoPointer.Medium;

/**
 * Created by Shuhua Song
 */
public class _1861_RotatingTheBox {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length, cols = box[0].length;
        for(int i=0; i<rows; i++){
            int stone = 0;
            int curr = cols-1, end = cols-1;
            while(curr>=0){
                if(box[i][curr]=='#'){
                    box[i][end] = '#';
                    if(curr!=end) box[i][curr] = '.';
                    end--;
                    curr--;
                }else if(box[i][curr]=='.'){
                    curr--;
                }else{
                    end = curr-1;
                    curr--;
                }
            }
        }

        char[][] grid = new char[cols][rows];
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                grid[c][rows-1-r] = box[r][c];
            }
        }
        return grid;
    }
}

/*
Solution: Two pointer
1) start for last column,
   if the cell is stone, assign this stone to end pos,
   check if curr!=end, if it is, set box[row][curr] = '.', otherwise, continue;

   if the cell is empty, move curr to the left
   if the cell is obstacle, reset the end = curr-1, so that we can use the pos

   */


