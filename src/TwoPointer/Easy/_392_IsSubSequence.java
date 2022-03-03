package TwoPointer.Easy;

/**
 * Created by Shuhua Song
 */
public class _392_IsSubSequence {

    //Two Pointer : Time = O(min(m, n))
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        int ps = 0, pt = 0;
        while(ps < s.length() && pt < t.length()){
            if(s.charAt(ps)==t.charAt(pt)){
                ps++;
                pt++;
            }else{
                pt++;
            }
        }
        if(ps==s.length()) return true;
        return false;
    }

    /*
        //dp[i][j] : represents the maximal number of deletions that we can
        have between a prefix of source string and a prefix of the target
        string, namely source[0:col] and target[0:row], so that we can delete

    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        if(s.length()==0) return true;
        int sLen = s.length(), tLen = t.length();
        int[][] dp = new int[sLen+1][tLen+1];
        int maxMatch = 0;
        for(int r=1; r<=sLen; r++){
            for(int c=1; c<=tLen; c++){
                if(s.charAt(r-1)==t.charAt(c-1)){
                    dp[r][c] = dp[r-1][c-1] + 1;
                }else{
                    dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                }
                if(dp[r][c]==sLen) return true;
            }
        }
        //match fail
        return false;
    }
     */
}
