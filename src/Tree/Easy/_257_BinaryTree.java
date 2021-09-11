package Tree.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _257_BinaryTree {

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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root, sb, results);
        return results;
    }
    //Note:
    //1)When using StringBuilder, we can just keep track of the length of the StringBuilder before we append anything to it.
    //before recursion and afterwards set the length back.
    //2) when append "->", we only append it before recurse to the next level of the tree.
    private void dfs(TreeNode root, StringBuilder sb, List<String> results){
        if(root==null) return;
        int len = sb.length();
        sb.append(root.val);
        if(root.left==null && root.right==null){
            results.add(sb.toString());
        }else{
            sb.append("->");
            dfs(root.left, sb, results);
            dfs(root.right, sb, results);
        }
        sb.setLength(len);
    }
}
