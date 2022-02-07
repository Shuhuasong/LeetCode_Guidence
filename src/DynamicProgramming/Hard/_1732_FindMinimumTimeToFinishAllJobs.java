package DynamicProgramming.Hard;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _1732_FindMinimumTimeToFinishAllJobs {
    //Time = O(k*N!)
    int minTime = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] workers = new int[k]; //calculate the total working time for ith worker
        Arrays.sort(jobs); //prune-1
        dfs(jobs, jobs.length-1, workers);
        return minTime;
    }

    private void dfs(int[] jobs, int idx, int[] workers){
        int maxVal = -1;
        if(idx < 0){
            for(int workTime : workers) maxVal = Math.max(workTime, maxVal);
            minTime = Math.min(minTime, maxVal);
            return;
        }

        if(maxVal >= minTime) return; //prune-3

        for(int i=0; i<workers.length; i++){
            if(i>0 && workers[i]==workers[i-1]) continue; //prune-2
            workers[i] += jobs[idx];
            dfs(jobs, idx-1, workers);
            workers[i] -= jobs[idx];
        }
    }
}

/*
outer loop ==> jobs : because in this way the dfs search tree will have less branches, which is deep and thin

prune-1: Sort the array, and we will start from last jobs, so that we can terminal earlier when found the path is not working
prune-2: If we found the current worker's status is the same with previous one, we need to skip it. Because
         we only need to distribute a job for one of workers who have the same status

prune-3: Distribute the job from largest one, so that we can terminate the path earlier when condition is not satisfy

[1, 2, 4, 7, 8]

22 / k =

*/
