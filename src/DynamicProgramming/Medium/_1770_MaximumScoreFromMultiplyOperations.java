package DynamicProgramming.Medium;

/*
Note: At first glance, the solution seems to be greedy, but if you try to greedily
take the largest value from the beginning or the end, this will not be optimal.
 */

public class _1770_MaximumScoreFromMultiplyOperations {

    public int maximumScore(int[] nums, int[] multipliers) {
        int  n = nums.length, m = multipliers.length;
        Integer memo[][] = new Integer[m][m];
        return dp(nums, multipliers, 0, 0, n-1, memo);
    }


    private int dp(int[] nums, int[] muls, int curr, int start, int end, Integer[][] memo){
        if(curr==muls.length) return 0;
        if(memo[start][curr] != null) return memo[start][curr];
        int leftPick = nums[start] * muls[curr] + dp(nums, muls, curr+1, start+1, end, memo);
        int rightPick = nums[end] * muls[curr] + dp(nums, muls, curr+1, start, end-1, memo);
        memo[start][curr] = Math.max(leftPick, rightPick);
        return memo[start][curr];
    }
}
