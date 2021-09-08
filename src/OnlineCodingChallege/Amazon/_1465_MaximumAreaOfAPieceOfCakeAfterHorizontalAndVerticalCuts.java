package OnlineCodingChallege.Amazon;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
/*
You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly,
and
verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the
 arrays horizontalCuts and verticalCuts. Since the answer can be a large number, return this modulo 109 + 7.
 */
public class _1465_MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    public static int maxArea(int h, int w, int[] hori, int[] vert){
         int MOD = (int)1e9+7;
         Arrays.sort(hori);
         Arrays.sort(vert);
         int hLen = hori.length, vLen = vert.length;
         long maxH = 0, maxW = 0;
         maxH = Math.max(hori[0]-0, h-hori[hLen-1]);
         for(int i=1; i<hLen; i++){
             maxH = Math.max(maxH, hori[i]-hori[i-1]);
         }
         maxW = Math.max(vert[0]-0, w-vert[vLen-1]);
         for(int j=1; j<vLen; j++){
             maxW = Math.max(maxW, vert[j]-vert[j-1]);
         }
         return (int)((maxH * maxW)%MOD);
    }
    public static void main(String[] args) {
        int h1 = 5, w1 = 4;
        int[] hori1 = {1, 2, 4}, vert1 = {1, 3};
        int[] hori2 = {3, 1}, vert2 = {1};
        int[] hori3 = {3}, vert3 = {3};
        System.out.println(maxArea(h1, w1, hori1, vert1));
        System.out.println(maxArea(h1, w1, hori2, vert2));
        System.out.println(maxArea(h1, w1, hori3, vert3));
    }
}
