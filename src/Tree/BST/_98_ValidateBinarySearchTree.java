package Tree.BST;

class TreeNode {
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

public class _98_ValidateBinarySearchTree {

 /*  public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
    public boolean isBST(TreeNode root, Integer low, Integer high){
        if(root==null) return true;
        int val = root.val;
        if(low != null && low >= root.val) return false;
        if(high != null && high <= root.val) return false;
        if(!isBST(root.left, low, val)) return false;
        if(!isBST(root.right, val, high)) return false;
        return true;
    }
  */

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode root, Integer low, Integer high){
        if(root==null) return true;
        if(low != null && low >= root.val || high != null && high <= root.val){
            return false;
        }
        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }

}
/*
Note: Not only the left child should be smaller than the node but all the elements on the left substree;
      Not only the right child should be larger than the node but all the elements on the right substree;
solution #1:
      Compare the current root node with its upper and lower limits
*/