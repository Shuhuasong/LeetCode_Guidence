package Golden_Sach_21FallOA;

import javax.swing.*;

/**
 * Created by Shuhua Song
 */
public class _Efficient_Harvest_ {

    public static int efficientHarvest(int[] profit, int k){
        int n = profit.length;
        int pivot = n/2;
        int[] extendProf = new int[2 * n];
        int[] preSum = new int[2 * n + 2];
        for(int i=0; i<n; i++){
            extendProf[i] = profit[i];
            extendProf[i+n] = profit[i];
            preSum[i+1] = preSum[i] + profit[i];
            preSum[i+n+2] = preSum[i+n+1] + profit[i];
        }
        int idx = 0, currSum = 0, res = 0;
        while(idx <= n){
            currSum = (preSum[idx+k] - preSum[idx]) + (preSum[idx+k+pivot] - preSum[idx+pivot]);
            res = Math.max(currSum, res);
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] profit1 = {1, 5, 1, 3, 7, -3};
        int k1 = 2;
        System.out.println(efficientHarvest(profit1, k1));
    }
}
