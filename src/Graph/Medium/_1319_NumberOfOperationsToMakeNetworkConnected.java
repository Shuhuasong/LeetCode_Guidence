package Graph.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _1319_NumberOfOperationsToMakeNetworkConnected {
    List<Integer>[] graph;
    public int makeConnected(int n, int[][] connections) {
        graph = new ArrayList[n];
        int edges = connections.length;
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : connections){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        int numNet = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<n; i++){
            if(visited.contains(i)) continue;
            dfs(i, visited);
            numNet++;
        }
        return edges>=n-1 ? numNet-1 : -1;
    }

    private void dfs(int node, Set<Integer> visited){
        visited.add(node);
        for(int nei : graph[node]){
            if(visited.contains(nei)) continue;
            dfs(nei, visited);
        }
    }
}


/*
# edges > n-1
12
[[1,5],[1,7],[1,2],[1,4],[3,7],[4,7],[3,5],[0,6],[0,1],[0,4],[2,6],[0,3],[0,2]]
*/
