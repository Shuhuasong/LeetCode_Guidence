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

    private static int minDifficulty(int[] jobDifficulty, int d){
        if(d > jobDifficulty.length){
            return -1;
        }
        // dp[i][j] : the min difficulty for first i jobs in first j days.
        int[][] dp = new int[jobDifficulty.length][d+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return minDiff(jobDifficulty, 0, 1, d, dp);
    }

    private static int minDiff(int[] jobs, int start, int n, int d, int[][] dp){
        if(n > d) return 0;
        if(dp[start][n] != -1){
            return dp[start][n];
        }
        if(n==d){
            int currMax = Integer.MIN_VALUE;
            for(int i=start; i<jobs.length; i++){
                currMax = Math.max(currMax, jobs[i]);
            }
            dp[start][n] = currMax;
            return currMax;
        }
        int min = Integer.MAX_VALUE;
        int currMax = Integer.MIN_VALUE;
        for(int i=start; i<jobs.length-(d-n); i++){
            currMax = Math.max(currMax, jobs[i]);
            min = Math.min(min, minDiff(jobs, i+1, n+1, d, dp) + currMax);
        }
        dp[start][n] = min;
        return min;
    }

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
