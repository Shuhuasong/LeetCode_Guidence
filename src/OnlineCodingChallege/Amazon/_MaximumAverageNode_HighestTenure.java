package OnlineCodingChallege.Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
/*
Given a tree, find the subtree with the maximum average value. Return the subtree's root's value.
Note that the tree could have an arbitrary number of children.
       1
      / \
     12  3
    / \  /
   7  9 -8

   output: 12
 */
public class _MaximumAverageNode_HighestTenure {
    public static class Node<T> {
        public T val;
        public List<Node<T>> children;

        public Node(T val) {
            this(val, new ArrayList<>());
        }

        public Node(T val, List<Node<T>> children) {
            this.val = val;
            this.children = children;
        }
    }
    float maxAve =  Float.MIN_VALUE;
    Node res = null;
    private Node findMaxAverage(Node<Integer> root){
        if(root==null) return null;
        dfs(root);
        return res;
    }

    private int[] dfs(Node<Integer> root){
        if(root==null) return new int[0];
        int sum = root.val, count = 1;
        for(Node<Integer> child : root.children){
            int[] curr = dfs(child);
            sum += curr[0];
            count += curr[1];
        }
        float avg = (float)sum/count;
        if(avg > maxAve){
            maxAve = avg;
            res = root;
        }
        return new int[]{sum, count};
    }
}
