package OnlineCodingChallege.Amazon;

/**
 * Created by Shuhua Song
 */
public class _1043_PartitionArrayForMaximu {
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        //dp[i] : the maximum sum we can get considering A[0]-A[i-1]
        //Time = P(N*K), Space = O(n)
        int n = arr.length;
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            int curMax = 0, sum = 0;
            for(int j=1; j<=k && i-j>=0; j++){
                curMax = Math.max(curMax, arr[i-j]);
                sum = Math.max(sum, dp[i-j]+curMax*j);
            }
            dp[i] = sum;
        }
        for(int d : dp){
            System.out.print(d + " ");
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums = {1,15,7,9,2,5,10};
        int k = 3;
        int res = maxSumAfterPartitioning(nums, k);
        System.out.println("res = " + res);
    }
}
