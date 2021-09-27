package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _1043_PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        //dp[i] : the maximum sum we can get considering A[0]-A[i-1]
        //Time = P(N*K), Space = O(n)
        int n = arr.length;
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            int currMax = Integer.MIN_VALUE, sum = 0;
            for(int j=1; j<=k && i-j>=0; j++){
                currMax = Math.max(currMax, arr[i-j]);
                dp[i] = Math.max(dp[i], dp[i-j]+currMax*j);
            }
        }
        return dp[n];
    }

    /*
    DFS + memorization
     //DFS + memorization
    int[] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        //dp[i] : the maximum sum we can get considering A[0]-A[i-1]
        //Time = P(N*K), Space = O(n)
       memo = new int[arr.length+1];
       return dfs(arr, 0, k);
    }

    private int dfs(int[] arr, int start, int k){
        if(start==arr.length) return 0;
        if(memo[start] != 0) return memo[start];
        int maxSum = 0, maxVal = 0;
        for(int i=start, j=1; i<arr.length && j<=k; i++, j++){
            maxVal = Math.max(maxVal, arr[i]);
            maxSum = Math.max(maxSum, maxVal * j + dfs(arr, i+1, k));
        }
        return memo[start] = maxSum;
    }
     */
}

/*
1 <= k <= n <= 500 ==> O(n^2) or O(n*k)
Greedy--> No, Dp-->Yes
A = {10, 15, 7, 6}, K = 3
Greedy: {15, 15, 15, 6}
optimal:{10, 15, 15, 15}
Analyze:
1 .... i-k, i-k+1, ..., i-1, i
dp[i-1] + A[i] * 1
dp[i-1] + max(A[i-1~i]) * 2
dp[i-k] + max(A[i-k+1~i]) * k    (k element)

dp[i] = max sum of (A[1]~A[i])
Init: dp[0] = 0
Transition:
dp[i] = max{dp[i-k] + k * max(A[i-k+1~i])}, 1 <= k < min(i, K)
Ans: dp[n]
Time complexity: O(n*k)
Space Complexity: O(n)

e.g
A = {2, 1, 4, 3}, K = 3
dp[0] = 0
dp[1] = max(dp[0] + 2 * 1) #2
dp[2] = max(dp[0] + 2 * 2,  #4
            dp[1] + 1 * 1) #3
dp[3] = max(dp[0] + 4 * 3, #12
            dp[1] + 4 * 2, #10
            dp[2] + 4 * 1) #8
dp[4] = max(dp[1] + 4 * 3, #14
            dp[2] + 4 * 2, #12
            dp[3] + 3 * 1) #15
best = {4, 4, 4, 3} */

