package DynamicProgramming.Medium;

public class _647_PalindromicSubstring {
    //Time = O(n^2) Space = O(n^2)
    public int countSubstrings(String s) {
        if(s.length()==0) return 0;
        int n = s.length(), res = 0;
        //Base case: single letter substring
        boolean[][] dp = new boolean[n][n];
        for(int i=0; i<n; i++){
            dp[i][i] = true;
            res++;
        }
        //Base case: two letter substring
        for(int i=0; i<n-1; i++){
            dp[i][i+1] = (s.charAt(i)==s.charAt(i+1));
            res += (dp[i][i+1] ? 1 : 0);
        }
        //other case: over 3 letter3 substring
        for(int len=3; len<=n; len++){
            for(int i=0, j=i+len-1; j<n; i++, j++){
                dp[i][j] = dp[i+1][j-1] && (s.charAt(i)==s.charAt(j));
                res += (dp[i][j] ? 1 : 0);
            }
        }
        return res;
    }
    /*
    Time = O(n^3) Space = O(1)
     public int countSubstrings(String s) {
       if(s==null || s.length()==0) return 0;
       int n = s.length(), result = 0;
       for(int i=0; i<n; i++){
           for(int j=i; j<n; j++){
               if(isPalindrom(s, i, j)){
                   //System.out.println(s.substring())
                   result++;
               }
           }
       }
        return result;
    }

    private boolean isPalindrom(String s, int i, int j){
        while(i < j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
     */

}
