package Graph.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */

//Time = O(M*N), N = # equations, M = # queries
//Time = O(N) + O(N) +   O(N)
//       graph  backtrack   visited
public class _399_EvaluateDivision {
    Map<String, HashMap<String, Double>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        //Build graph from equations
        for(int i=0; i<equations.size(); i++){
            List<String> e = equations.get(i);
            String x = e.get(0), y = e.get(1);
            double val = values[i];
            if(!graph.containsKey(x))
                graph.put(x, new HashMap<String, Double>());
            if(!graph.containsKey(y)){
                graph.put(y, new HashMap<String, Double>());
            }
            graph.get(x).put(y, val);
            graph.get(y).put(x, 1/val);
        }

        int size = queries.size();
        double[] res = new double[size];
        for(int i=0; i<size; i++){
            List<String> q = queries.get(i);
            String x1 = q.get(0), y1 = q.get(1);
            if(!graph.containsKey(x1) || !graph.containsKey(y1)) res[i] = -1.0;
            else if(x1.equals(y1)) res[i] = 1.0;
            else{
                Set<String> visited = new HashSet<>();
                res[i] = backtrack(x1, y1, 1, visited);
            }
        }
        return res;
    }

    private double backtrack(String src, String dest, double val, Set<String> visited){
        visited.add(src);
        double res = -1.0;
        Map<String, Double> neighbors = graph.get(src);
        if(neighbors.containsKey(dest)){
            res = val * neighbors.get(dest);
        }else{
            for(String nei : neighbors.keySet()){
                if(visited.contains(nei)) continue;
                double v = neighbors.get(nei);
                res = backtrack(nei, dest, val*v, visited);
                if(res != -1) break;
            }
        }
        visited.remove(src);
        return res;
    }
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



