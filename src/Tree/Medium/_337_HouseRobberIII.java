package Tree.Medium;

/**
 * Created by Shuhua Song
 */
public class _337_HouseRobberIII {

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
    //Recursion
    public int rob(TreeNode root) {
        if(root==null) return 0;
        //ans[0] = rob, ans[1] = notRob;
        int[] ans = getRob(root);
        return Math.max(ans[0], ans[1]);
    }
    public int[] getRob(TreeNode root){
        if(root==null) return new int[]{0, 0};
        int[] left = getRob(root.left);
        int[] right = getRob(root.right);
        //if we rob the curr node, we can't rob its children
        int rob = root.val +  left[1] + right[1];
        //we don't rob the curr node, we are free to rob its children or not
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, notRob};
    }

    //Recursion + memoization
    /*
     //Time = O(n) , Space = O(n)
    //Recursion with Memoization
    Map<TreeNode, Integer> robRes = new HashMap<>();
    Map<TreeNode, Integer> notRobRes = new HashMap<>();
    public int rob(TreeNode root) {
        return getRob(root, false);
    }

    public int getRob(TreeNode root, boolean robParent){
        if(root==null) return 0;
        if(robParent){
            if(robRes.containsKey(root)){
                return robRes.get(root);
            }
            int sum = getRob(root.left, false) + getRob(root.right, false);
            robRes.put(root, sum);
            return sum;
        }else{
            if(notRobRes.containsKey(root)){
                return notRobRes.get(root);
            }
            int rob = root.val + getRob(root.left, true) + getRob(root.right, true);
            int notRob = getRob(root.left, false) + getRob(root.right, false);
            int sum = Math.max(rob, notRob);
            notRobRes.put(root, sum);
            return sum;
        }
    }
     */
}
