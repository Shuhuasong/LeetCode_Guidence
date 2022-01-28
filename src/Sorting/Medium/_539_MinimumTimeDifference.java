package Sorting.Medium;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _539_MinimumTimeDifference {
    /*
   1)transfer the time integer(hour*60+minutes) first for each time, then sort the array.
   2)After sort, the min difference will be between two next times in a sorted array, every other
     times will be greater than this
   3) Note there is coner case for compare the first(smallest one) and last(largest time)
      we can use : smallertime + (24*60-greatest time) */
    //Time = O(nlogn), space = O(n)
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int[] times = new int[size];
        int k = 0;
        for(String time : timePoints){
            times[k++] = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3,time.length()));
        }
        Arrays.sort(times);
        int minDiff = Integer.MAX_VALUE;
        for(int i=1; i<size; i++){
            minDiff = Math.min(minDiff, times[i]-times[i-1]);
        }
        // distance from  0~times[0] + distance from 24~times[n-1]
        minDiff = Math.min(minDiff, times[0] + (24*60-times[size-1]));
        return minDiff;
    }
}
