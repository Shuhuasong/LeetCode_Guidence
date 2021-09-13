package Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _882_ReachableNodesInSubdividedGraph {

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        if(edges==null || n==0) return 0;
        if(n==1) return 1;
        int[][] graph = new int[n][n];
        boolean[] visited = new boolean[n];
        int result = 0;
        for(int i=0; i<n; i++){
            Arrays.fill(graph[i], -1);
        }
        for(int[] e : edges){
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }
        Queue<int[]> q = new PriorityQueue<>((a, b)->b[1]-a[1]);
        q.add(new int[]{0, maxMoves});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int start = curr[0];
            int dist = curr[1];
            if(visited[start]) continue;
            visited[start] = true;
            result++;
            for(int i=0; i<n; i++){
                if(graph[start][i] > -1){ // can't use : > 0
                    if(dist > graph[start][i]){
                        q.add(new int[]{i, dist-graph[start][i]-1});
                    }
                    graph[i][start] -= Math.min(dist, graph[start][i]);
                    result += Math.min(dist, graph[start][i]);
                }
            }
        }
        return result;
    }
}
