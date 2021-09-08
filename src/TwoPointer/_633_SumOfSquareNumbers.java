package TwoPointer;

/**
 * Created by Shuhua Song
 */
public class _633_SumOfSquareNumbers {

    // time = O(sqrt(c) logc), space = O(1)
    public boolean judgeSquareSum(int c) {
        for(long a=0; a*a<=c; a++){
            long rest = c-a*a;
            int sq = (int)Math.sqrt(rest);
            if(sq*sq==(int)rest){
                return true;
            }
        }
        return false;
    }

    /*
     public boolean judgeSquareSum(int c) {
        int a = (int)Math.floor(Math.sqrt(c));
        if(a * a == c) return true;
        else{
            int b = 1;
            while(b <= a){
                if(a*a + b*b == c){
                    return true;
                }else if(a*a + b*b < c){
                    b++;
                }else{
                    a--;
                }
            }
        }
        return false;
    }
     */
}
