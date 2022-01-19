package Math.Medium;

/**
 * Created by Shuhua Song
 */
public class _1492_TheKthFactorOfn {
    //Time = O(n)
    public int kthFactor(int n, int k) {
        if(n < k) return -1;
        int i = 1;
        while(true){
            if(n % i == 0){
                k--;
                if(k==0){
                    return i;
                }else if(i==n){
                    return -1;
                }
            }
            i++;
        }
    }
}
