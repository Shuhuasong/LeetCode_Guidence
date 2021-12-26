package Topological_Sort;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _2115_FindAllPossibleRecipeFromGivenSupplies {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        List<String> results = new ArrayList<>();
        Set<String> supply = new HashSet<>();
        for(String sup : supplies) supply.add(sup);
        Map<String, List<String>> graph = buildGraph(recipes, ingredients);
        for(String recipe : recipes){
            if(dfs(recipe, graph, supply)){
                results.add(recipe);
            }
        }
        return results;
    }

    private boolean dfs(String recipe, Map<String, List<String>> graph, Set<String> supply){
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(recipe);
        while(!q.isEmpty()){
            String currRep = q.poll();
            if(visited.contains(currRep)) return false;
            visited.add(currRep);
            if(!graph.containsKey(currRep)) return false;
            List<String> ingredient = graph.get(currRep);
            for(String ingred : ingredient){
                if(!supply.contains(ingred)){
                    q.add(ingred);
                }
            }
        }
        supply.add(recipe);
        return true;
    }

    private Map<String, List<String>> buildGraph(String[] recipes, List<List<String>> ingredients){
        Map<String, List<String>> graph = new HashMap<>();
        for(int i=0; i<recipes.length; i++){
            graph.put(recipes[i], ingredients.get(i));
        }
        return graph;
    }
}
