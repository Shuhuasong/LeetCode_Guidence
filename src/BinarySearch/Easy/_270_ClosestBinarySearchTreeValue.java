package BinarySearch.Easy;

/**
 * Created by Shuhua Song
 */
public class _270_ClosestBinarySearchTreeValue {

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

    //Time = O(H)
    public int closestValue(TreeNode root, double target) {
        int nearNum = 0;
        double minDiff = Double.MAX_VALUE;
        while(root!=null){
            double currDiff = Math.abs(root.val-target);
            if(currDiff < minDiff){
                nearNum = root.val;
                minDiff = currDiff;
            }
            root = (root.val > target) ? root.left : root.right;
        }
        return nearNum;
    }

    /*
    //Time = O(n)
     int resVal;
    double minDiff;
    public int closestValue(TreeNode root, double target) {
        resVal = -1;
        minDiff = Double.MAX_VALUE;
        dfs(root, target);
        return resVal;
    }

    private void dfs(TreeNode root, double target){
        if(root==null) return;
        double currDiff = Math.abs(target-(double)root.val);
        if(currDiff < minDiff){
            resVal = root.val;
            minDiff = currDiff;
            System.out.println(currDiff + " == " + resVal);
        }
        dfs(root.left, target);
        dfs(root.right, target);
    }
     */
}
