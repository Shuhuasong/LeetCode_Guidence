package DFS_and_BFS.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _1376_TimeNeededToInformAllEmployees {
    //Top-down
    //Time = O(n) , Space = O(N)
    Map<Integer, List<Integer>> graph;
    int res = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        graph = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!graph.containsKey(manager[i])){
                graph.put(manager[i], new ArrayList<>());
            }
            graph.get(manager[i]).add(i);
        }
        // boolean[] visited = new boolean[n];
        return dfs(headID, informTime);
    }

    private int dfs(int id, int[] time){
        int maxTime = 0;
        if(!graph.containsKey(id)){
            return maxTime;
        }
        for(int i=0; i<graph.get(id).size(); i++){
            maxTime = Math.max(maxTime, dfs(graph.get(id).get(i), time));
        }
        return (maxTime +time[id]);
    }

    /*
     //bottom-up
   //Time = O(n) , Space = O(N)
    Map<Integer, List<Integer>> graph;
    int res = 0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for(int i=0; i<n; i++){
            res = Math.max(res, dfs(i, manager, informTime));
        }
        return res;
    }

    private int dfs(int i, int[] manager, int[] informTime){
        if(manager[i] != -1){
            informTime[i] += dfs(manager[i], manager, informTime);
            manager[i] = -1;
        }
        return informTime[i];
    }
     */


    //BFS
    //Time = O(n) , Space = O(n)
/*    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++){
            int k = manager[i];
            if(!graph.containsKey(k)){
                graph.put(k, new ArrayList<>());
            }
            graph.get(k).add(i);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{headID, 0});
        int res = 0;
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int id = cell[0], time = cell[1];
            res = Math.max(res, time);
            if(graph.get(id)==null) continue;
            for(int childId : graph.get(id)){
                q.add(new int[]{childId, time+informTime[id]});
            }
        }
        return res;
    }  */
}


/*
To find the time needed for each employees,
The time for a manager = max(manager's employee) + informTime[manager]
Time = O(n) , Space = O(N)
*/