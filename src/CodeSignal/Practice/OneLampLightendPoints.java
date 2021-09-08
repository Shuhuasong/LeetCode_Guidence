package CodeSignal.Practice;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
/*
Given a lamps array :
  lamps = { {-2, 3}, {2, 3}, {2, 1} }
  the lamps[i][0] is the position of the lamp
  the lamps[i][1] is the radius the lamp can light the area
 output: find the points on the coordinate line that are illuminated by exactly 1 lamp
         {-5, -4, -3, -2, 4, 5}

  |-----|-----|-----|----|----|----|----|----|----|-----|
  -4   -3    -2     -1   0    1    2    3    4

  the first lamp illuminates every thing in range [-2-3, -2+3] = [-5, 1]
  the second lamp illuminates every thing in range [2-3, 2+3] = [-1, 5]
  the third lamp illuminates every thing in range [2-1, 2+1] = [1, 3]
 */
public class OneLampLightendPoints {

    private static int oneLampLightPoint(int[][] lamps){
        if(lamps==null || lamps.length==0) return 0;
        int n = lamps.length;
        for(int i=0; i<lamps.length; i++){
            int a = lamps[i][0], b = lamps[i][1];
            lamps[i][0] = a-b;
            lamps[i][1] = a+b;
        }
        Arrays.sort(lamps, (a, b)->Integer.compare(a[0], b[0]));
        int res = lamps[0][1] - lamps[0][0];
        for(int i=1; i<n; i++){
            if(lamps[i][0] < lamps[i-1][1]){
                int diff = lamps[i][0] - lamps[i-1][1];
                res -= diff;
                res += lamps[i][1] - lamps[i-1][1];
            }else {
                res += lamps[i][1] - lamps[i][0];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] lamps = { {-2, 3}, {2, 3}, {2, 1}};
        System.out.println(oneLampLightPoint(lamps));
    }
}
