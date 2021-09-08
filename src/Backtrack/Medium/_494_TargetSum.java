package Backtrack.Medium;

/**
 * Created by Shuhua Song
 */
public class _494_TargetSum {

    //0-1 knapsack
    //Time = O(s * n), s = the sum of nums array, n = nums.length
    //we only fill the array once
    //Space = O(s *s),
    public int findTargetSumWays(int[] nums, int S) {
        int N = nums.length;
        int sum = 0;
        for(int num: nums) sum += num;
        if(Math.abs(S) > sum) return 0;
        /* Basic concept:
        Assume we have two subsets with sum of each => T & Y, we get two equations
        1. T - Y = S    (assume T > Y)
        2. T + Y = sum of all nums
        => 2T = S + sum    => T = (S + sum)/2
        If we find number of ways to form subsets that sum up to 'T',
        then in turn we will get the number of ways to find the target sum (S).

        Now, we can apply Knapsack 0-1 to find the sum 'T'.
        */
        int T = (sum + S)/2;

        /*
        Some base conditions =>
        1. If total sum < target sum S, then there are no possible ways, return 0
        2. If sum is odd, and target sum (S) is even, then there are no possible ways, return 0.
            => Assume, sum = 9, S = 4, then T = (9 + 4)/2 = 6.
            => Sum of one subset = 6 (T). Sum of other subset would be 9 - 6 = 3 (Y). (using equation 2)
            => Substitute values in equation 1 => T - Y = S => 6 - 3 = 3, which is incorrect, because S = 4.
            => Hence we can't find any number of ways with even S, if sum of numbers is odd.
        3. If sum is even, and target sum (S) is odd, then there are no possible ways, return 0.
            Same explanation as above.
        */

        if (sum < S) return 0;
        if ((sum % 2 != 0) && (S % 2 == 0)) return 0;
        if ((sum % 2 == 0) && (S % 2 != 0)) return 0;

        // Applying Knapsack 0-1.
        int dp[][] = new int[N+1][T+1];
        dp[0][0] = 1;

        for(int i=1; i <= N; i++) {
            for(int j=0; j <= T; j++) {
                // If current number is smaller than the required sum 'j'
                if (nums[i-1] <= j) {
                    // dp[i-1][j] represents number of ways to form sum 'j' up until previous number,
                    // i.e. without including current number nums[i-1]
                    dp[i][j] = dp[i-1][j];

                    // dp[i-1][j - nums[i-1]] represents number of ways to form sum 'j' including current number nums[i-1]
                    // Total ways => sum of both ways.
                    dp[i][j] += dp[i-1][j - nums[i-1]];
                }
                // If current number is bigger than the required sum 'j', carry forward number of ways from previous number.
                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[N][T];
    }

    //BruteForce : Time = O(2^n) , Space = O(n)
    /*
      int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
         dfs(nums, 0, 0, target);
         return res;
    }

    private void dfs(int[] nums, int idx, int total, int target){
        if(idx==nums.length){
            if(total==target){
                 res++;
            }
            return;
        }else{
            dfs(nums, idx+1, nums[idx]+total, target);
            dfs(nums, idx+1, -nums[idx]+total, target);
        }
    }
     */


    /*
    //Recursion with Memorization
     //Time = O(s * n), s = the sum of nums array, n = nums.length
    //we only fill the array once
    //Space = O(s *s),
    int total = 0;
    public int findTargetSumWays(int[] nums, int target) {
         total = 0;
         int n = nums.length;
         for(int a : nums) total += a;
         int[][] memo = new int[n][2*total + 1];
         for(int[] row : memo){
             Arrays.fill(row, Integer.MIN_VALUE);
         }
         return dfs(nums, 0, 0, target, memo);
    }

    private int dfs(int[] nums, int idx, int sum, int target, int[][] memo){
        if(idx==nums.length){
            if(sum==target){
                return 1;
            }else{
                return 0;
            }
        }else{
            if(memo[idx][sum+total] != Integer.MIN_VALUE){
                return memo[idx][sum+total];
            }
            int add = dfs(nums, idx+1, sum+nums[idx], target, memo);
            int substract = dfs(nums, idx+1, sum-nums[idx], target, memo);
            memo[idx][sum+total] = add + substract;
            return memo[idx][sum+total];
        }
    }
     */
}
