package Greedy.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _743_NetworkDelayTime {

    //dijkstra--Faster
    //Time = O(N + ElogE), at most E edges in queue,
    //Space = O(N+E)
    int res = Integer.MIN_VALUE;
    int[] receiveTime;
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] t : times){
            int u = t[0], v = t[1], w = t[2];
            graph.get(u).add(new int[]{v, w});
        }
        receiveTime = new int[n+1];
        Arrays.fill(receiveTime, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k, 0});
        bfs(graph, n, k);
        for(int i=1; i<=n; i++) res = Math.max(res, receiveTime[i]);
        return res==Integer.MAX_VALUE ? -1 : res;
    }

    private void bfs(Map<Integer, List<int[]>> graph, int n, int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        pq.add(new int[]{start, 0});
        receiveTime[start] = 0;
        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            int currNode = cell[0], time = cell[1];
            if(time > receiveTime[currNode]) continue;
            for(int[] next : graph.get(currNode)){
                int nextNode = next[0];
                int spend = next[1];
                if(receiveTime[nextNode] > time+spend){
                    receiveTime[nextNode] = time+spend;
                    pq.add(new int[]{nextNode, time+spend});
                }
            }
        }
    }


    /*
     int res = Integer.MIN_VALUE;
    int[] receiveTime;
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] t : times){
            int u = t[0], v = t[1], w = t[2];
            graph.get(u).add(new int[]{v, w});
        }
        for(int node : graph.keySet()){
            Collections.sort(graph.get(node), (a, b)->a[1]-b[1]);
        }
        receiveTime = new int[n+1];
        Arrays.fill(receiveTime, Integer.MAX_VALUE);
        dfs(graph, k, 0);
        for(int i=1; i<=n; i++) res = Math.max(res, receiveTime[i]);
        return res==Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(Map<Integer, List<int[]>> graph, int start, int time){
         // If the current time is greater than or equal to the fastest   signal received
        // Then no need to iterate over adjacent nodes
        if(time >= receiveTime[start]) return;
         // Fastest signal time for currNode so far
        receiveTime[start] = time;
        for(int[] next : graph.get(start)){
            int nextNode = next[0];
            int spend = next[1];
            dfs(graph, next[0], time+next[1]);
        }
    }
     */
}


/*
Note:
1) there can be multiple signals received at a particular node and we are only interested in the time that the first
signal reached the node.
2) How to reduce the excution time ?
   Instead of traversing next nodes randomly, we can traverse then in increasing
   order of traval time.
   It will increase the probability of finding the fastest time path first. So that
   have fewer dfs calls.

[[1,2,1],[2,3,2],[1,3,2]]
3
1
Output: 2

[[2,1,1],[2,3,1],[3,4,1]]
4
2
*/
