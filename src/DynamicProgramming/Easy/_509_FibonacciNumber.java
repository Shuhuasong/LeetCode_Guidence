package DynamicProgramming.Easy;

public class _509_FibonacciNumber {

    //bottom-up with rolling array  Time = O(n) Space = O(1)
    public int fib(int n) {
        if(n<=1) return n;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i%2] = dp[(i-2)%2] + dp[(i-1)%2];
        }
        return dp[n%2];
    }


/*
    //bottom-up  Time = O(n) Space = O(n)
    public int fib(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        if(n>0){
            dp[1] = 1;
            for(int i=2; i<=n; i++){
                dp[i] = dp[i-2] + dp[i-1];
            }
        }
        return dp[n];
    }
 */

    //bottom-up  Time = O(n) Space = O(n)
 /*   public int fib(int n) {
        if(n<=1) return n;
        return memorize(n);
    }

    private int memorize(int n){
        int memo[] = new int[n+1];
        memo[1] = 1;
        for(int i=2; i<=n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

  */
}
