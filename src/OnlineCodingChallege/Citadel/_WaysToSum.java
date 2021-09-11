package OnlineCodingChallege.Citadel;

/**
 * Created by Shuhua Song
 */
public class _WaysToSum {

    // total: the value to sum to,
    // k: the maximum of the range of integers to consider whe summing to total


    private static int waysToSum(int total, int k){
        int[] dp = new int[total+1];
        dp[0] = 1;
        for(int key=1; key<=k; key++){
            for(int t=1; t<total+1; t++){
                if(key <= t){
                    dp[t] += dp[t-key];
                }
            }
        }
        return dp[total];
    }
    public static void main(String[] args) {
        int total = 8, k = 2;
        System.out.println(waysToSum(8, 2));
        System.out.println(waysToSum(5, 3));
    }
}
