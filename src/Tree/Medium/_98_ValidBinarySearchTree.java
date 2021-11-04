package Tree.Medium;

/**
 * Created by Shuhua Song
 */
public class _98_ValidBinarySearchTree {

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


    //Method #1:
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


    /*
      //Method #2: inorder recursive
    //Time = O(n) , Space = O(n)
    private Integer prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inOrder(root);
    }

    private boolean inOrder(TreeNode root){
        if(root==null) return true;
        if(!inOrder(root.left)){
            return false;
        }
        if(prev != null && root.val <= prev){
            return false;
        }
        prev = root.val;
        return inOrder(root.right);
    }
     */

    /*
    //Method #3: inorder Iterative
    //Time = O(n) , Space = O(n)
    public boolean isValidBST(TreeNode root) {
       if(root==null) return true;
       Deque<TreeNode> stack = new ArrayDeque<>();
       Integer prev = null;
       while(!stack.isEmpty() || root != null){
           while(root != null){
               stack.push(root);
               root = root.left;
           }
           root = stack.pop();
           //if next element in inOrder traversal
           //is smaller than the previous one, it is not BST
           if(prev != null && root.val <= prev){
               return false;
           }
           prev = root.val;
           root = root.right;
       }
       return true;
    }
     */
}
