package Tree.Easy;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _404_SumOfLeftLeaves {

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
    //Iterative
    //Time = O(n), Space = O(n)
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null && node.left.left==null && node.left.right==null){
                res += node.left.val;
            }
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return res;
    }

    /*
      //Time = O(n), Space = O(n)
    //In the worst case, the tree consist of nodes that form a single deep
    //linked list. In this case, the runtime-stack will have N calls to getLeftLeaf()
    public int sumOfLeftLeaves(TreeNode root) {
         return getLeftLeaf(root, false);
    }
    private int getLeftLeaf(TreeNode root, boolean isLeft){
        if(root==null) return 0;
        if(root.left == null && root.right==null){
            return isLeft ? root.val : 0;
        }
        return getLeftLeaf(root.left, true) + getLeftLeaf(root.right, false);
    }
     */
}
