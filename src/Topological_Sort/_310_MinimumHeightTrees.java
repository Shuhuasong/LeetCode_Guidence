package Topological_Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _310_MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Arrays.asList(0);
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[n];
        createGraph(n, edges, adjList, inDegree);

        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i]==1){
                leaves.add(i);
            }
        }
        while(n>2){
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves){
                for(int nei : adjList.get(leaf)){
                    inDegree[nei]--;
                    if(inDegree[nei]==1){
                        newLeaves.add(nei);
                    }
                }
            }
            n -= leaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }

    private void createGraph(int n, int[][] edges, List<List<Integer>> adjList, int[] inDegree){
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] e : edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
            inDegree[e[0]]++;
            inDegree[e[1]]++;
        }
    }
}
