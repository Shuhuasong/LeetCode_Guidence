package Tree.Medium;

import java.util.ArrayList;
import java.util.List;

public class _95_UniqueBinarySearchTreesII {

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
  //Recursiont
    public List<TreeNode> generateTrees(int n) {

        if(n==0){
            return new ArrayList<>();
        }
        return buildTree(1, n);
    }

    private List<TreeNode> buildTree(int start, int end){
        List<TreeNode> results = new ArrayList<>();
        if(start > end){
            results.add(null);
            return results;
        }
        for(int i=start; i<=end; i++){
            List<TreeNode> leftTrees = buildTree(start, i-1);
            List<TreeNode> rightTrees = buildTree(i+1, end);
            for(TreeNode l : leftTrees){
                for(TreeNode r : rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    results.add(root);
                }
            }
        }
        return results;
    }
}
