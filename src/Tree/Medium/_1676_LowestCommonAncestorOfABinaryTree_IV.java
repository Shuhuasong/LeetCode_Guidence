package Tree.Medium;
import  Tree.TreeNode;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _1676_LowestCommonAncestorOfABinaryTree_IV {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> set = new HashSet<>();
        for(TreeNode node : nodes) set.add(node.val);
        return dfs(root, set);
    }

    private TreeNode dfs(TreeNode root, Set<Integer> set){
        if(root==null || set.contains(root.val)) return root;
        TreeNode left = dfs(root.left, set);
        TreeNode right = dfs(root.right, set);
        System.out.println("root = " + root.val);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
}
