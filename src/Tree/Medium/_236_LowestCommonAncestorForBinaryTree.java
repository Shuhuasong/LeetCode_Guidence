package Tree.Medium;


import java.util.*;

public class _236_LowestCommonAncestorForBinaryTree {
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


    TreeNode result;
    public _236_LowestCommonAncestorForBinaryTree(){
        result = null;
    }
   // Solution #1 : recursive
    // Time = O(n) Space = O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return false;
        int mid = (root==p || root==q) ? 1 : 0;
        int leftSide = dfs(root.left, p, q) ? 1 : 0;
        int rightSide = dfs(root.right, p, q) ? 1 : 0;
        if(mid+leftSide+rightSide >= 2){
            result = root;
        }
        return mid+leftSide+rightSide > 0;
    }


    /* Solution #2 :  preOrder traversal
      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
       if(root==null || root==p || root==q) return root;
       TreeNode left = dfs(root.left, p, q);
       TreeNode right = dfs(root.right, p, q);
       if(left!=null && right!=null) return root;
       return left==null ? right : left;
    }
     */

    //Solution #3: Iterative with parent pointer
    // Time = O(n) Space = O(n)
   /* public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.remove();
            if(curNode.left != null){
                parents.put(curNode.left, curNode);
                queue.add(curNode.left);
            }
            if(curNode.right != null){
                parents.put(curNode.right, curNode);
                queue.add(curNode.right);
            }
        }

        Set<TreeNode> ancesters = new HashSet<>();
        while(p!=null){
            ancesters.add(p);
            p = parents.get(p);
        }
        while(!ancesters.contains(q)){
            q = parents.get(q);
        }
        return q;
    }

    */


}
