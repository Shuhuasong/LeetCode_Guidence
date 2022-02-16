package Prefix_Sum.Medium;

/**
 * Created by Shuhua Song
 */
public class _598_RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int minX = m, minY = n;
        for(int[] op : ops){
            minX = Math.min(minX, op[0]);
            minY = Math.min(minY, op[1]);
        }
        System.out.println(minX + " " + minY);
        return minX * minY;
    }
}

/*
intuitive:
whatever how many operation takes, the area
with maximum number is the smallest area update
every time.
So we only get minimum X and Y to get this smallest
area which is updated frequently
*/
