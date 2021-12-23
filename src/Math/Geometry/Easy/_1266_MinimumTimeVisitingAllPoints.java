package Math.Geometry.Easy;

/**
 * Created by Shuhua Song
 */
public class _1266_MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0, n = points.length;
        for(int i=0; i<n-1; i++){
            int dx = Math.abs(points[i][0]-points[i+1][0]);
            int dy = Math.abs(points[i][1]-points[i+1][1]);
            res += Math.max(dx, dy);
        }
        return res;
    }
}

/*
Traverse the input array, for each pair of neighboring points, comparing the absolute difference in x and y coordinates, the larger value is the minimum time need to travel between them;
Sum these time.
*/
