package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _5_LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s.length()==0) return "";
        int n = s.length();
        int left = 0, right = 0;
        boolean[][] isPalin = new boolean[n][n];
        for(int j=1; j<n; j++){
            for(int i=0; i<j; i++){
                boolean isInnerPa = isPalin[i+1][j-1] || j-i<=2;
                if(s.charAt(i)==s.charAt(j) && isInnerPa){
                    isPalin[i][j] = true;
                    if(j-i > right-left){
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right+1);
    }
}


