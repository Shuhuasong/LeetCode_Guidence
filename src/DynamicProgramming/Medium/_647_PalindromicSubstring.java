package DynamicProgramming.Medium;

public class _647_PalindromicSubstring {

    //Time = O(n^2)  space = O(n^2)
    public int countSubstrings(String s) {

        int n = s.length(), result = 0;
        if(n<=0) return 0;
        boolean[][] dp = new boolean[n][n];
        //Base Case : single letter substrings
        for(int i=0; i<n; i++){
            dp[i][i] = true;
            result++;
        }
        //Base case: double letter substrings
        for(int i=0; i<n-1; i++){
            dp[i][i+1] = (s.charAt(i)==s.charAt(i+1));
            result += (dp[i][i+1] ? 1 : 0);
        }

        for(int len=3; len<=n; len++){
            for(int i=0, j=i+len-1; j<n; i++, j++){
                dp[i][j] = dp[i+1][j-1] && (s.charAt(i)==s.charAt(j));
                result += (dp[i][j] ? 1 : 0);
            }
        }
        return result;
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
