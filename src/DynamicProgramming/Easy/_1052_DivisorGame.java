package DynamicProgramming.Easy;

public class _1052_DivisorGame {

    public boolean divisorGame(int N) {
        //Base Case
        if(N==1) return false; //1 is lose
        if(N==2) return true; //2 is win

        boolean[] dp = new boolean[N+1];
        dp[2] = true; //if Alice get 2, Alice will win
        //The loop starts at 2, because we need to loop backwards
        for(int i=2; i<=N; i++){
            //Loop every number below i to find i's divisor
            //for i=2, we must take away 1, and the other person wins
            for(int j=i-1; j>=1; j--){
                if(i%j==0 && !dp[i-j]){
                    //if N-x(and N = i, x = j) is a loss,
                    //you win. In other words, if in one of the next turns the
                    //other person loses, you win
                    dp[i] = true;
                }
            }
        }
        return dp[N];
    }
}
