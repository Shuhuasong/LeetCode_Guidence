package Tree.BST.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _1110_DeleteNodesAndReturnForest {

    class TreeNode {
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

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> results = new ArrayList<>();
        if(root==null) return results;
        HashSet<Integer> deletes = new HashSet<>();
        for(int d : to_delete) deletes.add(d);

        dfs(root, deletes, results);
        if(!deletes.contains(root.val)){
            results.add(root);
        }
        return results;
    }

    private TreeNode dfs(TreeNode root, HashSet<Integer> set, List<TreeNode> results){
        if(root==null) return null;
        root.left = dfs(root.left, set, results);
        root.right = dfs(root.right, set, results);
        if(set.contains(root.val)){
            if(root.left !=  null){
                results.add(root.left);
            }
            if(root.right != null){
                results.add(root.right);
            }
            return null;
        }

        return root;
    }
}
