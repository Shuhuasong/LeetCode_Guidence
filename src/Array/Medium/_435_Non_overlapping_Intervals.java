package Array.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _435_Non_overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[1]-b[1]);
        int remove = 0, end = Integer.MIN_VALUE;
        for(int[] curr : intervals){
            //valid interval, update the value of end
            if(end <= curr[0]) end = curr[1];
            else{
                //overlap
                remove++; //remove the current one, since it is not eligiable
            }
        }
        return remove;
    }
}


/*

                  end = min
  1_____2         end = 2
          2_____3 end = 3
  1_____________3 end = 4
                3____4
*/


