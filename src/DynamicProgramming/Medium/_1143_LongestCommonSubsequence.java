package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 +1][n2+1];
        int res = 0;
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }

    /*

    //Time Complextiy: O(M*N^2), M = len1, M = len2
    //Space Complexity: O(M*N)
    int[][] memo;
    String text1, text2;
    public int longestCommonSubsequence(String text1, String text2) {
         int n1 = text1.length(), n2 = text2.length();
         memo = new int[n1+1][n2+1];
         this.text1 = text1; this.text2 = text2;
         for(int[] row : memo) Arrays.fill(row, -1);
         return LCS(0, 0);
    }

    private int LCS(int p1, int p2){
        if(p1==text1.length() || p2==text2.length()) return 0;
        if(memo[p1][p2] != -1) return memo[p1][p2];
        int option = 0;
        if(text1.charAt(p1)==text2.charAt(p2)){
            option = 1 + LCS(p1+1, p2+1);
        }else{
            option = Math.max(LCS(p1+1, p2), LCS(p1, p2+1));
        }
        memo[p1][p2] = option;
        return memo[p1][p2];
    }



     //Time Complextiy: O(M*N^2), M = len1, M = len2
    //Space Complexity: O(M*N)
    int[][] memo;
    String text1, text2;
    public int longestCommonSubsequence(String text1, String text2) {
         int n1 = text1.length(), n2 = text2.length();
         memo = new int[n1+1][n2+1];
         this.text1 = text1; this.text2 = text2;
         for(int[] row : memo) Arrays.fill(row, -1);
         return LCS(0, 0);
    }

    private int LCS(int p1, int p2){
        if(p1==text1.length() || p2==text2.length()) return 0;
        if(memo[p1][p2] != -1) return memo[p1][p2];
        int option1 = LCS(p1+1, p2);
        int option2 = 0;
        int idx = text2.indexOf(text1.charAt(p1), p2);
        if(idx != -1){
            option2 = 1 + LCS(p1+1, idx+1);
        }
        memo[p1][p2] = Math.max(option1, option2);
        return memo[p1][p2];
    }
     */
}
