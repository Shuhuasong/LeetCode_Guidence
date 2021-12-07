package Graph.Hard;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _685_RedundantConnectionII {

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
        public int find(int x){
            if(parents[x] != x){
                parents[x] =find(parents[x]);
            }
            return parents[x];
        }
        public boolean union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx==rooty) return false;
            if(rank[rootx] < rank[rooty]){
                parents[rootx] = rooty;
                rank[rooty] += rank[rootx];
            }else{
                parents[rooty] = rootx;
                rank[rootx] += rank[rooty];
            }
            return true;
        }
    }

    public int[] cycleDetect(int n, int[][] edges, int[] skipEdge){
        UnionFind UF = new UnionFind(n+1);
        for(int[] e : edges){
            if(Arrays.equals(e, skipEdge)) continue;
            if(!UF.union(e[0], e[1])){
                return e;
            }
        }
        return null;
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n+1];
        int dupParent = -1;
        //find the node with two parents
        for(int[] e : edges){
            inDegree[e[1]]++;
            if(inDegree[e[1]]==2){
                dupParent = e[1];
                break;
            }
        }
        //if There is no node with two parent, then it is case 1
        if(dupParent==-1) return cycleDetect(n, edges, null);
        //if a node with two parents, delete the node that cause the graph with cycle
        for(int i=n-1; i>=0; i--){
            if(edges[i][1] == dupParent){
                if(cycleDetect(n, edges, edges[i])==null) return edges[i];
            }
        }
        return new int[]{};
    }

}


/*


Case 1: No duplicate parents, return the first edge that creates the loops. Same to LC-684 Redundant Connection I
Case 2: A node v has two parents {u1, u2}
Case 2.1: return the second edge that creates duplicate parents(without cycle)
Case 2.2: reutrn {u1, v} or {u2, v} that creats the loop

case 1:

  5<----1---->2
        ^     |
        |     V
        4<----3

case 2:

   2<-----1----->3
   |            ^
   | ___________|

case 3:
    2----->1<-----3
    ^      |
    |      V
    -------4
 */
