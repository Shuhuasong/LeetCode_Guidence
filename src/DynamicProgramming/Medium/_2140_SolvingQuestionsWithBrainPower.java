package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _2140_SolvingQuestionsWithBrainPower {

    long[] memo;
    int  n;
    public long mostPoints(int[][] questions) {
        n = questions.length;
        memo = new long[n];
        //Arrays.fill(memo, -1);
        return dfs(questions, 0);
    }

    private long dfs(int[][] a, int i){
        if(i >= n){
            return 0;
        }
        if(memo[i] > 0) return memo[i];
        long doQuestion = a[i][0] + dfs(a, i+a[i][1]+1);
        long notDo = dfs(a, i+1);//skip the current one
        memo[i] = Math.max(doQuestion, notDo);
        return memo[i];
    }
/*
    public long mostPoints(int[][] A) {
        int n = A.length;
        //dp[i] : the maximum points that can be get from ith question to nth question
        long[] dp = new long[n];
        dp[n-1] = A[n-1][0];
        for(int i=n-2; i>=0; i--){
            long points = (i+A[i][1]+1) < n ? dp[i+A[i][1]+1] : 0;
            dp[i] = Math.max(dp[i+1], points+A[i][0]);
        }
        return dp[0];
    } */
/*
    long maxPoints = 0;
    public long mostPoints(int[][] a) {
        int n = a.length;
        long[] dp = new long[n+1];
        for(int i = 0;i <= n;i++){
            if(i > 0)dp[i] = Math.max(dp[i], dp[i-1]);
            if(i < n){
                int ni = Math.min(n, i+a[i][1]+1);
                dp[ni] = Math.max(dp[ni], dp[i] + a[i][0]);
            }
        }
        return dp[n];
    } */
}

/*
This is a typical dynamic programming question
At each index i, we have 2 options:
1) take points, and jump to the next brainpower indexs
2) Skip the current index(no point at this index), and move to next idx
*/
