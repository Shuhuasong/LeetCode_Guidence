package Graph.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _1192_CriticalConnectionsInANetword {

    List<Integer>[] graph;
    int time = 0;
    List<List<Integer>> results;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new List[n];
        results = new ArrayList<>();
        for(List<Integer> connect : connections){
            int u = connect.get(0), v = connect.get(1);
            if(graph[u]==null){
                graph[u] = new ArrayList<>();
            }
            if(graph[v]==null){
                graph[v] = new ArrayList<>();
            }
            graph[u].add(v);
            graph[v].add(u);
        }
        int[] disc = new int[n];
        int[] parents = new int[n];
        int[] low = new int[n]; // update the value as the lowest discover time when they are in the same circle
        Arrays.fill(disc, -1);
        Arrays.fill(parents, -1);
        Arrays.fill(low, -1);
        for(int i=0; i<n; i++){
            if(disc[i]!=-1) continue;
            dfs(i, disc, parents, low);
        }
        return results;
    }

    private void dfs(int node, int[] disc, int[] parents, int[] low){
        low[node] = disc[node] = time++;
        for(int next : graph[node]){
            if(disc[next]==-1){
                parents[next] = node;
                dfs(next, disc, parents, low);
                low[node] = Math.min(low[node], low[next]);
                //The lowest time visited next is greater than parent(node),
                //so node is only path from node-->next, that is why
                //low time[next] > disc time [node]
                if(low[next] > disc[node]){
                    results.add(Arrays.asList(node, next));
                }
            }else if(parents[node]!=next){
                low[node] = Math.min(low[node], disc[next]);
            }
        }
    }
}


/*
A bridge is an edge of graph whose deletion increase its
number of connected components:

           2
         /    \
  3-----1------0
        0  1  2  3
disc :  0  1  2  3  the time when the node is visisted first time
low  :  0  0  0  3
disc[n] : the earliest time to visit a node
low[n] :  the earliest vertex, V is U's neighbors

Algorithm:
step1 : Iterate all vertex in the graph:
        try to do dfs()
variable: int[] discoverTime
          int[] parents
          int[] lowestVertexInSubtree

 for an unvisited node U:
    low[u] = disc[u] = time
       for  v (neighbors of u)
          if(v is unvisited):
             parent[v] = u;
             dfs(v, disc, low, parent) ==> update
             low[u] = min(low[u], low[v])
             if(low[v] > disc[u])
                 (u,v) is a bridge
          else if  v is not u's parent
              low[u] = min(low[u], disc[v])

------------------------------------------------
                there are other ways
                from u to v
          e.g.
                     1
                   /   \
                  2-----3
parent[2] = 1
parent[3] = 2    when go from 2->3->1,
                1 has visited and 1 is not parent of 3, so update low[3]

 */

