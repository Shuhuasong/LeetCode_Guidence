package Tree.MinimumSpanningTree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Shuhua Song
 */
public class _1584_MinCostToConnectAllPoints {


    //Prim's Algorithm
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if(n <= 1) return 0;
        List<List<int[]>> edges = new ArrayList<>();
        boolean[] visited = new boolean[1000];
        for(int i=0; i<n; i++) edges.add(new ArrayList<>());
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                List<int[]> edgesI = edges.get(i), edgesJ = edges.get(j);
                edgesI.add(new int[]{dist, j});
                edgesJ.add(new int[]{dist, i});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        for(int[] edge : edges.get(0)) pq.offer(edge);
        visited[0] = true;
        int count = 0;
        int res = 0;
        while(!pq.isEmpty()){
            while(!pq.isEmpty() && visited[pq.peek()[1]]){
                pq.poll();
            }
            int[] edge = pq.poll();
            int dis = edge[0], next = edge[1];
            count++;
            res += dis;
            visited[next] = true;
            if(count==n-1) break;
            for(int[] e : edges.get(next)) pq.offer(e);
        }

        return res;
    }


    /*
    class UnionFind{
        int[] parent;
        public UnionFind(){
            parent = new int[1001];
            for(int i=0; i<=1000; i++){
                parent[i] = i;
            }
        }
        private int findParent(int x){
            if(parent[x] != x){
                parent[x] = findParent(parent[x]);
            }
            return parent[x];
        }
        private void union(int x, int y){
            x = findParent(x);
            y = findParent(y);
            if(x < y) parent[y] = x;
            else
                parent[x] = y;

        }
    }

    public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            if(n <= 1) return 0;
            UnionFind UF = new UnionFind();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    int x1 = points[i][0], y1 = points[i][1];
                    int x2 = points[j][0], y2 = points[j][1];
                    int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                    pq.add(new int[]{dist, i, j});
                }
            }
            int count = 0;
            int res = 0;
            while(!pq.isEmpty()){
                int[] edge = pq.poll();
                int dis = edge[0];
                int p1 = edge[1], p2 = edge[2];
                //two nodes haven't connected
                if(UF.findParent(p1)!=UF.findParent(p2)){
                    count++;
                    res += dis;
                    UF.union(p1, p2);
                }
                if(count==n-1) break;
            }
        return res;
    }
     */
}


/*
In java,  Kruskal is faster than Prim
But maybe lower for C++

Minimum Spanning Tree (MST)
N = number of nodes
N*(N-1)/2 = total number of edges
N-1  = minimum edges to connect all nodes

Algorithm-1: Kruskal
Time Complexity = N^2log(N^2) ==> N^2*logN
steps:
1) sort all edges by weight(manhanttan distance)
 e.g [edge1, edge2, edge3, ....]
 1-2, 2-3, 1-3,....
2) Use union find to check if the node 1 & 2 are connect when check edge 1-3


Algorithm-2: Prim
Time Complexity = O(N^2)
steps:
1) start from node 0, and expand from this node
   0  with edges {0-1, 0-2, ....} pick min edges
   if pick 0-2 : then have [edges02], then expand from node 2 and repeat the process

*/

