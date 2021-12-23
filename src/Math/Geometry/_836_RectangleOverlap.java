package Math.Geometry;

/**
 * Created by Shuhua Song
 */
public class _836_RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = Math.max(rec1[0], rec2[0]);
        int y1 = Math.max(rec1[1], rec2[1]);
        int x2 = Math.min(rec1[2], rec2[2]);
        int y2 = Math.min(rec1[3], rec2[3]);
        if(x1 < x2 && y1 < y2) return true;
        return false;
    }
}

/*
idea:
If there is a overlap between two rectangles, then we can get the point(x1, y1) on the bottom left,
x1 and y1 are the max for both points at the bottom left; the point (x2,y2) on the top right are the min for both points at the top right; And must satisfy condition : x1 < x2 && y1 < y2;
if x1 >= x2 or y1 >= y2, then the rule is broken, then there is not overlap, so overlap = 0;

Follow up: how to compute the result when there are 3 rectangle overlap ?
we will use the same idea,
x1 = Math.max(ax1, Math.max(bx1, cx1));
y1 = Maht.max(ay1, Math.max(by1, cy1));
x2 = Math.min(ax2, Math.min(bx2, cx2));
y2 = Math.min(ay2, Math.min(by2, cy2));
*/

