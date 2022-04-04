package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _2222_NumberOfWaysToSelectBuildings {
    public long numberOfWays(String s) {
        long one = 0, zeroOne = 0;
        long count = 0;
        int n = s.length();
        //"101"
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)=='1'){
                one++;
                count += zeroOne;
            }else{ //c = '0'
                zeroOne += one;
            }
        }

        //"010"
        long zero = 0, oneZero = 0;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i)=='0'){
                zero++;
                count += oneZero;
            }else{
                oneZero += zero;
            }
        }

        return count;
    }
}
