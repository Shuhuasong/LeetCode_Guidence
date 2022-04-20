package Pramp.BinarySearch;

/**
 * Created by Shuhua Song
 */
public class _RootOfNumber {


    /*
    static double root(double x, int n) {
    // your code goes here
      if(x==0) return 0;
      if(n==1) return x;
    double left = 0.0, right = x;
    double val = 0.0, diff = 0.0;
    double res = 0.0;
      while(right-left>=0.001){
        double mid = left + (right-left)/2;
        val = Math.pow(mid, n);
        diff = Math.abs(val-x);
        if(diff <= 0.001){
            return mid;
        }
        if(val<x){
            //diff > 0.001 ==> decrease the difference Math.abs(val-x) 5-7 ==> 9-7
            left = mid;
        }else{
            right = mid;
        }
    }
    double val1 = Math.pow(left, n), val2 = Math.pow(right, n);
    double diff1 = Math.abs(val1-x), diff2 = Math.abs(val2-x);
     if(diff1 <= 0.001) return left;
     return right;
   } */
}
