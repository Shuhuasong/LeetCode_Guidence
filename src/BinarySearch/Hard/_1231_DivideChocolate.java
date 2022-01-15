package BinarySearch.Hard;

/**
 * Created by Shuhua Song
 */
public class _1231_DivideChocolate {
    //Time = O(n*log10^9), Space = O(1)
    public int maximizeSweetness(int[] sweetness, int k) {
        int lo = 1, hi = 0; //hi = ((int)1e9+7)/(k+1);
        int numPeople = k+1;
        for(int sw : sweetness){
            lo = Math.min(lo, sw);
            hi += sw;
        }
        hi = hi/numPeople;
        int res = Integer.MAX_VALUE;
        while(lo < hi){
            //pick a good total sweet to see if we can cut it into k+1 pieces;
            //we assume the mid is the workable value
            int mid = (lo+hi+1)/2;
            //sumSw : the total sweetness for the current person
            int pieces = 0, sumSw = 0;
            for(int sw : sweetness){
                sumSw += sw;
                if(sumSw >= mid){
                    pieces += 1;
                    sumSw = 0;
                }
            }
            //res = Math.min(res, sumSw);
            // System.out.println(lo + " " + hi);
            if(pieces >= numPeople){
                lo = mid;
            }else{
                hi = mid - 1;
            }
        }
        //the maximum possible sweetness we can get
        return hi;
    }
}

/*
why we use mid = (left+right+1)/2 hear instead of mid. (left+right)/2 ?
 Y   Y   Y    Y    Y
       left  right
         V     X
using mid = (left+right+1)/2 means we will set mid = right instead.
Since the new mid is now workable, we will create the new search space according to the rule, that is [left, mid-1] = [left, left]

*/
