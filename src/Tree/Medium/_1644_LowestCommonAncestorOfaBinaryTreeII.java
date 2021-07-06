package Tree.Medium;

public class _1644_LowestCommonAncestorOfaBinaryTreeII {

    /*
    e.g. : p = 9, q = 25 (p, q are not gurantee in the tree, if either one is not exist, need to return null

                20
              /   \
             9     25
            / \    / \
           5   12 2   6
               /\
              11 14

output: 20
     */


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


    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        int mid = (root == p || root == q) ? 1 : 0;
        int left = dfs(root.left, p, q) ? 1 : 0;
        int right = dfs(root.right, p, q) ? 1 : 0;
        if (mid + left + right >= 2) {
            res = root;
        }
        return (mid + left + right) > 0;
    }

    /*
     //Iterative : Time = O(n) Space  = O(n)
      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
            if(q==null) break; //check this to prevent the infinite loop
        }
        return q;
    }
     */

}
