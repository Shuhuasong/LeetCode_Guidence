package Tree.Medium;

/**
 * Created by Shuhua Song
 */
public class _298_BinaryTreeLongestConsecutiveSequence {

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

    //Top Down : It is similar with in-order or pre-order traversal
    //use a variable dist to store the lenght
    //and pass it down to the tree
    //Time = O(n), Space = O(n)
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if(root==null) return 0;
        dfs(root, null, 0);
        return res;
    }

    private void dfs(TreeNode root, TreeNode parent, int dist){
        if(root==null) return;
        int len = (parent != null && root.val==parent.val+1) ?  dist+1 : 1;
        res = Math.max(res, len);
        dfs(root.left, root, len);
        dfs(root.right, root, len);
    }

    /*
     //Bottom-Up Depth first Search : It is similar with post-order traversal
    //we return the consecutive path length starting at current node to its parent
    //use a variable dist to store the lenght
    //and pass it down to the tree
    //Time = O(n), Space = O(n)
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root){
        if(root==null) return 0;
        int L = dfs(root.left) + 1;
        int R = dfs(root.right) + 1;
        if(root.left != null && root.val+1 !=root.left.val){
            L = 1;
        }
        if(root.right != null && root.val+1 !=root.right.val){
            R = 1;
        }
        int len = Math.max(L, R);
        res = Math.max(res, len);
        return len;
    }
     */
}
