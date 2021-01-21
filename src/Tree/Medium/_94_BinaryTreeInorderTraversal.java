package Tree.Medium;

import java.util.ArrayList;
import java.util.List;

public class _94_BinaryTreeInorderTraversal {


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

    //Recursion
    //Time = O(n) Space = O(log n)--O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root==null) return results;
        inorder(root, results);
        return results;
    }

    private void inorder(TreeNode root, List<Integer> results){
        if(root==null) return;
        inorder(root.left, results);
        results.add(root.val);
        inorder(root.right, results);
    }

    //Iteration
    /*
     //Time = O(n) Space = O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root==null) return results;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            results.add(curr.val);
            curr = curr.right;
        }
        return results;
    }
     */
}
