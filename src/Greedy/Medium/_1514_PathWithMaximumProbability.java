package Greedy.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _1514_PathWithMaximumProbability {

    //Time = O(V*logV)
    //Space = O(E+V)

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> graph = buildGraph(edges, succProb);
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b)->Double.compare(b[0], a[0]));

        Set<Integer> visited = new HashSet<>();
        double[] weights = new double[n];
        pq.offer(new double[]{1.0, start});

        while(!pq.isEmpty()){
            double[] cell = pq.poll();
            double currWeight = cell[0];
            int  node = (int)cell[1];
            if(visited.contains(node)) continue;
            visited.add(node);
            System.out.println("weight = " + currWeight);
            if(node==end) return currWeight;
            Map<Integer, Double> childs = graph.getOrDefault(node, new HashMap<>());
            for(int nei : childs.keySet()){
                if(visited.contains(nei)) continue;
                double cost = childs.get(nei);
                double newCost = currWeight * cost;
                if(newCost > weights[nei]){
                    weights[nei] = newCost;
                    pq.offer(new double[]{newCost, nei});
                }
            }
        }
        return 0;
    }

    private Map<Integer, Map<Integer, Double>> buildGraph(int[][] edges, double[] succProb){
        Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0], v = edges[i][1];
            graph.computeIfAbsent(u, k->new HashMap<>());
            graph.computeIfAbsent(v, k->new HashMap<>());
            graph.get(u).put(v, succProb[i]);
            graph.get(v).put(u, succProb[i]);
        }
        return graph;
    }
}

/*
Solution-Dijkstra

max probility:
 1) with least path(edge) from src to dest
 2) with largest probility compare with other path(maybe with more path)
steps:
 1> build graph
 2> weights ==> relaxation
 3> init start node
 4> Dijkstra


 3
[[0,1],[1,2],[0,2]]
[0.5,0.5,0.2]
0
2

 */
