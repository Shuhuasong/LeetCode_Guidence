package Array.Medium;

/*
idea:  GCD find the largest common divisor of the counts of the elements
in the input space;

Again, say if there are Ci cards of number i. These must be broken down into X piles of cards each,
ie. Ci % X == 0 for all i.

Thus, X must divide the greatest common divisor of Ci. If this greatest common divisor g is greater
than 1, then X = g will satisfy. Otherwise, it won't.

 Time = O(N (logN)^2), N = the number of votes, O((logN)^2) = each operation of gcd
 Space = O(N)
 */

public class _914_XofAkindInAdeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for(int d : deck){
            count[d]++;
        }
        int g = -1;
        for(int i=0; i<10000; i++){
            if(g==-1){
                g = count[i];
            }else{
                g = gcd(g, count[i]);
            }
        }
        return g>=2;
    }

    private int gcd(int x, int y){
        if(x!=0){
            return gcd(y%x, x);
        }else{
            return y;
        }
    }
}
