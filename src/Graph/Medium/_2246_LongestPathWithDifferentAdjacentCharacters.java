package Graph.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _2246_LongestPathWithDifferentAdjacentCharacters {
    int maxPath = 0;
    Map<Integer, List<Integer>> graph;
    public int longestPath(int[] parent, String s) {
        if(parent==null || parent.length==0) return 0;
        graph = new HashMap<>();
        int n = parent.length;
        for(int i=0; i<n; i++){
            graph.computeIfAbsent(parent[i], k->new ArrayList<>()).add(i);
        }
        dfs(0, s);
        return maxPath;
    }

    private int dfs(int node, String s){
        //maxPath1: the largest path from this node to child
        //maxPath2: the second largest path from this node child
        int maxPath1 = 0, maxPath2 = 0;
        for(int nei : graph.getOrDefault(node, new ArrayList<>())){
            int childPath = dfs(nei, s);
            if(s.charAt(node)!=s.charAt(nei)){
                //update the value of maxPath1 and maxPath2 depande on the value of childPath
                //maxPath2 < maxPath2 < childPath
                if(childPath > maxPath1){
                    maxPath2 = maxPath1;
                    maxPath1 = childPath;
                }else{
                    //maxPath2 < childPath < maxPath2
                    if(childPath > maxPath2){
                        maxPath2 = childPath;
                    }
                }
            }
        }
        //update the maxPath througth combining the two largetst path
        maxPath = Math.max(maxPath, maxPath1+maxPath2+1);
        return maxPath1+1;
    }
}
