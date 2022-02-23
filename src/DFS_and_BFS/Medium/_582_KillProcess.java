package DFS_and_BFS.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _582_KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int size = ppid.size();
        Map<Integer, List<Integer>> parent2Child = new HashMap<>();
        for(int i=0; i<size; i++){
            int parent = ppid.get(i), child = pid.get(i);
            parent2Child.computeIfAbsent(parent, k->new ArrayList<>()).add(child);
        }
        Set<Integer> seen = new HashSet<>();
        seen.add(kill);
        dfs(kill, seen, parent2Child);
        List<Integer> results = new ArrayList<>();
        for(int node : seen) results.add(node);

        return results;
    }

    private void dfs(int kill, Set<Integer> seen, Map<Integer, List<Integer>> graph){
        if(!graph.containsKey(kill)) return;
        seen.add(kill);
        for(int child : graph.get(kill)){
            seen.add(child);
            dfs(child, seen, graph);
        }
    }
}
