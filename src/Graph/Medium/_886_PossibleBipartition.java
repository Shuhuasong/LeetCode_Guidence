package Graph.Medium;

import java.util.ArrayList;
import java.util.List;

public class _886_PossibleBipartition {

    //Time = O(V + E) Space = O(V + E);
    /*
    Solution: Graph Coloring  DFS/BFS
    Color a node as red, and all its neighbors as blue recursively. If there
    is any conflicts then the graph is not bipartite
    */
    List<Integer>[] graph;
    int[] colors;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] e : dislikes){ //Build an undirected graph
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        colors = new int[n+1];
        for(int i=0; i<=n; i++){ //If the node i is haven't colored, we dfs it and color it
            if(colors[i]==0 && !dfs(i, 1)){ //if it return false (either itself or it's neighbor can't be colored)
                return false;               //then return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, int red){
        colors[node] = red;
        int blue = -red;
        for(int nei : graph[node]){
            if(colors[nei]==red) return false; //if the neighbor's color is the same with mine, return false
            if(colors[nei]==0 && ! dfs(nei, blue)){//If the neighbor  haven't colored, we dfs it and color it
                return false;                     //  if it return false, we then return false;
            }
        }
        return true;
    }

    /*
    // BFS
     public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[]  graph = new ArrayList[n+1];
        int[]  colors = new int[n+1];
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : dislikes){ //Build an undirected graph
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<=n; i++){
            if(colors[i] != 0) continue; //if the node is colored, continue to next node
            q.add(i);
            colors[i] = 1; // 0 = unkonwn, 1 = red, -1 = blue
            while(!q.isEmpty()){
                int node = q.remove();
                for(int nei : graph[node]){
                    if(colors[nei] == colors[node]) return false;
                    if(colors[nei] != 0) continue;
                    colors[nei] = -colors[node];
                    q.add(nei);
                }
            }
        }
        return true;
    }
     */
}
