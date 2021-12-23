package Math.Geometry;

/**
 * Created by Shuhua Song
 */
public class _223_RectangleArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x1 = Math.max(ax1, bx1);
        int y1 = Math.max(ay1, by1);
        int x2 = Math.min(ax2, bx2);
        int y2 = Math.min(ay2, by2);
        int overlap = 0;
        if(x1 >= x2 || y1 >= y2){
            overlap = 0;
        }else{
            overlap = Math.max(0, (x2-x1)*(y2-y1));
        }
        return (ax2-ax1)*(ay2-ay1) + (bx2-bx1) * (by2-by1) - overlap;
    }
}


/*
idea:
If there is a overlap between two rectangles, then we can get the point(x1, y1) on the bottom left,
x1 and y1 are the max for both points at the bottom left; the point (x2,y2) on the top right are the min for both points at the top right; And x1 < x2 && y1 < y2;
if x1 >= x2 or y1 >= y2, then the rule is broken, then there is not overlap, so overlap = 0;

Follow up: how to compute the result when there are 3 rectangle overlap ?
we will use the same idea,
x1 = Math.max(ax1, Math.max(bx1, cx1));
y1 = Maht.max(ay1, Math.max(by1, cy1));
x2 = Math.min(ax2, Math.min(bx2, cx2));
y2 = Math.min(ay2, Math.min(by2, cy2));
*/

