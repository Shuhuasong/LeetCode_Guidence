package Tree.Medium;
import Tree.TreeNode;
/**
 * Created by Shuhua Song
 */
public class _663_EqualTreePartition {
    boolean ans = false;
    int total;
    public boolean checkEqualTree(TreeNode root) {
        total = getTotal(root);
        //if(total==0) return true;
        System.out.println(total%2);
        if(Math.abs(total)%2==1) return false;
        check(root, null);
        return ans;
    }

    private int getTotal(TreeNode root){
        if(root==null) return 0;
        return root.val+getTotal(root.left)+getTotal(root.right);
    }

    private int check(TreeNode root, TreeNode parent){
        if(root==null || ans) return 0;
        int left = check(root.left, root);
        int right = check(root.right, root);
        if(left+right+root.val==total/2 && parent!=null){
            ans = true;
        }
        return left+right+root.val;
    }
}
