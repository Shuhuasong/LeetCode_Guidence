package Sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Shuhua Song
 */
public class _1288_RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] A) {
        Arrays.sort(A, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0]==b[0] ? b[1]-a[1] : a[0]-b[0];
            }
        });
        int prevEnd = 0, res = 0;
        for(int[] curr : A){
            if(curr[1] > prevEnd){ //currEnd = curr[1]
                res++;
                prevEnd = curr[1];
            }
        }
        return res;
    }
}

/*
Note:
1) how to sort the input data, Time = O(nlogn)
   sort the start point, it ensure start1 < start2, then it is sufficient to compare the end boundaries
   --if end1 < end2, the intervals won't completely cover one another, thought they have some overlapping
   --if end1 >= end2, the interval2 is covered by the interval 1
   --Edge case:
     if two intervals share the same start point, one has to put the longer interval in front
     when start1==start2, then return b[1]-a[1]
   when start are the same, sort
2) traverse the input in O(n) time
*/
