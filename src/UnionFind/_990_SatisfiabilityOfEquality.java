package UnionFind;

/**
 * Created by Shuhua Song
 */
public class _990_SatisfiabilityOfEquality {

    //Union Find
    int[] groups = new int[26]; //groups = parents
    public boolean equationsPossible(String[] equations) {
        for(int i=0; i<26; i++){
            groups[i] = i;
        }
        for(String e : equations){
            if(e.charAt(1)=='='){
                union(e.charAt(0), e.charAt(3));
            }
        }

        for(String e : equations){
            if(e.charAt(1)=='!'){
                //if two variable are not equal, it is not possible that parent are the same
                if(find(e.charAt(0)-'a')==find(e.charAt(3)-'a')) return false;
            }
        }
        return true;
    }

    private void union(char x, char y){
        groups[find(x-'a')] = groups[find(y-'a')];
    }

    private int find(int x){
        if(x == groups[x]){
            return x;
        }
        return groups[x] = find(groups[x]);
    }

    /*
there are 26 nodes in the graph
All "==" equations represents the connection in the graph.
The connected nodes should be in the same color/union/set

Then we check all "!=", two inequal nodes should have different color/union/set
Method:
We solve the problem by using DFS or Union Find
1) find all "==" equation first, union all equal letter together.
2) second pass, find all "!=" inequations, check if they are any contradict
   if they have same parent, then return false;
Time : O(n)
Space : O(n)
*/


    /*
     //DFS
    public boolean equationsPossible(String[] equations) {
       Map<Character, HashSet<Character>> graph = new HashMap<>();
       for(String e : equations){
           if(e.charAt(1)=='='){
               char u = e.charAt(0);
               char v = e.charAt(3);
               if(!graph.containsKey(u)){
                   graph.put(u, new HashSet<>());
               }
               graph.get(u).add(v);
               if(!graph.containsKey(v)){
                   graph.put(v, new HashSet<>());
               }
               graph.get(v).add(u);
           }
       }
        for(String e : equations){
            if(e.charAt(1)=='!'){
                char u = e.charAt(0);
                char v = e.charAt(3);
                if(u==v) return false;
                if(!graph.containsKey(u) || !graph.containsKey(v)) continue;
                if(withConflict(u, v, graph, new HashSet<>())) return false;
            }
        }
        return true;
    }

    private boolean withConflict(Character pre, Character next, Map<Character, HashSet<Character>> graph, HashSet<Character> seen){
        if(pre==next) return true;
        seen.add(pre);
        for(Character nei : graph.get(pre)){
            if(seen.contains(nei)) continue;
            if(withConflict(nei, next, graph, seen)){
                return true;
            }
        }
        return false;
    }
     */
}
