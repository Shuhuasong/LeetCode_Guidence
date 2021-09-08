package Tree.Easy;

/**
 * Created by Shuhua Song
 */
public class _617_MergeTwoBinaryTrees {

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


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;
        return merge(root1, root2);
    }

    private TreeNode merge(TreeNode root1, TreeNode root2){
        if(root1==null) return root2;
        if(root2==null) return root1;
        // if(root1==null && root2==null) return null;
        TreeNode newRoot = null;
        if(root1 != null) newRoot = new TreeNode(root1.val);
        if(root2 != null) newRoot = new TreeNode(newRoot.val + root2.val);

        newRoot.left = merge(root1.left, root2.left);
        newRoot.right = merge(root1.right, root2.right);
        return newRoot;
    }
}
