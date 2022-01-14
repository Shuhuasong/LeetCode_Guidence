package Greedy.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _452_MinimumNumberOfArrowsToBurstBalloons {
    //Time = O(n*logn), Space = O(logN)
    //Arrays.sort() is implemented as a variant of quickSort algorithm whose
    //space complexity is O(logn)
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n==0) return 0;
        //We can't simply use the a[1]-b[1] trick.
        // As this will cause an integer overflow for every large or smalle value
        Arrays.sort(points, (a, b)->Integer.compare(a[1], b[1]));
        int firstEnd = points[0][1];
        int arrows = 1;
        for(int i=1; i<n; i++){
            if(firstEnd < points[i][0]){
                arrows++;
                firstEnd = points[i][1];
            }
        }
        return arrows;
    }
}


