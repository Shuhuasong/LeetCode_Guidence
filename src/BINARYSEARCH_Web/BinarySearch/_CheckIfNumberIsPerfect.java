package BINARYSEARCH_Web.BinarySearch;

/**
 * Created by Shuhua Song
 */

/*
Note & intuition
1) End condition of binary search if numbe does not have an actural root
2) Range of number it is 2^31, so long is considerable
   the square of int(3200000) will be too large, so long
3) Boundary conditions of the algorithm
 */
public class _CheckIfNumberIsPerfect {

    public boolean solve(int n) {
        if(n<=1) return true;
        long lo = 1, hi = n;
        while(lo+1 < hi){
            long mid = lo + (hi-lo)/2;
            long res = mid * mid;
            if(res==n) return true;
            else if(res < n){
                lo = mid;
            }else{
                hi = mid;
            }
        }
        return false;
    }
}
