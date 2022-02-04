package Tree.Medium;

public class _235_LowestCommonAncestorOfABinarySearchTree {

    /*
    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

e.g. : p = 9, q = 25

                20
              /   \
             9     25
            / \
           5   12
               /\
              11 14
output: 20
The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.
   */

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

    //Iterative: Time = O(n) Space = O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val, qVal = q.val;
        TreeNode node = root;
        while(node != null){
            if(pVal > node.val && qVal > node.val){
                node = node.right;
            }else if(pVal < node.val && qVal < node.val){
                node = node.left;
            }else{
                return node;
            }
        }
        return null;
    }

    //Recursion: Time = O(n) Space = O(n)
 /*   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
  */


 /*
  Map<TreeNode, TreeNode> parents;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         parents = new HashMap<>();
         findParent(root, null);
         Set<Integer> pSet = new HashSet<>();
         while(p != null){
             pSet.add(p.val);
             p = parents.get(p);
         }
         while(!pSet.contains(q.val)){
             q = parents.get(q);
         }
         return q;
    }

    private void findParent(TreeNode root, TreeNode parent){
        if(root==null) return;
        parents.put(root, parent);
        findParent(root.left, root);
        findParent(root.right, root);
    }
  */


}
