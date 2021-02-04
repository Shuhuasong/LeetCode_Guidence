package Tree.Medium;

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

//Time = O(n) Space = O(n)
public class _114_FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root){
        if(root==null){
            return null;
        }
        //for a leave node, simply return the node;
        if(root.left==null && root.right==null){
            return root;
        }
        TreeNode leftLast = dfs(root.left); //Recursively flatten the left substree
        TreeNode rightLast = dfs(root.right);//Recursively flatten the right substree
        //if there is a left substree, we shuffle the connections around so that there is noting on the left side
        if(leftLast!=null){
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        //Need to return the 'rightmost' node after we are done wiring the new connection
        return rightLast == null ? leftLast : rightLast;
    }
}
