package Tree.Easy;
import Tree.TreeNode;
/**
 * Created by Shuhua Song
 */
public class _897_IncreasingOrderSearchTree {
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        curr = dummy;
        inOrder(root);
        return dummy.right;
    }

    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        curr.right = root;
        curr = root;
        root.left = null;
        inOrder(root.right);
    }
}
