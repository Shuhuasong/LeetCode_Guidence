package Array.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _54_SpiralMatrix {

    //Time = O(m*n)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        int up = 0,  left = 0;
        int down = rows-1, right = cols-1;
        while(left < right && up < down){
            //traverse: left---> right
            for(int j=left; j<right; j++){ results.add(matrix[up][j]); }
            //traverse: up---> down
            for(int i=up; i<down; i++){ results.add(matrix[i][right]); }
            // left <---- right
            for(int j=right; j>left; j--){ results.add(matrix[down][j]); }
            // down ===> up
            for(int i=down; i>up; i--){ results.add(matrix[i][left]); }
            left++;
            right--;
            up++;
            down--;
        }
        if(left==right){
            for(int i=up; i<=down; i++){
                results.add(matrix[i][left]);
            }
        }else if(up==down){
            for(int j=left; j<=right; j++){
                results.add(matrix[up][j]);
            }
        }
        return results;
    }
}
