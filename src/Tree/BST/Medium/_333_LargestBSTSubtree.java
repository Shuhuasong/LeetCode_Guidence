package Tree.BST.Medium;

/**
 * Created by Shuhua Song
 */
public class _333_LargestBSTSubtree {

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

    class Item{
        int maxNode, minNode, maxSize;
        Item(int minNode, int maxNode, int maxSize){
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    //Time = O(N), Space = O(N)
    public int largestBSTSubtree(TreeNode root) {
        Item result = dfs(root);
        return result.maxSize;
    }

    private Item dfs(TreeNode root){
        if(root==null){
            return new Item(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        Item left = dfs(root.left);
        Item right = dfs(root.right);
        //the current node is a BST
        if(left.maxNode < root.val && root.val < right.minNode){
            return new Item(Math.min(root.val, left.minNode),
                    Math.max(root.val, right.maxNode),
                    left.maxSize + right.maxSize + 1);
        }
        return new Item(Integer.MIN_VALUE, Integer.MAX_VALUE,
                Math.max(left.maxSize, right.maxSize));
    }

    /*

        //Method #2: Time = O(N^2), Space = O(N)
    TreeNode prevNode;
    public int largestBSTSubtree(TreeNode root) {
         if(root==null) return 0;
        //if current subtree is a validBST, its children will have smaller size BST
         prevNode = null;
         if(isValidBST(root)){
             return countNodes(root);
         }
        //find BST in left and right subtree of current nodes
         return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));
    }

    private boolean isValidBST(TreeNode root){
        if(root==null) return true;
        if(!isValidBST(root.left)){
            return false;
        }
        if(prevNode != null && prevNode.val >= root.val){
            return false;
        }
        prevNode = root;
        return isValidBST(root.right);
    }


        private int countNodes(TreeNode root){
            if(root==null) return 0;
             return 1 + countNodes(root.left) + countNodes(root.right);
         }
}
     */


    /*
    //Method #1 : Time = O(N^3), Space = O(N)
    public int largestBSTSubtree(TreeNode root) {
         if(root==null) return 0;
        //if current subtree is a validBST, its children will have smaller size BST
         if(isValidBST(root)){
             return countNodes(root);
         }
        //find BST in left and right subtree of current nodes
         return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));
    }

    private boolean isValidBST(TreeNode root){
        if(root==null) return true;
        int leftMax = findMax(root.left);
        if(leftMax >= root.val) return false;
        int rightMin = findMin(root.right);
        if(rightMin <= root.val) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private int findMax(TreeNode root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.val, Math.max(findMax(root.left), findMax(root.right)));
    }

    private int findMin(TreeNode root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        return Math.min(root.val, Math.min(findMin(root.left), findMin(root.right)));
    }

    private int countNodes(TreeNode root){
        if(root==null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
     */
}
