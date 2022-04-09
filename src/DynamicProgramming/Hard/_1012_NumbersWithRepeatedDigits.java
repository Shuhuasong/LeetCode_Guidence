package DynamicProgramming.Hard;

/**
 * Created by Shuhua Song
 */
public class _1012_NumbersWithRepeatedDigits {

    /* //TLE
      public int numDupDigitsAtMostN(int n) {
        int count = 0;
        for(int i=1; i<=n; i++){
            if(isRepeat(i)){
                count++;
            }
        }
        return count;
    }

    private boolean isRepeat(int num){
        Set<Integer> set = new HashSet<>();
        while(num!=0){
            int remind = num%10;
            if(set.contains(remind)){
                return true;
            }
            set.add(remind);
            num /= 10;
        }
        return false;
    }
     */

    /*
    int count = 0;
    public int numDupDigitsAtMostN(int n) {
        for(int i=1; i<=9; i++){
            boolean[] digits = new boolean[10];
            digits[i] = true;
            DFS((long)i, n, digits);
        }
        return n-count;
    }

    private void DFS(long curr, int n, boolean[] digits){
        if(curr > n) return;
        count++;
        for(int i=0; i<=9; i++){
            if(!digits[i]){
                digits[i] = true;
                DFS(curr*10+i, n, digits);
                digits[i] = false;
            }
        }
    }
     */
}
