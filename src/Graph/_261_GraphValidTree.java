package Graph;

import java.util.*;

public class _261_GraphValidTree {

    //Iterative DFS
    //Time = O(N)
    //Space = O(N)
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q.add(0);
        seen.add(0);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei : graph.get(node)){
                if(seen.contains(nei)){
                    continue;
                }
                seen.add(nei);
                q.add(nei);
            }
        }
        return seen.size() == n;
    }

    /*
  //Iterative DFS
    //Time = O(N), N = the # of nodes
    //Space = O(N)
    List<List<Integer>> graph = new ArrayList<>();
    Set<Integer> seen = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        dfs(0);
        return seen.size() == n;
    }

    public void dfs(int node){
        if(seen.contains(node)) return;
        seen.add(node);
        for(int nei : graph.get(node)){
            dfs(nei);
        }
    }
     */



    /*
    class UnionFind {
    private int[] parent;
    private int[] size; // We use this to keep track of the size of each set.
    // For efficiency, we aren't using makeset, but instead initialising
    // all the sets at the same time in the constructor.
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int node = 0; node < n; node++) {
            parent[node] = node;
            size[node] = 1;
        }
    }
    // The find method, with path compression. There are ways of implementing
    // this elegantly with recursion, but the iterative version is easier for
    // most people to understand!
    public int find(int A) {
        // Step 1: Find the root.
        int root = A;
        while (parent[root] != root) {
            root = parent[root];
        }
        // Step 2: Do a second traversal, this time setting each node to point
        // directly at A as we go.
        while (A != root) {
            int oldRoot = parent[A];
            parent[A] = root;
            A = oldRoot;
        }
        return root;
    }

    // The union method, with optimization union by size. It returns True if a
    // merge happened, False if otherwise.
    public boolean union(int A, int B) {
        // Find the roots for A and B.
        int rootA = find(A);
        int rootB = find(B);
        // Check if A and B are already in the same set.
        if (rootA == rootB) {
            return false;
        }
        // We want to ensure the larger set remains the root.
        if (size[rootA] < size[rootB]) {
            // Make rootB the overall root.
            parent[rootA] = rootB;
            // The size of the set rooted at B is the sum of the 2.
            size[rootB] += size[rootA];
        }
        else {
            // Make rootA the overall root.
            parent[rootB] = rootA;
            // The size of the set rooted at A is the sum of the 2.
            size[rootA] += size[rootB];
        }
        return true;
    }
}
class Solution {
     public boolean validTree(int n, int[][] edges) {

        // Condition 1: The graph must contain n - 1 edges.
        if (edges.length != n - 1) return false;

        // Condition 2: The graph must contain a single connected component.
        // Create a new UnionFind object with n nodes.
        UnionFind unionFind = new UnionFind(n);
        // Add each edge. Check if a merge happened, because if it
        // didn't, there must be a cycle.
        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            if (!unionFind.union(A, B)) {
                return false;
            }
        }

        // If we got this far, there's no cycles!
        return true;
    }
}
     */
}
