package Tree.Medium;

/**
 * Created by Shuhua Song
 */
public class _1120_MaximumAverageSubtree {

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


    double res = Double.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        if(root==null) return 0;
        getMax(root);
        return res;
    }

    private double[] getMax(TreeNode root){
        if(root==null) return new double[]{0, 0};
        double total = root.val;
        double count = 1;
        double[] left = getMax(root.left);
        double[] right = getMax(root.right);
        total += left[0] + right[0];
        count += left[1] + right[1];
        double avg = total/count;
        res = Math.max(res, avg);
        return new double[]{total, count};
    }
}
