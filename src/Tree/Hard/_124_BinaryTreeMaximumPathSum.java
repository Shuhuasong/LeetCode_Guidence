package Tree.Hard;
import Tree.TreeNode;
/**
 * Created by Shuhua Song
 */
public class _124_BinaryTreeMaximumPathSum {
    int maxRes = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxSum(root);
        return maxRes;
    }
    private int maxSum(TreeNode root){
        if(root==null) return 0;
        int left = Math.max(0, maxSum(root.left));
        int right = Math.max(0, maxSum(root.right));
        maxRes = Math.max(maxRes, left+right+root.val);
        return Math.max(left, right) + root.val;
    }
}
