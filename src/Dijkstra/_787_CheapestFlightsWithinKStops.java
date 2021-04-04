package Dijkstra;

import java.util.PriorityQueue;

public class _787_CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for(int[] f : flights){
            graph[f[0]][f[1]] = f[2];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        pq.offer(new int[]{0, src, K+1});
        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int cost = pair[0], city = pair[1], remainStop = pair[2];
            if(city==dst) return cost;
            if(remainStop > 0){
                for(int i=0; i<n; i++){
                    if(graph[city][i] > 0){
                        pq.offer(new int[]{cost + graph[city][i], i, remainStop-1});
                    }
                }
            }
        }
        return -1;
    }
    
}


/*
Graph Type:
directed vs undirected
weighted vs unweighted
cyclic vs acyclic


unweight-->BFS
weight--> Dijkstar's Algorithm
with negative weighted cycles-->Bellman Ford
 */