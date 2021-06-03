package Array.Medium;

import java.util.Arrays;

public class _1465_MaximumAreaOfCakeAfterCut {

    public int maxArea(int h, int w, int[] hori, int[] vert){
        // final int MOD = (int)1e9+7;
        Arrays.sort(hori);
        Arrays.sort(vert);
        int m = hori.length, n = vert.length;
        long maxH = 0, maxW = 0, res = 0;
        //Initialize a variable maxHeight as the larger of the top and bottom edge
        maxH = Math.max(hori[0]-0, h-hori[m-1]);
        for(int i=1; i<m; i++){
            System.out.println(hori[i] + " " +hori[i-1]);
            maxH = Math.max(maxH, hori[i]-hori[i-1]);
            //maxH = Math.max(maxH, h - hori[m-1]);
        }
        //Initialize a variable maxWidth as the larger of the left and right edge
        maxW = Math.max(vert[0]-0, w-vert[n-1]);
        for(int j=1; j<n; j++){
            maxW = Math.max(maxW, vert[j]-vert[j-1]);
            // maxW = Math.max(maxW, w - vert[n-1]);
        }
        System.out.println(maxH + " " + maxW);
        return (int)((maxH * maxW)%(1e9+7));
    }
}
