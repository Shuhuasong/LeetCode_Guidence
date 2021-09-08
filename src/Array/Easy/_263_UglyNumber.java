package Array.Easy;

/**
 * Created by Shuhua Song
 */
public class _263_UglyNumber {

    public boolean isUgly(int n) {
        if(n==1) return true;
        while(n > 1){
            if(n%2==0) n /= 2;
            else if(n%3==0) n /= 3;
            else if(n%5==0) n /= 5;
            else{
                return false;
            }
        }
        return n==1;
    }
}
