package DynamicProgramming;

public class _5_LongestPalindromicSubstring {
    //Time = O(n^2)  Space  = O(n^2)
     public String longestPalindrome(String s) {
        if(s==null || s.length()<2){
            return s;
        }
        int n = s.length();
        int left = 0, right = 0;
        boolean[][] isPalind = new boolean[n][n];
        for(int j=0; j < n; j++){
            for(int i=0; i<=j; i++){
                boolean outside = s.charAt(i)==s.charAt(j);
                isPalind[i][j] = j-i > 2 ? isPalind[i+1][j-1] && outside : outside;
                if(isPalind[i][j] && j-i > right-left){
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right+1);
    }
}
