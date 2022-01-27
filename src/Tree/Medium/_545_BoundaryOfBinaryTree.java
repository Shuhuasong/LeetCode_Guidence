package Tree.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _545_BoundaryOfBinaryTree {

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


    //Time = O(n), Space = O(n)
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root==null) return results;
        if(!isLeaf(root)) results.add(root.val);
        //walk through left most, and add the current node into res.
        //if there is no left child, move to right child when it exists
        //Note: need to check the node is not leaf node
        TreeNode t = root.left;
        while(t != null){
            if(!isLeaf(t)) results.add(t.val);
            if(t.left != null) t = t.left;
            else t = t.right;
        }
        //only get the leaf node
        getLeaves(root, results);
        //use a stack to reverse the results on the right side
        //if there is no right child, move the left child when it exists
        //Note: need to check the node is not leaf node
        Stack<Integer> stack = new Stack<>();
        t = root.right;
        while(t != null){
            if(!isLeaf(t)) stack.add(t.val);
            if(t.right != null) t = t.right;
            else
                t = t.left;
        }
        while(!stack.isEmpty()){
            results.add(stack.pop());
        }
        return results;
    }

    private boolean isLeaf(TreeNode node){
        return node.left==null && node.right==null;
    }

    private void getLeaves(TreeNode node, List<Integer> results){
        if(isLeaf(node)){
            results.add(node.val);
        }else{
            if(node.left != null) getLeaves(node.left, results);
            if(node.right != null) getLeaves(node.right, results);
        }
    }
}
