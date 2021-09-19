package DynamicProgramming;

/**
 * Created by Shuhua Song
 */
public class _115_DistinctSubsequence {

    /*
Solution: DP
dp[i][j] = num of subseq of  S[1:j] == T[1:i]
(1) init : dp[0][*] = 1
(2) transition:
    if t[i] == s[j]:
       dp[i][j] = dp[i-1][j-1] # s[j], t[i] match
                + dp[i][j-1]   # skip s[j]
    else
       dp[i][j] = dp[i][j-1]  # skip s[j]
Ans : dp[n][m], m =s.length, n = t.length
Time complexity : O(n^2)
Space complexity: O(n^2) --> O(n)
*/



    public int numDistinct(String s, String t) {
        int ls = s.length(), lt = t.length();
        int[][] dp = new int[lt+1][ls+1];
        for(int j=0; j<=ls; j++){
            dp[0][j] = 1;
        }

        for(int i=1; i<=lt; i++){
            for(int j=1; j<=ls; j++){
                if(t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[lt][ls];
    }

    /* recursive
     private static int[][] dp;
    public int numDistinct(String s, String t) {
        int ls = s.length(), lt = t.length();
        dp = new int[lt][ls];
        for(int i=0; i<lt; i++){
            Arrays.fill(dp[i], -1);
        }
        return recurse(s, t, 0, 0);
    }

    private int recurse(String s, String t, int i, int j){
        //we have successfully found a substring
        if(j==t.length()) return 1;
        //substring not found
        if(i==s.length()) return 0;
        if(dp[j][i] != -1)  return dp[j][i]; //already calculated and return directly
        int ways = 0;
        //use the inclusion and exclusion principle
        if(s.charAt(i)==t.charAt(j)){
            //we are including the character if found equal
            ways += recurse(s, t, i+1, j+1);
        }
        //checking without including the current character
        ways += recurse(s, t, i+1, j);
        //memoizing the result
        dp[j][i] = ways;
        return ways;
    }
     */
}

/*
Solution: DP
dp[i][j] = num of subseq of  S[1:j] == T[1:i]
(1) init : dp[0][*] = 1
(2) transition:
    if t[i] == s[j]:
       dp[i][j] = dp[i-1][j-1] # s[j], t[i] match
                + dp[i][j-1]   # skip s[j]
    else
       dp[i][j] = dp[i][j-1]  # skip s[j]
Ans : dp[n][m], m =s.length, n = t.length

note: when we get match, we have two choices
(1) one is we move ahead one character in both the strings
(2) we choose to ignore this match and treat it as a mismach
e.g  s = "rabbbit",  t = "rabbit"
Here, when we match the character b at indices i = 2 and j = 2, we can clearly see that the rest of string T i.e. it is present at the end of string S. This is one subsequence. However, if we reject the b at i = 2 and instead move one step forward, we see another b at i = 3 (and at i = 4) which we can use as the match for the corresponding b in string T. For our problem, we need to consider all three of them to get the answer.

Time complexity : O(n^2)
Space complexity: O(n^2) --> O(n)
*/


