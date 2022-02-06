package Tree.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _94_BinaryTreeInOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root==null) return results;
        inOrder(root, results);
        return results;
    }

    private void inOrder(TreeNode root, List<Integer> results){
        if(root==null) return;
        inOrder(root.left, results);
        results.add(root.val);
        inOrder(root.right, results);
    }

    /* iterative
     public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root==null) return results;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            results.add(root.val);
            root = root.right;
        }
        return results;
    }
     */
}
