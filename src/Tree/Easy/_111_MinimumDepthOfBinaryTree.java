package Tree.Easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _111_MinimumDepthOfBinaryTree {
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

    //BFS : only need to find the first level
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;
        q.add(root);
        while(!q.isEmpty()){
            depth++;
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left==null && node.right==null) return depth;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        return depth;
    }

    /* //DFS: need to traverse every node
    int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return getDepth(root);
    }

    private int getDepth(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int minDepth = Integer.MAX_VALUE;
        if(root.left != null){
            minDepth = Math.min(minDepth,getDepth(root.left));
        }
        if(root.right != null){
            minDepth = Math.min(minDepth, getDepth(root.right));
        }
        return minDepth+1;
    }
    */

}
