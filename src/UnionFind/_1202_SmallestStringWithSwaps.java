package UnionFind;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _1202_SmallestStringWithSwaps {
    class UnionFind{
        int[] parent;
        public UnionFind(int n){
            parent = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }
        private int findParent(int x){
            if(parent[x]!=x){
                parent[x] = findParent(parent[x]);
            }
            return parent[x];
        }
        private void union(int x, int y){
            x = findParent(x);
            y = findParent(y);
            if(x<y) parent[y] = x;
            else
                parent[x] = y;
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        char[] chs = s.toCharArray();
        UnionFind UF = new UnionFind(n);
        for(List<Integer> p : pairs){
            int u = p.get(0), v = p.get(1);
            if(UF.findParent(u)!=UF.findParent(v)){
                UF.union(u, v);
            }
        }
        Map<Integer, List<Integer>> rootToChild = new HashMap<>();
        for(int i=0; i<n; i++){
            int root = UF.findParent(i);
            rootToChild.computeIfAbsent(root, k->new ArrayList<>()).add(i);
        }
        for(int key : rootToChild.keySet()){
            List<Integer> list = rootToChild.get(key);
            List<Character> temp = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(int idx : list){
                temp.add(s.charAt(idx));
            }
            Collections.sort(temp);
            int k = 0;
            for(int idx : list){
                chs[idx] = temp.get(k);
                k++;
            }
        }
        return new String(chs);
    }

    /*
     Map<Integer, List<Integer>> graph;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
         int n = s.length();
         graph = new HashMap<>();
         for(int i=0; i<n; i++) graph.put(i, new ArrayList<>());
         for(List<Integer> p : pairs){
             int u = p.get(0), v = p.get(1);
             graph.get(u).add(v);
             graph.get(v).add(u);
         }
        char[] chs = s.toCharArray();
         boolean[] visited = new boolean[n];
         for(int i=0; i<n; i++){
             if(visited[i]) continue;
             List<Integer> indexs = new ArrayList<>();
             dfs(i, indexs, visited);
             List<Character> letters = new ArrayList<>();
             for(int idx : indexs) letters.add(s.charAt(idx));
             Collections.sort(letters);
             int j = 0;
             Collections.sort(indexs);
             for(int idx : indexs){
                 chs[idx] = letters.get(j);
                 j++;
             }
         }
        return new String(chs);
    }

    private void dfs(int node, List<Integer> indexs, boolean[] visited){
        visited[node] = true;
        indexs.add(node);
        for(int next : graph.get(node)){
            if(visited[next]) continue;
            dfs(next, indexs, visited);
        }
    }
     */
}

/*
Solution-Union Find
S = "dcab", pairs = {[0, 1], [1, 2], [2, 3]}
1) if we have pair like [0, 1], and [1, 2], then
   we can swap characters for [0, 2], because they
   are belong to joint group {0, 1, 2}, any two number
   can swap anywhere.
 0<==>1<===>2
 2) Use Union Find to join all the indices in the pair,
    it means they are belong to the same group
 3) iterate group by group, collection all indices under a root
    use Map<Integer,List<Integer>> root==>Children's index
 4) put all the character in children index into temp list, and
    sort the list.
 5) Use the Children's index, copy each character int temp into
    origin String s.

 0 1 2 3
 d c a b

 d c a b
 a c d b
 */

