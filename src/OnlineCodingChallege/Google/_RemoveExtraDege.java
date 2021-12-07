package OnlineCodingChallege.Google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
/*
 Given a binary tree, where an arbitary node has 2 parents i.e two nodes in the tree have the same child. Identify the defective node and remove an extra edge to fix the tree.

Example:

Input:
	   1
	  / \
	 2   3
	/ \ /
   4   5

Output:

     1			       1
    / \			      / \
   2   3    or	     2   3
  / \ 			    /   /
 4   5		       4   5

Explanation: We can remove either 3-5 or 2-5.
Follow-up 1:
What if the tree is a BST?

Example:

Input:
       3
	  / \
	 2   5
	/ \ /
   1   4

Output:
       3
	  / \
	 2   5
	/   /
   1   4

Explanation: In this case we can only remove 2-4 because if we remove 5-4 the BST will be invalid.
Hint
Solution
Follow-up 2:
What if the tree is an N-ary tree?
 */
public class _RemoveExtraDege {
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

    public TreeNode removeExtraNode(TreeNode root){
        if(root==null) return root;
        Set<TreeNode> seen = new HashSet<>();;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node != null){
                if(node.left != null){
                    q.add(node.left);
                    if(seen.contains(node.left))
                        node.left = null;
                    else
                        q.add(node.left);
                }
                if(node.right != null)
                    if(seen.contains(node.right))
                        node.right = null;
                    else
                        q.add(node.right);
                }
        }
        return root;
     }

}
