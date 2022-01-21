package Tree.Easy;

/**
 * Created by Shuhua Song
 */
public class _938_RangeSumOfBST {

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

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        return dfs(root, low, high);
    }
    //Pre-Order
    private int dfs(TreeNode root, int low, int high){
        if(root==null) return 0;
        int sum = 0;
        if(root.val >= low && root.val <= high){
            sum = root.val;
        }
        return sum + dfs(root.left, low, high) + dfs(root.right, low, high);
    }
}
