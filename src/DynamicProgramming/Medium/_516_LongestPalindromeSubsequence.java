package DynamicProgramming.Medium;

import java.util.Arrays;

public class _516_LongestPalindromeSubsequence {
    //DP : Bottom Up
    //Time = O(2^n), Space = O(n^2)
    //dp[i][j] : the max length from index i to j
    public int longestPalindromeSubseq(String s) {
        if(s.length()==0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        //Bottom Up
        for(int start=n-1; start>=0; start--){
            for(int end=0; end<n; end++){
                if(start > end) continue;
                if(start==end){
                    dp[start][end] = 1;
                    continue;
                }
                if(s.charAt(start)==s.charAt(end)){
                    dp[start][end] = 2 + dp[start+1][end-1];
                }else{
                    dp[start][end] = Math.max(dp[start][end-1], dp[start+1][end]);
                }
            }
        }
        return dp[0][n-1];
    }
    /*
     //Recursive: Time = O(2^n)  TLE
    public int longestPalindromeSubseq(String s) {
        if(s.length()==0) return 0;
        return lpsRec(s, 0, s.length()-1);
    }

    public int lpsRec(String s, int start, int end){
        if(start > end) return 0;
        if(start == end) return 1;
        //Case 1: element at start and end are the same
        if(s.charAt(start)==s.charAt(end)){
            return 2+lpsRec(s, start+1, end-1);
        }
        //Case 1: skip one element either start or end
        int l1 = lpsRec(s, start+1, end);
        int l2 = lpsRec(s, start, end-1);
        return Math.max(l1, l2);
    }
    */


    //Recursive + memoization
    //Time = O(2^n), Space = O(n^2)
 /*   public int longestPalindromeSubseq(String s) {
        if(s.length()==0) return 0;
        int n = s.length();
        int[][] memo = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(memo[i], -1);
        }
        return lpsRec(s, 0, s.length()-1, memo);
    }

    public int lpsRec(String s, int start, int end, int[][] memo){
        if(start > end) return 0;
        if(start == end) return 1;
        if(memo[start][end] != -1) return memo[start][end];
        if(s.charAt(start)==s.charAt(end)){
            return memo[start][end] = 2+lpsRec(s, start+1, end-1, memo);
        }
        int l1 = lpsRec(s, start+1, end, memo);
        int l2 = lpsRec(s, start, end-1, memo);
        return memo[start][end] = Math.max(l1, l2);
    }

  */
}
