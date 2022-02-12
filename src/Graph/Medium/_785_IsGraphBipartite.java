package Graph.Medium;

/**
 * Created by Shuhua Song
 */
public class _785_IsGraphBipartite {
    //red = 1, blue = -1
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        int color = 1;
        for(int i=0; i<n; i++){
            if(colors[i] != 0) continue;
            if(!dfs(graph, i, color, colors)) return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int curr, int color, int[] colors){
        colors[curr] = color;
        for(int nei : graph[curr]){
            if(colors[nei]==-color) continue;
            if(colors[nei]==color || !dfs(graph, nei, -color, colors)) return false;
        }
        return true;
    }
}
