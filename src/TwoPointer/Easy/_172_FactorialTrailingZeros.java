package TwoPointer.Easy;

public class _172_FactorialTrailingZeros {

    public int trailingZeroes(int n){
        int result = 0;
        for(int i=5; i<=n; i=i+5){
            int curFactor = i;
            while(curFactor%5==0){
                result++;
                curFactor /=5;
            }
        }
        return result;
    }
}
