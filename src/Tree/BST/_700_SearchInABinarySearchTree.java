package Tree.BST;

/**
 * Created by Shuhua Song
 */
public class _700_SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null){
            if(root.val==val) return root;
            if(root.val < val) root = root.right;
            else{
                root = root.left;
            }
        }
        return null;
    }

    /*
     public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(root.val==val){
             return root;
        }
        if(root.val < val) return searchBST(root.right, val);
        return searchBST(root.left, val);
    }
     */
}
