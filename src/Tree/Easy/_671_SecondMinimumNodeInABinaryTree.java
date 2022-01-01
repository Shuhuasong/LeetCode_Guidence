package Tree.Easy;

/**
 * Created by Shuhua Song
 */
public class _671_SecondMinimumNodeInABinaryTree {

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

    int min = Integer.MAX_VALUE;
    long second = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        min = root.val;
        find(root);
        if(second < Long.MAX_VALUE) return (int)second;
        return -1;
    }

    private void find(TreeNode root){
        if(root==null) return;
        if(root.val > min){
            second = Math.min(second, root.val);
        }

        find(root.left);
        find(root.right);
    }
}
