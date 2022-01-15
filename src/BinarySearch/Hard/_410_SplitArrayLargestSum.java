package BinarySearch.Hard;

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
    */

    /*
      //Top Down : recursion + memorization
    //Time = O(m*n^2), split n elements into m parts,
    //Space = O(m*n)
    int[][] memo;
    int[] preSum;
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        //dp[i][j] : the minimum largest subarray sum for splitting nums[0...i] to j parts
        memo = new int[n][m+1];
        preSum = new int[n+1];
        for(int i=1; i<=n; i++){
            preSum[i] = nums[i-1] + preSum[i-1];
        }
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return dfs(nums, 0, m);
    }
    //min of largest sum of spliting nums[0]~nums[k] into m groups
    private int dfs(int[] nums, int start, int m){
        if(m==1){
            return preSum[nums.length]-preSum[start];
        }
        if(memo[start][m] != -1){
            return memo[start][m];
        }
        int minSum = Integer.MAX_VALUE;
        for(int i=start; i<nums.length-1; i++){
            int currTotal = preSum[i+1]-preSum[start];
            int rightIntervalMax = dfs(nums, i+1, m-1);
            minSum = Math.min(maxSum, Math.max(currTotal, rightIntervalMax));
        }
        memo[start][m] = minSum;
        return minSum;
    }
     */




/*
Consider the jth subarray. We can split the array from a smaller index k to i to form it.
Thus f[i][j] can be derived from max(f[k][j - 1], nums[k + 1] + ... + nums[i]).
For all valid index k, f[i][j] should choose the minimum value of the above formula.

Explaination:
Subproblem : Shorter, fewer groups
dp[m][j] =  answer of sub-problem, splitting nums[0]-nums[j] into m groups
dp[1][j] = sum(0, j), the sum when split one group
dp[i][j] = min { max(dp[i-1][k], sums(k+1, j)) } 0 <= k < j
                      (a)          (b)
 a[0]| a[1]| ...| a[k]| a[k+1] | a[k+2]| ...| a[n-1]
|<---            ---->| |<---                  --->|
max(split(a[0]~a[k], m-1), sum(a[k+1],..., a[n-1] )
try all possible case and find the best case
for example:
          dp([7,2,5,10,8], 2)
          /                  \
        25                   23
 max(dp([7],1)=7            max(dp[7, 2], 1) = 9
 sum([2, 5, 10, 8])) = 25   sum([5, 10, 8)) = 23
        /                           \
       18                           24
 map(dp[7, 2, 5), 1) = 14    max(dp[7,2,5,10], 1) = 24
 sum([10, 8])) = 18          sum([8]) = 8
 */

}
