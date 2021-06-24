package BINARYSEARCH_Web.Tree;

import java.util.*;

public class _921_LengthOfTheLongestPathInAnNAryTree {
    static Map<Integer, List<Integer>> g = new HashMap<>();
    static Set<Integer> seen = new HashSet<>();
    static int res = 0;

    public static int longestPathInN_AryTree(int[][] edges){
        int root = edges[0][0]; //assign the root to first node
        for(int[] e : edges){// Construct the graph,
            int u = e[0];
            int v = e[1];
            //root = u;
            if(!g.containsKey(u)) g.put(u, new ArrayList<>());
            if(!g.containsKey(v)) g.put(v, new ArrayList<>());
            g.get(u).add(v);
            g.get(v).add(u);
        }
        seen.add(root);
        dfs(root);
        return res;
    }
   //use dfs to find the largest path for each subnodes
    public static int dfs(int root){
        List<Integer> list = new ArrayList<>();
        for(int next : g.get(root)){
            if(!seen.contains(next)){
                seen.add(next);
                int len = dfs(next);
                list.add(len);
            }
        }
        Collections.sort(list);
        int size = list.size();
        if(size==0) {
            res = Math.max(res, 1);
            return 1;
        }
        if(size==1) {
            res = Math.max(res, 1 + list.get(0));
            return 1 + list.get(0);
        }
        res = Math.max(res, 1 + list.get(size-1) + list.get(size-2));
        return 1 + list.get(size-1);
    }

    public static void main(String[] args){
        int[][] edges =  new int[][]{{1, 2}, {1, 3}, {1, 4}, {4, 5}};

        int result = longestPathInN_AryTree(edges);
        System.out.println("result = " + result);
    }
}
