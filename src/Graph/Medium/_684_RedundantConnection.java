package Graph.Medium;

public class _684_RedundantConnection {
    //Union Find
    //Time O(n) Space = O(n)
    class UnionFind{
        int[] parents;
        int[] rank;
        public UnionFind(int n){
            parents = new int[n];
            rank = new int[n];
            for(int i=0; i<n; i++){
                parents[i] = i;
                rank[i] = 1;
            }
        }

        public boolean union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px==py) return false;
            if(rank[px] < rank[py]){
                parents[px] = py;
            }else if(rank[py] < rank[px]){
                parents[py] = px;
            }else{
                parents[py] = px;
                rank[px] += 1;
            }
            return true;
        }
        //find the parent of x and path compression
        public int find(int x){
            while(parents[x] != x){
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind  u = new UnionFind(edges.length+1);
        for(int[] e : edges){
            if(!u.union(e[0], e[1])){
                return e;
            }
        }
        return null;
    }


    /*
       //DFS traversal
       // for each edge (u, v), traverse the graph with a DFS to see if we can
       // connect u to v. If we can, then it must be the duplicate edge
    //Time = O(n^2), n is the number of vertices. In the worst case, for every edge we include, we
    //have to search every previously-occuring edge of the graph
     //Space = O(n)
   public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            Set<Integer> visited = new HashSet<>();
            if(hasPath(u, v, graph, visited)){
                return e;
            }
            if(!graph.containsKey(u)){
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(v);

            if(!graph.containsKey(v)){
                graph.put(v, new ArrayList<>());
            }
            graph.get(v).add(u);
        }
        return new int[]{};
    }

    private boolean hasPath(int src, int des, Map<Integer, List<Integer>> graph, Set<Integer> visited){
        if(!graph.containsKey(src) || !graph.containsKey(des)) return false;
        if(src==des) return true;
        visited.add(src);
        for(int nei : graph.get(src)){
            if(visited.contains(nei)) continue;
            if(hasPath(nei, des, graph, visited)) return true;
        }
        return false;
    }
    */
}
