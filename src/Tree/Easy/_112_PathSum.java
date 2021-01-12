package Tree.Easy;

public class _112_PathSum {

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

    //Recursive: Time = O(N) Space = O(N) when it is unbalance tree or O(logN)
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.val == sum && root.left==null && root.right==null) return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

    /*
     //Iterative: Time = O(N) Space = O(N) when it is unbalance tree or O(logN)
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer>  sumQ = new LinkedList<>();
        nodeQ.add(root);
        sumQ.add(sum-root.val);
        TreeNode node = null;
        int curSum = 0;
        while(!nodeQ.isEmpty()){
            node = nodeQ.poll();
            curSum = sumQ.poll();
            if(node.left==null && node.right==null && curSum==0){
                return true;
            }
            if(node.left!=null){
                nodeQ.add(node.left);
                sumQ.add(curSum-node.left.val);
            }
            if(node.right!=null){
                nodeQ.add(node.right);
                sumQ.add(curSum-node.right.val);
            }
        }
        return false;
    }
     */
}
