package Greedy.Medium;

/**
 * Created by Shuhua Song
 */
public class _1663_SmallestStringWithAGivenNumericValue {
    //Greedy
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        for(int i=0; i<n; i++){
            res[i] = 'a';
        }
        k = k-n; //substract the number for all 'a' have put in
        for(int j=n-1; j>=0; j--){
            if(k>=25){ //1. the k's value is greater then 25, put 'z'
                res[j] = 'z';
                k -= 25;
            }else if(k>0){ //2. the k's value is 0<=k<=25, put all k at this position
                res[j] = (char)(k+'a');
                k = 0;
            }else{
                break;
            }
        }
        return new String(res);
    }
}
