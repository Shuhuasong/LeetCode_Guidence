package Tree.Easy;
import Tree.TreeNode;
/**
 * Created by Shuhua Song
 */
public class _110_BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int leftH = height(root.left);
        int rightH = height(root.right);
        return (Math.abs(leftH-rightH) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root){
        if(root==null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left, right)+1;
    }
}
