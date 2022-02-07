package DynamicProgramming.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _1986_MinimumNumberOfWorkSessionsToFinishTasks {
    /*
    Note: Usually, we will think to start from a session(worker) to brute force(iterate) all the
          tasks, and if the session time is full, we start a new session(find a new worker);
          However, this will cause TLE, because the dfs search tree is very broad on each level.
          which is not good for Depth first searching.  */

    int res;
    int[] session;
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks); //prune-1: Sort Array
        res = tasks.length;
        session = new int[tasks.length];
        dfs(tasks, tasks.length-1, sessionTime, 0);
        return res;
    }

    private void dfs(int[] tasks, int taskId, int maxTime, int numSession){ //numSession==# workers
        if(numSession > res) return;//prune-1: compare with globle, terminate early when condition fail
        if(taskId < 0){
            res = Math.min(res, numSession);
            return;
        }
        for(int i=0; i<numSession; i++){
            if(session[i]+tasks[taskId] <= maxTime){ //add a task into old session
                session[i] += tasks[taskId];
                dfs(tasks, taskId-1, maxTime, numSession);
                session[i] -= tasks[taskId];
            }
        }
        session[numSession] += tasks[taskId];  // start a new session
        dfs(tasks, taskId-1, maxTime, numSession+1);
        session[numSession] -= tasks[taskId];
    }
}
