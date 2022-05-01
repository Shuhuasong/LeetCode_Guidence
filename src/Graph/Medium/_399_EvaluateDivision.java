package Graph.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */

//Time = O(M*N), N = # equations, M = # queries
//Time = O(N) + O(N) +   O(N)
//       graph  backtrack   visited
public class _399_EvaluateDivision {
    Map<String, Map<String, Double>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        int m = queries.size();
        // Step 1). build the graph from the equations
        buildGraph(equations, values);
        double[] res = new double[m];
        for(int i=0; i<m; i++){
            List<String> e = queries.get(i);
            String x = e.get(0), y = e.get(1);
            if(!graph.containsKey(x) || !graph.containsKey(y)){
                res[i] = -1.0; continue;
            }else if(x.equals(y)){
                res[i] = 1.0; continue;
            }else{
                HashSet<String> visited = new HashSet<>();
                res[i] = dfs(x, y, 1, visited);
            }
        }
        return res;
    }
    // Step 2). Evaluate each query via bactracking (DFS)
    // by verifying if there exists a path from dividend to divisor
    private double dfs(String src, String dest, double val, HashSet<String> visited){
        // mark the visit
        visited.add(src);
        double res = -1.0;
        Map<String, Double> neighbors = graph.get(src);
        if(neighbors.containsKey(dest)){
            res = val * neighbors.get(dest);
        }else{
            for(String next : neighbors.keySet()){
                if(visited.contains(next)) continue;
                double v = neighbors.get(next);
                res = dfs(next, dest, val * v, visited);
                //we can find a path from src to next, then break
                if(res != -1) break;
            }
        }
        // unmark the visit, for the next backtracking
        visited.remove(src);
        return res;
    }

    private void buildGraph(List<List<String>> equations, double[] values){
        int n = equations.size();
        for(int i=0; i<n; i++){
            List<String> e = equations.get(i);
            String x = e.get(0), y = e.get(1);
            graph.putIfAbsent(x, new HashMap<>());
            graph.putIfAbsent(y, new HashMap<>());
            double val = values[i];
            graph.get(x).put(y, val);
            graph.get(y).put(x, 1/val);
        }
    }

    /*
     class UnionFind{
        private int[] parent;
        private double[] weight;
        public UnionFind(int n){
            parent = new int[n];
            weight = new double[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }
        public int find(int x){
            //find path from curr x to parent[x]
            //we need also update the weight[x] by multiply
            if(parent[x] != x){
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y, double val){
            int rootX = find(x), rootY = find(y);
            if(rootX == rootY) return;
            parent[rootX] = rootY;
            weight[rootX] = weight[y] * val/weight[x];
        }

        public double isConnected(int x, int y){
            int rootX = find(x), rootY = find(y);
            System.out.println(x + " " + y + " " + rootX + " " + rootY  + " " + weight[x] + " " + weight[y]);
            if(rootX == rootY){
                return weight[x]/weight[y];
            }else{
                return -1.0d;
            }
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        UnionFind UF = new UnionFind(2 * n);
        Map<String, Integer> nodeToIdx = new HashMap<>();
        int idx = 0;
        for(int i=0; i<n; i++){
            List<String> e = equations.get(i);
            String v1 = e.get(0), v2 = e.get(1);
            if(!nodeToIdx.containsKey(v1)) nodeToIdx.put(v1, idx++);
            if(!nodeToIdx.containsKey(v2)) nodeToIdx.put(v2, idx++);
            UF.union(nodeToIdx.get(v1), nodeToIdx.get(v2), values[i]);
        }
        int m = queries.size();
        double[] res = new double[m];
        for(int i=0; i<m; i++){
            List<String> q = queries.get(i);
            String s1 = q.get(0), s2 = q.get(1);
            Integer  id1 = nodeToIdx.get(s1), id2 = nodeToIdx.get(s2);
            if(id1==null || id2==null){
                res[i] = -1.0d;
            }else{
                res[i] = UF.isConnected(id1, id2);
            }
        }
        return res;
    }
     */
}


/*
Solution--Graph: Path Searching

ex-1:
a/b = 2.0, b/c = 3.0
b/a = 0.5, c/b = 1/3

    2.0    3.0
 a-----> b ----> c

a/c = ?
b/a = ?
a/e = ?
a/a = ?
x/x = ?

ex-2:
a/b = 1.5, b/c = 2.5, bc/cd = 5.0
b/a = 2/3, c/b = 2/5, cd/bc = 1/5

   1.5       2.5
a-------> b------->c
          |
          | 5.0
          d

a/c = 1.5*2.5
c/b = 2/5 = 0.4
bc/cd = 5.0
cd/bc = 1/5

ex-3;
a/b = 0.5
b/a = 2

*/



