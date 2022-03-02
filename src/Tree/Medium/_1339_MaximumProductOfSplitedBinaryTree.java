package Tree.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1339_MaximumProductOfSplitedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //Two Pass
    //Time = O(n), Space = O(n)
    Map<TreeNode,Integer> sumMap = new HashMap<>();
    long maxRes = 0;
    int total = 0;
    int MOD = (int)1e9+7;
    public int maxProduct(TreeNode root) {
        sumSubtree(root);
        total = sumMap.get(root);
        dfs(root);
        return (int)(maxRes%MOD);
    }
    private int sumSubtree(TreeNode root){
        if(root==null) return 0;
        int total = root.val;
        if(root.left != null) total += sumSubtree(root.left);
        if(root.right != null) total += sumSubtree(root.right);
        sumMap.put(root, total);
        return total;
    }
    private void dfs(TreeNode root){
        if(root==null) return;
        int currTotal = sumMap.get(root);
        long currProd = (long)currTotal * (total-currTotal);
        maxRes = Math.max(maxRes, currProd);
        dfs(root.left);
        dfs(root.right);
    }
}
/*
Solution:
1) find the subtree's sum for each node, and store them into map
2) iterate second time for the tree, to find maximum product:
   max(res, current_total * (total-current_total) )
3) Hardest part of this question is figuring out where to modulo.
   But the question will be easier if we use long type to collect result,
   and use module and convert it to int type when return

 */
