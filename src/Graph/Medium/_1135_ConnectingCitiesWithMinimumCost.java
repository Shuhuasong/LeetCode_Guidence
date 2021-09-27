package Graph.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */

class UnionFind{
    private int[] weights;
    private int[] parents;
    public UnionFind(int n){
        weights = new int[n+1];
        parents = new int[n+1];
        for(int i=1; i<=n; i++){
            parents[i] = i;
            weights[i] = 1;
        }
    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        //If both x and y have same root, they both belong to the same set, hence we don't need to take union
        if(rootX==rootY) return;
        //Weighted union
        if(weights[x] > weights[y]){
            //In case rootX is having more weight
            //1. make rootX as the parent of rootY
            //2. increment the weight of rootX by rootY's weight
            parents[rootY] = rootX;
            weights[rootX] += weights[rootY];
        }else{
            //1. make rootX as the parent of rootY
            //2. Increment the weight of rootY by rootX's weight
            parents[rootX] = rootY;
            weights[rootY] += weights[rootX];
        }
    }

    public int find(int x){
        //Traverse all the way to the top (root) going through
        // the parent nodes
        while(x != parents[x]){
            //Path conpression
            //x's grandparent is now x's parent
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }

    public boolean isInSameGroup(int x, int y){
        return find(x)==find(y);
    }
}



public class _1135_ConnectingCitiesWithMinimumCost {

    public int minimumCost(int n, int[][] connections) {
        UnionFind unionF = new UnionFind(n);
        //sort connections based on the weights (in increasing order)
        Arrays.sort(connections, (a, b)->a[2]-b[2]);
        //keep track of the total edges addedint the Minimim Spaining Tree
        int total = 0;
        //keep track of the total cost of adding all those edges
        int cost = 0;
        for(int i=0; i<connections.length; i++){
            int a = connections[i][0];
            int b = connections[i][1];
            //Do not add the edges from a to b if it is already connected
            if(unionF.isInSameGroup(a, b)) continue;
            //if a and b are not connected, take union
            unionF.union(a, b);
            // increment cost
            cost += connections[i][2];
            total++;
        }
        //if all n nodes are connected, then there are n-1 edges
        if(total == n-1) return cost;
        return -1;
    }
}
