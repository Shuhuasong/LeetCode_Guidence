package DynamicProgramming.Hard;

/**
 * Created by Shuhua Song
 */
public class _410_SplitArrayLargestSum {
    //Binary Search
    //Time = O(n*log(total))
    //Space = O(1)
    public int splitArray(int[] nums, int m) {
        if(nums.length==0){
            return 0;
        }
        int maxVal = nums[0];
        int total = 0;
        for(int num : nums){
            maxVal = Math.max(maxVal, num);
            total += num;
        }
        int start = maxVal, end = total;
        while(start + 1 < end){
            int mid = start + (end-start)/2;
            if(count(nums, mid) > m){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(count(nums, start) <= m){
            return start;
        }
        return end;
    }

    private int count(int[] nums, int limit){
        if(nums.length==0) return 0;
        int numM = 1;
        int sum = nums[0];
        for(int i=1; i<nums.length; i++){
            if(sum+nums[i] > limit){
                numM++;
                sum = 0;
            }
            sum += nums[i];
        }
        return numM;
    }

    /*
     //Brute Force
    //Time = O(n^m), split n elements into m parts,
    //Space = O(n)
    int res;
    int m, n;
    public int splitArray(int[] nums, int m) {
        if(nums.length==0){
            return 0;
        }
        res = Integer.MAX_VALUE;
        this.m = m;
        n = nums.length;
        dfs(nums, 0, 0, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int numSubArray, int i, int currSum, int maxSum){
        if(i==n && numSubArray==m){
            res = Math.min(res, maxSum);
            return;
        }
        if(i==n) return;
        if(i>0){
             dfs(nums, numSubArray, i+1, currSum+nums[i], Math.max(maxSum, currSum+nums[i]));
        }
        if(numSubArray < m){
             dfs(nums, numSubArray+1, i+1, nums[i], Math.max(maxSum, nums[i]));
        }
    }
     */

    /*
      //Dp
    //Time = O(n^2*m), the total number of states O(m*n)
    //Space = O(n)
    public int splitArray(int[] nums, int m) {
        if(nums.length==0){
            return 0;
        }
        int n = nums.length;
        //dp[i][j] : the minimum largest subarray sum for splitting nums[0...i] to parts
        int[][] dp = new int[n+1][m+1];
        int[] preSum = new int[n+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<n; i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
        dp[0][0] = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                for(int k=0; k<i; k++){
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], preSum[i]-preSum[k]));
                }
            }
        }
        return dp[n][m];
    }

    /*
Consider the jth subarray. We can split the array from a smaller index k to i to form it. Thus f[i][j] can be derived from max(f[k][j - 1], nums[k + 1] + ... + nums[i]). For all valid index k, f[i][j] should choose the minimum value of the above formula.
*/

}
