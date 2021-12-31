package DFS_and_BFS.Medium;

/**
 * Created by Shuhua Song
 */
public class _947_MostStonesRemovedWithSameRowOrCol {

    class UnionFind{
        private int[] parent;
        private int[] rank;
        private int count;
        public UnionFind(int N){
            parent = new int[N];
            rank = new int[N];
            count = N;
            for(int i=0; i<N; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px==py) return;

            if(rank[x] <= rank[y]){
                parent[px] = py;
                rank[py]++;
            }else{
                parent[py] = px;
                rank[px]++;
            }
            count--;
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind UF = new UnionFind(n);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    UF.union(i, j);
                }
            }
        }
        System.out.println(UF.count);
        return (n-UF.count);
    }

    /*
      //DFS : Time = O(n^2)
    public int removeStones(int[][] stones) {
         if(stones==null || stones.length==0) return 0;
         HashSet<Integer> visited = new HashSet<>();
         int islands = 0 , n = stones.length;
         for(int i=0; i<n; i++){
             if(visited.contains(i)) continue;
             dfs(stones, i, visited);
             islands++;
         }
         return n-islands;
    }

    private void dfs(int[][] stones, int i, HashSet<Integer> visited){
        visited.add(i);
        for(int j=0; j<stones.length; j++){
            if(visited.contains(j)) continue;
            if(stones[j][0]==stones[i][0] || stones[j][1]==stones[i][1]){
                dfs(stones, j, visited);
            }
        }
    }
     */
}
