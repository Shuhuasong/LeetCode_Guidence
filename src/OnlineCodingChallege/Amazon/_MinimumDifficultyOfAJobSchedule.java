package OnlineCodingChallege.Amazon;

/**
 * Created by Shuhua Song
 */
/*
we want to schedule a list of jobs in d days. Jobs are dependent (To work on the i-th job,
you have to finish all the jobs j where 0 <= j < i)
you have to finish at least one task every day. the difficulty of a job schedule is the sum of
difficulties of each day of the d days. The difficulty of a day the maximum difficulty of a
job done in that day.
given an array of integer jobDifficulty and an integer d. The difficulty of the i-th job
if jobDifficulty[i]
Return the minimum difficulty of a job schedule. If you cann't find a schedule for the jobs. return -1;

Example1 : jobDifficulty = {6, 5, 4, 3, 2, 1}, d = 2
Output : 7
first day : 6, 5, 4, 3, 2---> 6
second day : 1 -----> 1
 6 + 1 = 7

 Example2: jobDifficulty = {9, 9, 9}, d = 4
 Output: -1
 If you finish a job per day you will still have a free day, you can't find a schedule


 */
public class _MinimumDifficultyOfAJobSchedule {

    private static int minDifficulty(int[] jobs, int d){
        if(jobs.length < d) return -1;
        int[][] dp = new int[jobs.length][d+1];
        int res = dfs(jobs, 0, d, dp);
        return res;
    }
    // n == currDay
    private static int dfs(int[] jobs, int start, int k, int[][] dp){
        if(dp[start][k] > 0) return dp[start][k];
        int maxDiff = -1;
        int ans = Integer.MAX_VALUE;
        if(k==1){
            for(int i=start; i<=jobs.length-k; i++){
                maxDiff = Math.max(maxDiff, jobs[i]);
            }
            dp[start][k] = maxDiff;
            return maxDiff;
        }else{
            for(int i=start; i<=jobs.length-k; i++){
                maxDiff = Math.max(maxDiff, jobs[i]);
                ans = Math.min(ans, maxDiff + dfs(jobs, i+1,k-1, dp));
            }
            dp[start][k] = ans;
            return ans;
        }
    }

    /*
Recursion + Memorizaton
Question: divide the array into k segement and then save the max difficulty
for each segement. Return the minimum sum of max difficulties in the k segments.
If we use brute force to try each position, it will LTE.
Solution:
--when we divide the array one time, the k will minus 1,the start position will be
changed. In the second time, we can user recursion function repeat the process
--when divide the array, the end position is end = jobs.length-k
e.g [1, 2, 3,4 ,5,6], k = 2
for the first time divide, the start should be [0, 4], end = job.length-k
Implemention:
--for the k==1, we just need to return the max in the current rest array
--if k>1, we need to recursively invoke the recursion function to calculate
each position that is divided, and return the minimum one
--
*/

    public static void main(String[] args) {
        int[] jobsDifficulty1 = {6, 5, 4, 3,2, 1};
        int d1 = 2;
        int[] jobsDifficulty2 = {9, 9, 9};
        int d2 = 4;
        int[] jobsDifficulty3 = {7,1,7,1,7,1};
        int d3 = 3;
        System.out.println(minDifficulty(jobsDifficulty1, d1));
        System.out.println(minDifficulty(jobsDifficulty2, d2));
        System.out.println(minDifficulty(jobsDifficulty3, d3));
    }
}
