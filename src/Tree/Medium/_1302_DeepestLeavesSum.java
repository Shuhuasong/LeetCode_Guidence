package Tree.Medium;
import Tree.TreeNode;
/**
 * Created by Shuhua Song
 */
public class _1302_DeepestLeavesSum {
    int maxDepth = 0;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        getDepth(root);
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int deep){
        if(root==null) return;
        if(deep==maxDepth) sum += root.val;
        dfs(root.left, deep+1);
        dfs(root.right, deep+1);
    }

    private int getDepth(TreeNode root){
        if(root==null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        maxDepth = Math.max(maxDepth, Math.max(left, right));
        return Math.max(left, right)+1;
    }
}
