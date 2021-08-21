package Tree.Medium;

/**
 * Created by Shuhua Song
 */
public class _1339_MaximumProductOfSplitted {

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


    long maxRes = 0, sum = 0;
    public int maxProduct(TreeNode root) {
        int MOD = (int)1e9+7;
        if(root==null) return 0;
        this.sum = getSum(root);
        getMaxProduct(root);
        return (int)(maxRes%MOD);
    }

    private int getMaxProduct(TreeNode root){
        if(root==null) return 0;
        int leftSum = getMaxProduct(root.left);
        int rightSum = getMaxProduct(root.right);
        int subTreeSum = root.val + leftSum + rightSum;
        long curProduct = (long)subTreeSum * (sum-subTreeSum);
        maxRes = Math.max(maxRes, curProduct);
        return subTreeSum;
    }

    private int getSum(TreeNode root){
        if(root==null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }
}


/*
Note:
1. know there will be overflow in the calculation
2. We can use the long when there is an overflow
3. know where to use the module
*/

