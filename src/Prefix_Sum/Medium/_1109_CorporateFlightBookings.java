package Prefix_Sum.Medium;

/**
 * Created by Shuhua Song
 */
public class _1109_CorporateFlightBookings {
    //PreSum: Time = O(n), Space = O(n)
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int[] preSum = new int[n+1];
        for(int[] b : bookings){
            preSum[b[0]] += b[2];
            if(b[1]+1 <= n)
                preSum[b[1]+1] -= b[2];
        }
        for(int i=1; i<=n; i++){
            preSum[i] = preSum[i-1] + preSum[i];
            ans[i-1] = preSum[i];
        }
        return ans;
    }
}

/*
Solution:
1) create a preSum array, then iterate each booking
2) mark on the preSum : first point ==> add number seats
                        last point ===> substract number seats
3)  n = 5
        1    2   3    4    5
preSum  10      -10
             20       -10
             25
       [10,  55,  45,  25, 25]
*/
