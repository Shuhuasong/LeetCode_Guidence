package Graph;

import java.util.*;


public class _261_GraphValidTree {


    //Iterative BFS
    // Time = O(N+E)=O(2*N) = O(N), N = the # of nodes, E = N-1 = N
    // Space = Time = O(N)
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
  //Recursive DFS
    //Time = O(N+E)=O(2*N) = O(N), N = the # of nodes, E = N-1 = N
    //Space = Time = O(N)
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


    /*  Solution-1
      //check if the graph has cycle
    //Iterative Breath first search
    //Time = O(N + E), O(N) == create adjacentlist, O(E)=iterate and insert each edges
    //Space = O(N + E),adjacentlist is a list of length N, with inner
    // lists with lengths that add to a total of E
    private List<Integer>[] graph;
    private Set<Integer> visited;
    private Map<Integer, Integer> parent; //use parent to make sure not go back to parent again
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length) return false;

        graph = new ArrayList[n];
        visited = new HashSet<>();
        parent = new HashMap<>();
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        //the first node doesn't have parent
        //return true iff no cycle were detected,
        //And the entire graph has been reached
        parent.put(0, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei : graph[node]){
                if(parent.get(node) == nei) continue;
                //The node nei has been visited before
                if(parent.containsKey(nei)) return false;
                q.offer(nei);
                parent.put(nei, node);
            }
        }
        return parent.size()==n;
    }
     */



    /*
    //check if the graph has cycle
    //DFS
    private List<Integer>[] graph;
    private Set<Integer> visited;
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length) return false;

        graph = new ArrayList[n];
        visited = new HashSet<>();
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        //the first node doesn't have parent
        //return true iff no cycle were detected,
        //And the entire graph has been reached
        return  !withCycle(0, -1) && visited.size()==n;
    }

    private boolean withCycle(int node, int parent){
        if(visited.contains(node)) return true;
        visited.add(node);
        for(int nei : graph[node]){
            if(parent != nei){
                boolean isCycle = withCycle(nei, node);
                if(isCycle) return true;
            }
        }
        return false;
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
           //no path compression, trace up the parent
           //unitl it finds the root node for A, and return root
            public int find(int A){
               while(parent[A] != A) {
                 A = parent[A];
               }
               return A;
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


/*

1) a graph, G, is a tree iff the following two conditions are met:
   -- G is fully connected. In other words, for every pair of nodes in G, there is a path between them.
   -- G contains no cycles. In other words, there is exactly one path between each pair of nodes in G.
2) Depth-first search is a classic graph-traversal algorithm that can be used to check for both of these conditions:

--G is fully connected if, and only if, we started a depth-first search from a single source and discovered all nodes in G during it.
--G contains no cycles if, and only if, the depth-first search never goes back to an already discovered node. We need to be careful though not to count trivial cycles of the form A → B → A that occur with most implementations of undirected edges.
3) Graph representation
   Adjacency list: List<List<Integer>>, List<Integer>[], Map<Integer, List<Integer>>
   Adjacency Matrix: good for #edges > #nodes
   <1> First check if the graph is fully connected, then every node must have been seen. Then seen.size()==n
   <2> check if there is a cycle in graph.
       if(seen.contains(neighbor)) return false ==> work for directed graph.
       for undirected graph, the 'cycle' will be detected. because an undirected edge is actually 2 edges in the adjacent list, so it form a cycle

4)Several strategies of detecting whether or not an undirected graph contains cycles, since we need to be careful with trivial cycles.
  1. Iterative DFS and BFS
    <1> to ensure only visited each edge once in one direction, we can deleted the opposite direction. e.g. when visited edge A->B, we delete
B->A by looking up B's adjacency list. And use a set seen, to check if the node have been visited, if it is, return false; (contains cycle)
    graph.get(nei).remove(currNode);
   <2> use a map to track the "parent" have visited.
       Map<currNode, parent> parent,
       if(parent.get(node)==neighbor) continue;
       if (parent.containsKey(nei)) return false
    Iterative Depth first Search:
       Solution -- 1

   <3> DFS-recursion

  2. <1> Use definition to check if a given graph is tree or not :
     Condition for the graph to be a valid tree: #nodes-1 = #edges;
     if with less edges, it is not fully connected. with more,
     it must have cycles, e.g 5 nodes and 5 edges
     A------B------C
     |      |
     |      |
     D------E
    Going by this definition, our algorithm needs to do the  following:

     1>Check whether or not there are n - 1 edges. If there's not, then return false.
     2>Check whether or not the graph is fully connected. Return true if it is, false          if otherwise.
*/



