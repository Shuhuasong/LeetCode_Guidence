package Tree.Medium;

/**
 * Created by Shuhua Song
 */
public class _156_BinaryTreeUpsideDown {
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

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //If the root.left is null, then root.right is also null
        if(root==null || root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    /*
     public TreeNode upsideDownBinaryTree(TreeNode root) {
        //If the root.left is null, then root.right is also null
        if(root==null || root.left == null) return root;
        TreeNode rootLeft = root.left, rootRight = root.right;
        root.left=null;
        root.right=null;
        return upsideDown(rootLeft, root, rootRight);
    }

    private TreeNode upsideDown(TreeNode rootleft, TreeNode root, TreeNode rootright){
        if(rootleft==null) return root;
        TreeNode rootleftLeft = rootleft.left;
        TreeNode rootleftRight = rootleft.right;
        rootleft.left = rootright;
        rootleft.right = root;
        return upsideDown(rootleftLeft, rootleft, rootleftRight);
    }
     */
}

/*
X.Y.left = root.right
X.Y.rihgt = root;


1) when it only one node in the tree==> return root;
2) when there are 3 nodes === not possible
          (2, 1, 3) rootleft = 2; root=1; rootright=3;
          rootleft.left = rootright;
     1    rootleft.right = root;
    / \
   2   3

output:
     2
    / \
   3   1

3) when there are 5 nodes in the tree:

     2    after deal with nodes (1, 2, 3),
    / \   we use recursion to continue on nodes (3, 4, 5)
   3   1
  / \
 4   5
 */

