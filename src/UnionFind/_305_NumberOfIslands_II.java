package UnionFind;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _305_NumberOfIslands_II {


    //Union Find
    //Time = O(m*n + L)
    class UnionFind {
        int[] parent, rank;
        int count;
        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            count = 0;
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 0);
        }

        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX!=rootY){
                if(rank[rootX] > rank[rootY]){
                    parent[rootY] = rootX;
                }else if(rank[rootX] < rank[rootY]){
                    parent[rootX] = rootY;
                }else{
                    parent[rootY] = rootX;
                    rank[rootX] += 1;
                }
                --count;
            }
        }

        public void setParent(int i){
            parent[i] = i;
            count++;
        }

        public boolean isValid(int i){
            return parent[i] >= 0;
        }

        public int getCount(){
            return count;
        }
    }


    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind  UF = new UnionFind(m * n);
        List<Integer> results = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for(int[] p : positions){
            int r = p[0], c = p[1];
            int index = r * n + c;
            if(visited.contains(index)){
                results.add(UF.getCount());
                continue;
            }
            visited.add(index);
            List<Integer> overLap = new ArrayList<>();

            if(r+1 < m && UF.isValid((r+1)*n+c)) overLap.add((r+1)*n+c);
            if(r-1 >= 0 && UF.isValid((r-1)*n+c)) overLap.add((r-1)*n+c);
            if(c+1 < n && UF.isValid(r*n+(c+1))) overLap.add(r*n+(c+1));
            if(c-1 >= 0 && UF.isValid(r*n+(c-1))) overLap.add(r*n+(c-1));

            UF.setParent(index);
            for(int neighb : overLap) UF.union(index, neighb);
            results.add(UF.getCount());
        }
        return results;
    }


    /*    //Time = O(m*n*L)
     int m, n;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        this.m = m;
        this.n = n;
        int[][] grid = new int[m][n];
        int len = positions.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<len; i++){
            int[] p = positions[i];
            grid[p[0]][p[1]] = 1;
            int num = numIsland(grid);
            list.add(num);
        }

        return list;
    }

    private int numIsland(int[][] grid){
        int num = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    num++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return num;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(grid, i+1, j, visited);
        dfs(grid, i-1, j, visited);
        dfs(grid, i, j+1, visited);
        dfs(grid, i, j-1, visited);
    }
     */
}
