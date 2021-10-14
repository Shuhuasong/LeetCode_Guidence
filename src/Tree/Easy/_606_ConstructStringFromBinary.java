package Tree.Easy;

/**
 * Created by Shuhua Song
 */
public class _606_ConstructStringFromBinary {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public String tree2str(TreeNode t) {
        if(t==null) return "";
        String s = t.val+"";

        if(t.left != null){
            s = s + "(" + tree2str(t.left) + ")";
        }

        if(t.left==null && t.right!=null){
            s = s +"()" + "(" + tree2str(t.right) + ")";
        }else if(t.right != null){
            s = s + "(" + tree2str(t.right) + ")";
        }

        return s;
    }
}
