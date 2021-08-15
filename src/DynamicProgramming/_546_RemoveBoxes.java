package DynamicProgramming;

/**
 * Created by Shuhua Song
 */

public class _546_RemoveBoxes {



    int[][][] dp;
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        dp = new int[101][101][101];
        return dfs(boxes, 0, n-1, 0);
    }

    private int dfs(int[] boxes, int l, int r, int k){
        if(l > r) return 0;
        while(l < r && boxes[r-1]==boxes[r]){
            r--;
            k++;
        }
        if(dp[l][r][k] > 0) return dp[l][r][k];
        dp[l][r][k] = dfs(boxes, l, r-1, 0) + (k+1) * (k+1);
        for(int i=l; i<r; i++){
            if(boxes[i]==boxes[r]){
                dp[l][r][k] = Math.max(dp[l][r][k], dfs(boxes, l, i, k+1)+dfs(boxes, i+1, r-1, 0));
            }
        }
        return dp[l][r][k];
    }

    /*
    int[][][] dp;
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
         dp = new int[n][n][n];
        return dfs(boxes, 0, n-1, 0);
    }

    private int dfs(int[] boxes, int l, int r, int k){
        if(l > r) return 0;
        if(dp[l][r][k] > 0) return dp[l][r][k];
        dp[l][r][k] = dfs(boxes, l, r-1, 0) + (k+1) * (k+1);
        for(int i=l; i<r; i++){
            if(boxes[i]==boxes[r]){
                dp[l][r][k] = Math.max(dp[l][r][k], dfs(boxes, l, i, k+1)+dfs(boxes, i+1, r-1, 0));
            }
        }
        return dp[l][r][k];
    }
     */
}
/*
dp[i][j][k] : max score of subarray b[i]~b[j] if there are k boxes that have the same
              color as b[j] following b[j]
Those k boxes are from box[j+1]~box[n], to simulate boxes with other colors are removed first..
For example:
"ABACA", dp[0][0][2] = dfs("A|AA") = 9, # B, C are removed
base case: 0 , if j > i
Transition:
dp[i][j][k] = dp[i][j-1][0] + (k+1)^2               #case1
            = dp[i][p][k+1] + dp[p+1][j-1][0]       #case2
Case 1: drop box[j], remove k+1 boxes.
Case 2: try all breakpoints p, attach a[j] to a[p], i <= p < j, box[p] == box[j]
Ans: dp[0][n-1][0]

Time Complexity: O(n^4), Space = O(n^3)
*/