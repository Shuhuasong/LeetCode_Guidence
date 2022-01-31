package DivideAndConquer;

/**
 * Created by Shuhua Song
 */
public class _50_Pow_x_n {

    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n < 0) return 1/getPow(x, n);
        return getPow(x, n);
    }

    private double getPow(double x, int n){
        if(n==0) return 1;
        double y = getPow(x, n/2);
        if(n%2==0) return y * y;
        else
            return y * y * x;
    }
}

/*
Divide and conquer

        x^(n/2) * x^(n/2);   n = even
x^n =
        x^(n/2) * x^(n/2) * x ; n = odd
*/
