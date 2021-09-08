package Tree.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _199_BinaryTreeRightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root==null) return results;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        results.add(root.val);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.remove();
                if(curr.right != null) q.add(curr.right);
                if(curr.left != null) q.add(curr.left);

            }
            if(!q.isEmpty()){
                results.add(q.peek().val);
            }
        }
        return results;
    }
}
