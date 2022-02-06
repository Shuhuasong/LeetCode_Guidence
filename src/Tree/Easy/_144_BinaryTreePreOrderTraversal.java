package Tree.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _144_BinaryTreePreOrderTraversal {

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

    //Iterate
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            res.add(node.val);
            if(node.right != null) stack.add(node.right);
            if(node.left != null) stack.add(node.left);
        }
        return res;
    }
    /*
     public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }
    private void preOrder(TreeNode root, List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
     */
}
