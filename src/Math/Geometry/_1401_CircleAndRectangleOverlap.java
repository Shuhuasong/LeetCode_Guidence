package Math.Geometry;

/**
 * Created by Shuhua Song
 */
public class _1401_CircleAndRectangleOverlap {
    //Time = O(1), Space = O(1)
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int x = x_center < x1 ? x1 :  x_center < x2 ? x_center : x2;
        int y = y_center < y1 ? y1 :  y_center < y2 ? y_center : y2;
        int dist = (x-x_center)*(x-x_center) + (y-y_center)*(y-y_center);
        System.out.println(x + " " + y);
        return dist <= radius * radius;
    }
}

/*

Idea: find the point(x, y) in rectangle which is
closest to circle ?
How to find the point ?
rectangle: left-bottome---(x1, y1)
           top - right---(x2, y2)
parenthese==circle

example-1:
     x1    x2
     |       |
( )  |  ( )  |  ( )
     |       |

example-2:

     ( )
_______________ y2
     ( )
_______________ y1
     ( )

*/









