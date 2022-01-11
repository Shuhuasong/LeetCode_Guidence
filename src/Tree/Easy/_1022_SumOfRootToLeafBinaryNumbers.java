package Tree.Easy;

/**
 * Created by Shuhua Song
 */
public class _1022_SumOfRootToLeafBinaryNumbers {

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


    int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        if(root==null) return 0;
        preOrder(root, 0);
        return res;
    }

    private void preOrder(TreeNode root, int val){
        if(root==null) return;
        //shif val left one bit, and add the root.val at the end
        val = (val << 1) | root.val;
        if(root.left==null && root.right==null){
            res += val;
        }
        preOrder(root.left, val);
        preOrder(root.right, val);
    }

    /*
    int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        if(root==null) return 0;
        dfs(root, "");
        return res;
    }
    private void dfs(TreeNode root, String s){
        if(root==null) return;
        s = s+root.val;
        if(root.left==null && root.right==null){
            int n = s.length();
            int val = 0;
            for(int i=0; i<n; i++){
                if(s.charAt(i)=='1'){
                    val += Math.pow(2, n-i-1);
                }
            }
            res += val;
        }
        dfs(root.left, s);
        dfs(root.right, s);
    }
     */
}
