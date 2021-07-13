package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _785_IsGraphBipartite {
    //solution: graph coloring
    /*
    Solution: Graph Coloring  DFS/BFS
    Color a node as red, and all its neighbors as blue recursively. If there
    is any conflicts then the graph is not bipartite
    */
    //Time = O(E + V)  Space = O(n)

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(colors[i] != 0) continue; //if the node is colored, continue to next node
            colors[i] = 1;  // 0 = unkonwn, 1 = red, -1 = blue
            q.add(i);
            while(!q.isEmpty()){
                int node = q.remove();
                for(int nei : graph[node]){
                    if(colors[nei]==colors[node]) return false;//if the neighbors' color is the same with mine, return false
                    if(colors[nei] != 0) continue;
                    colors[nei] = -colors[node];
                    q.add(nei);
                }
            }
        }
        return true;
    }

    /*
     int[][] graph;
   int[] colors;
    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        int n = graph.length;
        colors = new int[n];

        for(int i=0; i<n; i++){
            if(colors[i]==0 && !dfs(i, 1)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, int red){
        colors[node] = red;
        for(int nei : graph[node]){
            if(colors[nei]==red) return false;
            if(colors[nei]==0 && !dfs(nei, -red)){ return false;}
        }
        return true;
    }
     */
}
