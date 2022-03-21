package Tree.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

    //Iterate-1
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root==null) return results;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            results.add(root.val);
            //need to push the right node first, so left is pop first,
            //the make final order is : root->left->right
            if(root.right!=null) stack.push(root.right);
            if(root.left!=null) stack.push(root.left);
        }
        return results;
    }

    /* Iterative-2
     public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root==null) return results;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                //First, go from root to leftMost until null
                results.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }else{
                //After reach leftMost, go back parent node, and
                //go right
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return results;
    }
     */


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
