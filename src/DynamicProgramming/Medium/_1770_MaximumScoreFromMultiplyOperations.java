package DynamicProgramming.Medium;

public class _1770_MaximumScoreFromMultiplyOperations {

    int n, m;
    int[] nums, muls;
    Integer[][] memo;
    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length; m = multipliers.length;
        this.nums = nums;
        this.muls = multipliers;
        this.memo = new Integer[m][m];
        return dp(0, 0);
    }
    private int dp(int left, int i){
        if(i==m) return 0;
        if(memo[left][i] != null) return memo[left][i];
        int leftPick = dp(left+1, i+1) + nums[left] * muls[i];
        int rightPick = dp(left, i+1) + nums[n-(i-left)-1] * muls[i];
        return memo[left][i] = Math.max(leftPick, rightPick);
    }
}
