package Tree.Medium;

import Tree.Easy._112_PathSum;

public class _687_LongestUnivaluePath {

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


    int maxLen = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        getLongestPath(root);
        return maxLen;
    }

    private int getLongestPath(TreeNode root){
        if(root==null) return 0;
        int leftLen = getLongestPath(root.left);  //the length of the longest arrow that extends from the root.left
        int rightLen = getLongestPath(root.right);
        int maxLeft = 0, maxRight = 0;
        if(root.left!=null && root.val==root.left.val){
            maxLeft += leftLen + 1;
        }
        if(root.right!=null && root.val==root.right.val){
            maxRight += rightLen + 1;
        }
        maxLen = Math.max(maxLen, maxLeft+maxRight);
        return Math.max(maxLeft, maxRight);
    }
}
