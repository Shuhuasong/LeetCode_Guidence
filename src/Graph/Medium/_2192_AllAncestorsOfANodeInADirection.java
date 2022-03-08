package Graph.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
/*
If we can move from node1->node2, node2->node3, node3->node4, then
node 1, 2, 3,  are the ancestors for node 4. Therefore, we can create
a graph with opposite direction:
 node4->node3, node3->node2, node2->node1
Then we use DFS or BFS to collect all the node in this path, then this
list parentList is ancestor for node-4

 */


public class _2192_AllAncestorsOfANodeInADirection {
    Map<Integer, List<Integer>> graph;
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        graph = new HashMap<>();
        int[] indegree = new int[n];
        for(int[] e : edges){
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[1]).add(e[0]);
            indegree[e[1]]++;
        }
        List<List<Integer>> results = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(indegree[i]==0){
                results.add(new ArrayList<>());
                continue;
            }
            Set<Integer> children = new HashSet<>();
            dfs(i, children);

            List<Integer> list = new ArrayList<>();
            for(int a : children) list.add(a);
            Collections.sort(list);
            results.add(list);
        }

        return results;
    }

    private void dfs(int node, Set<Integer> children){
        if(!graph.containsKey(node)) return;
        for(int nei : graph.get(node)){
            if(children.contains(nei)) continue;
            children.add(nei);
            dfs(nei, children);
        }
    }
}
