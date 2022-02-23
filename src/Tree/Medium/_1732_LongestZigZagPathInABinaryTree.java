package Tree.Medium;

/**
 * Created by Shuhua Song
 */
public class _1732_LongestZigZagPathInABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int maxLen = 0;
    public int longestZigZag(TreeNode root) {
        if(root==null) return 0;
        longZig(root, 0, true);
        longZig(root, 0, false);
        return maxLen;
    }

    private void longZig(TreeNode root, int steps, boolean isLeft){
        if(root==null) return;
        maxLen = Math.max(maxLen, steps);
        if(isLeft){
            //keep going from current root to left
            longZig(root.left, steps+1, false);
            //restart the path from root to right
            longZig(root.right, 1, true);
        }else{
            //keep going from current root to right
            longZig(root.right, steps+1, true);
            //restart the path from root to left
            longZig(root.left, 1, false);
        }
    }
}
