package Tree.BST;

public class _285_InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null || p==null) return null;
        TreeNode successor = null;
        while(root!=null){
            if(root.val <= p.val){
                root = root.right;
            }else{
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
