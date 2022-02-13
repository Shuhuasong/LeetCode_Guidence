package Graph.Medium;

/**
 * Created by Shuhua Song
 */
public class _574_NumberOfProvince {
    //Time = O(n^2), the complete matrix of size n^2 is traversed
    //Space = O(n), the visited space is used
    public int findCircleNum(int[][] G) {
        int n = G.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(G, i, visited);
                res++;
            }

        }
        return res;
    }



    private void dfs(int[][] G, int i, boolean[] visited){
        if(visited[i]) return;
        visited[i] = true;
        for(int j=0; j<G.length; j++){
            if(!visited[j] && G[i][j]==1){
                dfs(G, j, visited);
            }
        }
    }

    /*
     public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i=0; i<cities; i++){
            if(visited.contains(i)) continue;
            dfs(isConnected, i, visited);
            count++;
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i, Set<Integer> visited){
        visited.add(i);
        for(int j=0; j<isConnected[i].length; j++){
            if(isConnected[i][j]==1){
                if(visited.contains(j)) continue;
                dfs(isConnected, j, visited);
            }
        }
    }

     */

    /*
    //BFS
     public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0; i<cities; i++){
            if(visited.contains(i)) continue;
            visited.add(i);
            q.add(i);
            bfs(isConnected, q, visited);
            count++;
        }
        return count;
    }

    private void bfs(int[][] isConnected, Queue<Integer> q, Set<Integer> visited){
        while(!q.isEmpty()){
            int node = q.poll();
            for(int j=0; j<isConnected[node].length; j++){
                if(isConnected[node][j]==1 && !visited.contains(j)){
                    q.add(j);
                    visited.add(j);
                }
            }
        }
    }

     */
}


/*
这个不能像number of islands那样上下左右去找？
虽然同样都是0和1，但是两题输入的意义完全不同。
number of islands 这类grid的input都是implicit的graph, 每个node都和上下左右4个node相连, 是连通块的问题。 0和1表示不同类别。
这题的输入m[i][j] 如果是0 则表示 第i个人 和 第j个人 不是朋友, 1 则表示是朋友。
*/
