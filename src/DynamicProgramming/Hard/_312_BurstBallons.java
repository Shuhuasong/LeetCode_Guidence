package DynamicProgramming.Hard;

/**
 * Created by Shuhua Song
 */
public class _312_BurstBallons {
    //Time = O(n^3) Space = O(n^2)
    //Bottom-Up
    public int maxCoins(int[] nums) {
        int n = nums.length+2;
        int[] newNums = new int[n];
        newNums[0] = 1;
        newNums[n-1] = 1;
        int k=1;
        for(int i=0; i<nums.length && k<n-1; i++){
            newNums[k++] = nums[i];
        }
        //cache result
        int[][] dp = new int[n][n];
        // we can not burst the first one and the last one
        // since they are both fake balloons added by ourselves
        for(int left=n-2; left>=1; left--){
            for(int right=left; right<=n-2; right++){
                // find the last burst one in newNums[left]...newNums[right]
                for(int i=left; i<=right; i++){
                    // newNums[i] is the last burst one
                    int gain = newNums[left-1] * newNums[i] * newNums[right+1];
                    // recursively call left side and right side
                    int remain = dp[left][i-1] + dp[i+1][right];
                    dp[left][right] = Math.max(dp[left][right], gain+remain);
                }
            }
        }
        return dp[1][n-2];
    }

/*
    //Time = O(n^3) Space = O(n^2)
    public int maxCoins(int[] nums) {
        int n = nums.length+2;
        int[] newNums = new int[n];
        newNums[0] = 1;
        newNums[n-1] = 1;
        int k=1;
        for(int i=0; i<nums.length && k<n-1; i++){
            newNums[k++] = nums[i];
        }
        //cache result
        int[][] dp = new int[n][n];
        // we can not burst the first one and the last one
        // since they are both fake balloons added by ourselves
        return getCoins(newNums, dp, 1, n-2);
    }

    private int getCoins(int[] newNums, int[][] dp, int lo, int hi){
        // return maximum if we burst all nums[left]...nums[right], inclusive
        if(lo > hi) return 0;
        if(dp[lo][hi] > 0) return dp[lo][hi];
        // find the last burst one in nums[left]...nums[right]
        int result = 0;
        for(int i=lo; i<=hi; i++){
            // nums[i] is the last burst one
            int gain = newNums[lo-1] * newNums[i] * newNums[hi+1];
            // nums[i] is fixed, recursively call left side and right side
            int remain = getCoins(newNums, dp, lo, i-1) +
                    getCoins(newNums, dp, i+1, hi);
            result = Math.max(result, gain + remain);
        }
        // add to the cache
        dp[lo][hi] = result;
        return result;
    }

 */

}


/*
// return maximum coins obtainable if we burst all balloons in `nums`.
function dp(nums, memo_dict) {
    // check if have we seen this dp_state
    if nums in memo_dict
        return memo_dict[dp_state]

    // base case
    if nums is empty
        return 0

    max_coins = 0
    for i in 1 ... nums.length - 2:
        // burst nums[i]
        gain = nums[i - 1] * nums[i] * nums[i + 1]
        // burst the remaining balloons
        remaining = dp(nums without nums[i])
        max_coins = max(max_coins, gain + remaining)

    save dp_state and the result into memo_dict
    return max_coins
}

function maxCoin(nums) {
    nums = [1] + nums + [1] // add fake balloons
    return dp(nums, empty_memo_dict)
}

e.g

C[i][j] = maxCoins(nums[i] ~ nums[j])
ans = C[1][n]
C[i][j] = max{C[i][k-1] + nums[i-1]*nums[k]*nums[j+1] + C[k+1][j] } , i<= k <= j

i-1| i | i+1| ... | k-1| k | k+1 | ... | j-1 | j | j+1
   |___________________|   |_____________________|
        C[i][k-1]             C[k+1][j]



Handle the special cases (all numbers are the same) if you want.

Add one balloon at the start of nums and one at the end to handle edge cases.

Define an array dp, where dp[left][right] represents the maximum coins obtainable, if we burst all balloons on the interval [left, right], inclusively.

Iterate over the dp array such that dp[left][i - 1] and dp[i + 1][right] are visited before dp[left][right] is visited. For dp[left][right]:

We iterate over every index i in the range [left, right], and mark it as the last burst balloon.

First, we burst all balloons except the ith balloon. What we gain is:

dp[left][i - 1] + dp[i + 1][right]
Then, we burst the ith balloon and gain:

nums[left - 1] * nums[i] * nums[right + 1]
Let dp[left][right] be the maximum sum of these two values among all possible is.

Finally, return dp[1][len(nums) - 2].

Note: Do not return dp[0][len(nums) - 1] because the first and the last balloons were added by us and we cannot be popped.
*/