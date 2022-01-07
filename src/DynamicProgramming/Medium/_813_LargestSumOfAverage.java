package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _813_LargestSumOfAverage {
    int[] preSum;
    public double largestSumOfAverages(int[] nums, int K) {
        int n = nums.length;
        preSum = new int[n+1];
        for(int i=0; i<n; i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
        double[][] memo = new double[n][K+1];
        return topDown(0, nums, K, memo);
    }

    private double topDown(int idx, int[] nums, int K, double[][] memo){
        if(K<=0 || idx >= nums.length) return 0;
        if(memo[idx][K] != 0) return memo[idx][K];
        if(K==1) return average(idx, nums);
        double sum = 0;
        int maxGroupSize = nums.length-K;
        for(int j=idx; j<=maxGroupSize; j++){
            sum += nums[j];
            double currRes = sum/(j-idx+1) + topDown(j+1, nums, K-1, memo);
            memo[idx][K] = Math.max(memo[idx][K], currRes);
        }
        return memo[idx][K];
    }

    private double average(int idx, int[] nums){
        int n = nums.length;
        double sum = preSum[n]-preSum[idx];
        return sum/(n-idx);
    }


    /*
    //DP-Bottom Up
     int[] preSum;
    public double largestSumOfAverages(int[] nums, int K) {
        int N = nums.length;
        if(K==0 || nums.length==0) return 0;

        preSum = new int[N+1];
        for(int i=0; i<N; i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
        double[][] dp = new double[N][K+1];
        double sum = 0;
        for(int i=0; i<N; i++){
            sum += nums[i];
            dp[i][1] = sum/(i+1);
        }
        for(int k=2; k<=K; k++){
            for(int j=k-1; j<N; j++){//start
                for(int i=0; i<j; i++){
                    dp[j][k] = Math.max(dp[j][k], dp[i][k-1]+average(i+1, j));
                }
            }
        }
        return dp[N-1][K];
    }

     private double average(int start, int end){
        double sum = preSum[end+1]-preSum[start];
        return sum/(end-start+1);
    }
     */
}



/*
Solution-Top Down: Recurstion + memoization
1) K = 0  ==> 0
2) K = 1  ==> avg(i, A), calculate average in A starting from i,
3) memo[i][k] != 0 ==> memo[i][k], if we already found solution for (i,K), we return it from memo
4) for  j = (i....N-K) { memo[i][K] = max(avg(i, A, j), solve(j+1, A, K-1, memo))}
   ==>otherwise, we try to extend i by adding more elements in the current group, recurse on j+1 and K-1.
Note: Upper bound N-K+1
N=5, K=1, max count elements in one group is 5
N=5, K=2, max count elements in one group is 4
N=5, K=3, max count elements in one group is 3
N=5, K=4, max count elements in one group is 2
N=5, K=5, max count elements in one group is 1


Bottom-Up Solution--Dp:
top-down (essentially DFS) is an intuitive approach used to solve DP problems and
it is usually easily understand compare with bottom-up. And it is better to have
top-down solution first(recursion--> rescursion+memoization-->DP);
There are some rule we can use rom top-down to transfer to bottom-up approach.
But there are a few steps we need to begin with.
-- A DP problem can represented as directed acyclic graph (DAG) where vertices represent
states and edges are functions that transfer from one state to another. Our goal is to
define the meaning of dp array, initial state, transfer function.

e.g [X X X X X i][i+1 X X X X j]
dp[i][k-1] + avg(A[i+1:j])
For example:
A = {1, 2, 3} K = 2
Calculate intitail states for K = 1
  a  b       a = the index to start, b = the group number
S(0, 1)-->avg(A[0:0])==>1.0 ==> dp[0][1]
S(1, 1)-->avg(A[0:1])==>1.5 ==> dp[1][1]
S(2, 1)-->avg(A[0:2])==>2.0 ==> dp[1, 1]
dp[i][k-1] + avg(A[i+1:j])
S(1, 2) ==> dp[0][1] + avg(A[1:1]) = 1.0 + 2.0 = 3.0
S(2, 2) ==> i=0, dp[2][2] = max(dp[2][2], dp[0][1]+avg(A[1:2])) = 1.0 + 2.5 = 3.5
        ==> i=1, dp[2][2] = max(dp[2][2], dp[1][1]+avg(A[2:2])) = 1.5 + 3.0 = 4.5

 https://leetcode.com/problems/largest-sum-of-averages/discuss/561245/top-down-and-bottom-up-with-detail-explanation
 */
























