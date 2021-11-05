package Tree.Medium;

/**
 * Created by Shuhua Song
 */
public class _230_KthSmallestElementInaBST {


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

    //Recursive
    //Time =
    int res = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        inOrder(root, k);
        return res;
    }
    private void inOrder(TreeNode root, int k){
        if(root==null) return;
        inOrder(root.left, k);
        count++;
        if(count==k){
            res = root.val;
        }
        if(count < k){
            inOrder(root.right, k);
        }
    }

    /*
     //Iterative
    //Time = (h+k) worst case, Space = O(n)
    public int kthSmallest(TreeNode root, int k) {
          if(root==null) return -1;
          Stack<TreeNode> stack = new Stack<>();
          while(true){
              while(root != null){
                  stack.push(root);
                  root = root.left;
              }
              root = stack.pop();
              k--;
              if(k==0) return root.val;
              root = root.right;
          }
        // return -1;
    }
     */
}
