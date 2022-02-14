package Array.Medium;

/**
 * Created by Shuhua Song
 */
public class _1888_MinimumNumberOfFlipsToMakeTheBinaryStringAlternating {
    public int minFlips(String s) {
        int n = s.length();
        String newS = s + s;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i<2*n; i++){
            if(i%2==0){
                sb1.append("1"); sb2.append("0");
            }else{
                sb1.append("0"); sb2.append("1");
            }
        }
        String s1 = sb1.toString(), s2 = sb2.toString();
        // System.out.println(s1);
        // System.out.println(s2);
        int diff1 = 0, diff2 = 0;
        int res = Integer.MAX_VALUE;
        int l = 0;
        for(int r=0; r<2*n; r++){
            if(newS.charAt(r) != s1.charAt(r)) diff1++;
            if(newS.charAt(r) != s2.charAt(r)) diff2++;
            if(r-l+1 > n){
                if(newS.charAt(l) != s1.charAt(l)) diff1--;
                if(newS.charAt(l) != s2.charAt(l)) diff2--;
                l++;
            }
            if(r-l+1 == n){
                res = Math.min(res, diff1);
                res = Math.min(res, diff2);
            }
        }
        return res;
    }
}
