package Tree.Medium;

//Time = O(n) Space = O(n)
public class _114_FlattenBinaryTreeToLinkedList {

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
        //if there is a left substree, we shuffle the connections around so that there is nothing on the left side
        if(leftLast!=null){
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        //check the rightLast first,this node will connect with root.right
        //Need to return the 'rightmost' node after we are done wiring the new connection
        return rightLast == null ? leftLast : rightLast;
    }

    /*
      //Iterative : Space Save
    //Time = O(n), Space = O(1)
    public void flatten(TreeNode root) {
        if(root==null) return;
        while(root != null){
            if(root.left != null){
               TreeNode rightMost = root.left;
               while(rightMost.right != null){
                    rightMost = rightMost.right;
                }

                rightMost.right = root.right;
                root.right= root.left;
                root.left = null;
           }
           root = root.right;
       }
    }
     */
}
