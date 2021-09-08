package OnlineCodingChallege.Cisco;

/**
 * Created by Shuhua Song
 */
public class _EqualLevel {

    private static  int numOfUpdateTime(int[] signalOne, int[] signalTwo){
        if(signalOne.length==0 || signalTwo.length==0) return 0;
        int m = signalOne.length, n = signalTwo.length;
        int i = 0, maxVal = Integer.MIN_VALUE;
        int update  = 0;
        while(i<m && i<n){
            if(signalOne[i]==signalTwo[i]){
                if(signalOne[i] > maxVal){
                    maxVal = signalOne[i];
                    update++;
                }
            }
            i++;
        }
        return update;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 3, 3, 5, 4};
        int[] num2 = {1, 2, 3, 4, 3, 5, 4};
        System.out.println(numOfUpdateTime(num1, num2));
    }
}
