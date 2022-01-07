package Graph.Easy;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _1971_FindIfPathExistsGraph {

    //BFS: Time = O(N), N = # of nodes
    //Space = O(N)
    Map<Integer, List<Integer>> graph;
    public boolean validPath(int n, int[][] edges, int start, int end) {
        graph = new HashMap<>();
        for(int[] e : edges){
            int u = e[0], v = e[1];
            if(!graph.containsKey(u))
                graph.put(u, new ArrayList<>());
            if(!graph.containsKey(v))
                graph.put(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        //visited[start] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            if(node==end) return true;
            visited[node] = true;
            for(int nei : graph.get(node)){
                if(visited[nei]) continue;
                q.add(nei);
            }
        }
        return false;
    }


 /*    //Time = O(N), N = # of nodes
    //Space = O(N)
    Map<Integer, List<Integer>> graph;
   public boolean validPath(int n, int[][] edges, int start, int end) {
        graph = new HashMap<>();
        for(int[] e : edges){
            int u = e[0], v = e[1];
            if(!graph.containsKey(u))
                graph.put(u, new ArrayList<>());
            if(!graph.containsKey(v))
                graph.put(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        return dfs(start, end, visited);
    }

    private boolean dfs(int s, int e, boolean[] visited){
        if(visited[s]) return false;
        if(s==e) return true;
        visited[s] = true;
        boolean res = false;
        for(int nei : graph.get(s)){
            if(visited[nei]) continue;
            res = dfs(nei, e, visited);
            if(res) break;
        }
        return res;
    } */
}
