package Tree.Easy;

import javax.swing.tree.TreeNode;

public class _543_DiameterOfBinaryTree {

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

        /*   int max = 0;
           public int diameterOfBinaryTree(TreeNode root) {
               if(root==null){
                   return 0;
               }
               int leftSide = longestPath(root.left);
               int rightSide = longestPath(root.right);
               return Math.max(max, leftSide+rightSide);
           }

           private int longestPath(TreeNode root){
               if(root==null) return 0;
               int left = longestPath(root.left);
               int right = longestPath(root.right);
               max = Math.max(max, left+right);
               return Math.max(left+1, right+1);
           }
         */
        int max;

        public int diameterOfBinaryTree(TreeNode root) {
            max = 0;
            height(root);
            return max;
        }

        private int height(TreeNode node) {
            if (node == null) return 0;
            int L = height(node.left);
            int R = height(node.right);
            max = Math.max(max, L + R);
            return Math.max(L, R) + 1;
        }
    }
}

/*
idea: If we knew the maximum length(L & R) in left and right direction for each child,
then the best path is: L + R + 1
Algorithm:
--Calculate the depth of a node in the usual way: max(depthLeft, depthRight) + 1
--when a path throutgh current node, it is : 1 + (depthLeft) + depthRight
--search each node and remember the highest number of nodes used in some path
 */