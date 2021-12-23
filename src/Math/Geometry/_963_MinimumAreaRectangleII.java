package Math.Geometry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _963_MinimumAreaRectangleII {


    //Time = O(n^3), Space = O(1)
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        if(n < 4) return 0.0;
        double res = Double.MAX_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] p : points){
            if(!map.containsKey(p[0])){
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                //find first two points
                int dx1 = points[j][0]-points[i][0];
                int dy1 = points[j][1]-points[i][1];
                //find the 3rd point
                for(int k=j+1; k<n; k++){
                    int  dx2 = points[k][0]-points[i][0];
                    int  dy2 = points[k][1]-points[i][1];
                    //if the point A B D can't form the right triangle, skip;
                    if(dy1*dy2 + dx1*dx2 != 0) continue;
                    //find the 4th point
                    int x = dx1 + points[k][0];
                    int y = dy1 + points[k][1];
                    if(map.get(x) != null && map.get(x).contains(y)){
                        double area = Math.sqrt(dx1*dx1 + dy1*dy1) * Math.sqrt(dx2*dx2 + dy2*dy2);
                        res = Math.min(res, area);
                    }
                }
            }
        }
        return (res==Double.MAX_VALUE ? 0 : res);
    }

    /*
     //Time = O(n^4), Space = O(1)
    public double minAreaFreeRect(int[][] points) {
         int n = points.length;
         if(n < 4) return 0.0;
         double res = Double.MAX_VALUE;
         Arrays.sort(points, (a, b)->{
             if(a[0]==b[0]){
                 return a[1]-b[1];
             }else{
                 return a[0]-b[0];
             }
         });
         for(int i=0; i<n-3; i++){
             for(int j=i+1; j<n-2; j++){
                 for(int k=j+1; k<n-1; k++){
                     for(int m=k+1; m<n; m++){
                         if(isRectangle(points[i], points[j], points[k], points[m])){
                              double area = getArea(points[i], points[j], points[k], points[m]);
                              res = Math.min(res, area);
                         }

                     }
                 }
             }
         }
        return res==Double.MAX_VALUE ? 0 : res;
    }

    private boolean isRectangle(int[] A, int[] B, int[] C, int[] D){
        double distAB = dist(A, B), distCD = dist(C, D);
        double distAC = dist(A, C), distBD = dist(B, D);
        double distAD = dist(A, D), distBC = dist(B, C);
        return (distAB==distCD) && distAC==distBD && distAD==distBC;
    }

    private double dist(int[] A, int[] B){
        return (B[0]-A[0])*(B[0]-A[0]) + (B[1]-A[1])*(B[1]-A[1]);
    }

    private double getArea(int[] A, int[] B, int[] C, int[] D){
        double width = dist(A, B);
        double height = dist(B, D);
        return Math.sqrt(width*height);
    }
     */
}


/*
 n < 4 ==> return 0.0
|       B(i)
|
|
| A(j)            D(k)
|
|          C(m)
_________________________
A(xj, yj), B(xi, yi), D(xk, yk), C(xm, ym)
AB = CD
AC = BD
AD = BC
area = length * width
xj-xi = dx1
yj-yi = dy1
xk-xi = dx2
yk-yi = dy2
area = sqrt((xj-xi)^2 + (yj-yi)^2) * sqrt((xk-xi)^2 + (yk-yi)^2)
1) pick 3 points
   prove these 3 points could form a right triangle:
    (yj-yi)/(xj-xi) * (yk-yi)/(xk-xj) = -1
    dy1*dy2 + dx1 * dx2 = 0
2) if we have 3 points i, j, k, we need to find 4th point m if it exist
   (xj+xj)/2 = (xi+xm)/2
   xm = (xj+xk)-xi = (xj-xi) + xk = dx1 + xk
   ym = (yj+yk)-yi = (yj-yi) + yk = dy1 + yk
3) check whether a point (xm, ym) exists
   use HashTable
   Map<Integer, Set<Integer>>

*/



