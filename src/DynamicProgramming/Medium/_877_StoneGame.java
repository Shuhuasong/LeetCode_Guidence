package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _877_StoneGame {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            dp[i][i] = piles[i];
        }
        for(int len=2; len<=n; len++){
            for(int i=0; i<n-len+1; i++){
                int j = i + len - 1;
                dp[i][j] = Math.max(piles[i]-dp[i+1][j], piles[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1] > 0;
    }


    /*
    2--recursion+memorization
     int[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        return score(piles, 0, piles.length-1) > 0;
    }

    int score(int[] piles, int l, int r){
        if(l==r) return piles[l];
        if(dp[l][r] == 0){
            dp[l][r] = Math.max(piles[l]-score(piles, l+1, r),
                        piles[r]-score(piles, l, r-1));
        }
        return dp[l][r];
    }
     */


    /*
    1--Recursion

     public boolean stoneGame(int[] piles) {
        return score(piles, 0, piles.length-1) > 0;
    }

    int score(int[] piles, int l, int r){
        if(l==r) return piles[l];
        return Math.max(piles[l]-score(piles, l+1, r),
                        piles[r]-score(piles, l, r-1));
    }

     */

}


/*
Solution 1: Min-Max(TLE 26/46)
Time = O(2^n) Space = O(n)
Min-Max: Both you and opponent take the best move
# best relative score of subarray s[i]~s[j]
def score(s, l, r):
   if(l > r) return 0
   if(l == r) return s[l]
   return max(s[l]-score(s, l+1, r),
              s[r]-score(s, l, r-1))
   return score(s, 0, n-1) > 0

Solution 2: Min-max + memorization / DP
dp[i][j] = best relative score of subarray s[i]~s[j]
Time = O(n^2)
Space = O(n^2)
*/