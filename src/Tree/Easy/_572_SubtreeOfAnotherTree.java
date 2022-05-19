package Tree.Easy;
import Tree.TreeNode;

/**
 * Created by Shuhua Song
 */
public class _572_SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(isSame(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode r1, TreeNode r2){
        if(r1==null && r2==null) return true;
        if(r1==null || r2==null) return false;
        if(r1.val != r2.val) return false;
        return isSame(r1.left, r2.left) && isSame(r1.right, r2.right);
    }
}

/*
Solution:
for each node during pre-Order traversal of root, use a recursive function
isSame to validate if sub-tree started with this node is the same with subRoot;
*/
