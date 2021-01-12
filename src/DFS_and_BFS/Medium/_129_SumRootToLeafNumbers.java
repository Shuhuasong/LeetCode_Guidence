package DFS_and_BFS.Medium;

import java.util.LinkedList;

public class _129_SumRootToLeafNumbers {

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
    //Recursive Preorder Traversal
    //Time = O(N) Space = O(H)
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return totalSum = 0;
        preOrder(root, 0);
        return totalSum;
    }

    private void preOrder(TreeNode root, int curSum){
        if(root!=null){
            curSum = curSum * 10 + root.val;
            if(root.left==null && root.right==null){
                totalSum += curSum;
            }
            preOrder(root.left, curSum);
            preOrder(root.right, curSum);
        }
    }

    //Iterative Preorder Traversal
    //Time = O(N)  Space = O(H)
 /*   int totalSum = 0, curSum = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            root = pair.getKey();
            curSum = pair.getValue();
            if(root!=null){
                curSum = curSum * 10 + root.val;
                if(root.left==null && root.right==null){
                    totalSum += curSum;
                }else{
                    queue.add(new Pair(root.left, curSum));
                    queue.add(new Pair(root.right, curSum));
                }
            }
        }
        return totalSum;
    }
  */
}
