package DynamicProgramming.Hard;

/**
 * Created by Shuhua Song
 *
 * Given a string s and an integer k, return true if s is a k-palindrome.
 * A String s k-palindrome if it can be transformed into a palindrome by
 * removing at most k character from it.
 *
 * Example-1:
 *  s = "abcdeca", k = 2
 *  output: true
 *  explanation: Remove 'b', and 'e' characters
 *
 *  Example-2:
 *  s = "abbababa", k = 1
 *  output: true
 *  explanation: remove 'b' at index 1 or 2
 */
public class _1216_ValidPalindrom_III {

    public boolean isValidPalindrome(String s, int k){
        int n = s.length();
        int[] dp = new int[n];
        int left_bottom = 0, curr = 0;
        for(int i=n-2; i>=0; i--){
            left_bottom = 0;
            for(int j=i+1; j<n; j++){
                curr = dp[j];
                if(s.charAt(i)==s.charAt(j)){
                    dp[j] = left_bottom;
                }else{
                    dp[j] = 1 + Math.min(dp[j], dp[j-1]);
                }
                left_bottom = curr;
            }
        }
        return dp[n-1] <= k;
    }


    /*
     int[][] memo;
     public booelan isValidPalindrome(String s, int k){
         int n = s.length();
         memo = new int[n][n];
         for(int[] row : memo) Arrays.fill(row, -1);
         return dfs(s, 0, n-1) <= k;
     }

     private int dfs(String s, int start, int end){
         if(start==end) return 0;
         if(start >= end) return 0;
         if(memo[start][end] != -1) return memo[start][end];
         if(s.charAt(start)==s.charAt(end)){
             return memo[i][j] = dfs(s, i+1, j-1);
         }
         //s[i] != s[j]
         int delete_left = dfs(s, i+1, j);
         int delete_right =dfs(s, i, j-1);
         return memo[i][j] = 1 + Math.min(delete_left, delete_right);
     }

     */

}

/*
Solution-1:  memo + dfs(i, j)

base case:
   1) i==j, return 0
   2) i+1 == j, ab or aa, return s[i] != s[j]
    or (i >= j) return 0;
at least 3 char
if s[i] == s[j] ==> delete_both_end
else  1 + min(delete_left, delete_right)

Solution-2: DP
init
i = [0, n]
dp[i][i] = 0, dp[i-1][i] = 0;

transition funtion:
if(s[i] == s[j])
    dp[i][j] = dp[i+1][j-1]
else
    dp[i][j] = 1 + min(dp[i+1][j], dp[i][j-1])

return  dp[0][n-1] <= k

// i [n-2 -> 0]
//   j [i+1, n)

// 0 S ? A
// D 0 S ?
// X D 0 S
// X X D 0

// 0 ? ? A
// 0 0 ? ?
// X 0 0 ?
// X X 0 0

 */
