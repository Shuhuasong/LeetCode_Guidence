package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _323_NumberOfConnectedComponentsInAnUndirectedGraph {

    List<Integer>[] graph;
    boolean[] visited ;
    public int countComponents(int n, int[][] edges) {
        graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        visited = new boolean[n];
        int res = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int node){
        if(visited[node]) return;
        visited[node] = true;
        for(int nei : graph[node]){
            if(!visited[nei]){
                dfs(nei);
            }
        }
    }
}
