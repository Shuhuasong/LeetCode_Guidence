package DynamicProgramming.Hard;

/**
 * Created by Shuhua Song
 */
public class _2167_MinimumTimeToRemoveAllCarsContainingIllegalGoods {
    public int minimumTime(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        int[] left = new int[n+1]; //the cost from lef to right
        int[] right = new int[n+1]; //the cost from right to left
        for(int i=0; i<n; i++){
            //compare :
            //1) remove all cars containning illegal goods from the
            //            'prefix' of sequence from the ith car without using any type 1 operation;
            if(chs[i]=='1')  left[i+1] = Math.min(i+1, left[i]+2);
            else
                left[i+1] = left[i];
        }
        int minCost = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            //compare :
            //1) remove all cars containning illegal goods from the
            //             'suffix' of sequence from the ith car without using any type 1 operation;
            if(chs[i]=='1') right[i] = Math.min(n-i, right[i+1]+2);
            else
                right[i] = right[i+1];
            //compare the best way to split the operation among these two types
            minCost = Math.min(minCost, left[i]+right[i]);
        }
        return minCost;
    }
}
