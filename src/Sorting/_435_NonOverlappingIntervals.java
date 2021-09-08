package Sorting;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _435_NonOverlappingIntervals {

    //Time = O(nlogn)
    //Use greedy based on the sorted end point
    public int eraseOverlapIntervals(int[][] A) {
        Arrays.sort(A, (a, b)->Integer.compare(a[1], b[1]));
        int prevEnd = Integer.MIN_VALUE, count = 0;
        for(int i=0; i<A.length; i++){
            if(A[i][0] >= prevEnd){
                prevEnd = A[i][1];
                count++;
            }
        }
        return A.length-count;
    }
}
