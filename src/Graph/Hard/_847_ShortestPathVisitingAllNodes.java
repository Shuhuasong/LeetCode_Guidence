package Graph.Hard;

/**
 * Created by Shuhua Song
 */
public class _847_ShortestPathVisitingAllNodes {
    //DFS+Memoization--Top Dawn
    //Time = O(N^2 * 2^n), the total number of possible states is O(N*2^N), each time when we explore each node, they all have these states
    //Space = O(N*2^N)
    int[][] memo, graph;
    int res = 0;
    public int shortestPathLength(int[][] graph) {
        this.graph = graph;
        int n = graph.length;
        //goalMask = (1 << 5)-1 = 11111
        int goalMask = (1<<n)-1;
        //Add one for each dimension
        memo = new int[n+1][goalMask+1];
        res = Integer.MAX_VALUE;
        //find the optimal solution by start from each node
        for(int i=0; i<n; i++){
            res = Math.min(res, dfs(i, goalMask));
        }
        return res;
    }
    private int dfs(int node, int goalMask){
        //the state has been cached, return it
        if(memo[node][goalMask] != 0) return memo[node][goalMask];
        //we have visitee all nodes,check the mask has only one bit set to 1
        // 1) 01111&10000=0,  2) 1 & 0 = 0
        if((goalMask & (goalMask-1))==0) return 0;
        //Intially the state with largest Value to avoid infinite cycles
        //e.g  node1-->node0-->node1
        memo[node][goalMask] = Integer.MAX_VALUE-1;//need to minus 1, otherwise exceed range when we add 1 below
        for(int nei : graph[node]){
            //when the nei is not visited: e.g 11111^00001=00001
            if((goalMask & (1<<nei)) != 0){
                //already visited : 1-->0-->1
                int seen = dfs(nei, goalMask);
                //visited 1 first time: 0--->1, change - the bit at position 1 being set to 1 means we have already visited this node
                int noSeen = dfs(nei, (goalMask ^ (1<<node)));
                int best = Math.min(seen, noSeen);
                memo[node][goalMask] = Math.min(memo[node][goalMask], 1 + best);
            }
        }
        return memo[node][goalMask];
    }

    /*
      public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int goalMask = (1<<n)-1;
        boolean[][] visited = new boolean[n][goalMask];//TODO: add 1 for dimension, the result is the same
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            q.offer(new int[]{i, 1<<i});
        }
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cell = q.poll();
                int node = cell[0], mask = cell[1];
                //means taking one more step to the neighbor will complete visiting all nodes
                if(mask==goalMask) return steps;
                if(visited[node][mask]) continue;
                visited[node][mask] = true;
                for(int next : graph[node]){
                    //declare a new state
                    int nextMask = mask | (1<<next);
                    q.offer(new int[]{next, nextMask});
                }
            }
            steps++;
        }
        return -1;
    }
     */
}


/*
1.How to change the mask (flip certain bits, for example, if we visit
the 4th node, how do we flip the 4th bit?)
1) shift = 1<<i = 1<<4 = 10000
2) XOR with mask: mask ^ shift = 01100 ^ 10000 = 11100

2.How to tell what nodes we have visited so far (given a certain mask,
how do we tell if we have visited the 4th node?)
1) shift = 1<<i = 1<<4 = 10000
2) use AND operation with mask: mask & shift = 11100 & 10000 = 1===> visited
                                mask & shift = 01100 & 10000 = 0===> not visited

3. More formally, for any given state (node, mask), we can traverse to (neighbor, mask | (1 << neighbor)) for all neighbors in graph[node].
 */
