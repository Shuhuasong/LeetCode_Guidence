package Array.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _1288_RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        //start ==== Increasing
        // end  ==== Decreasing
        Arrays.sort(intervals, (a, b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else{
                return b[1]-a[1];
            }
        });
        int remain = 0, prev_end = 0;
        for(int[] curr : intervals){
            if(prev_end < curr[1]){
                remain++;
                prev_end = curr[1];
            }
            //if prev_end >= curr[1], curr is convered by previous block
        }
        return remain;
    }
}

/*
======
       ==================prev
          -----------   next

   */
