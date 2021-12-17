package Design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _2013_DetectSquares {

    int[][] numPoints = new int[1001][1001];
    List<int[]> list = new ArrayList<>();
    public _2013_DetectSquares() {

    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        numPoints[x][y] += 1;
        list.add(point);
    }

    public int count(int[] point) {
        int x1 = point[0], y1 = point[1], res = 0;
        for(int[] p3 : list){
            int x3 = p3[0], y3 = p3[1];
            if(Math.abs(x1-x3)==0 || Math.abs(x1-x3) != Math.abs(y1-y3)) continue;
            res += numPoints[x1][y3] * numPoints[x3][y1];
        }
        return res;
    }
}
