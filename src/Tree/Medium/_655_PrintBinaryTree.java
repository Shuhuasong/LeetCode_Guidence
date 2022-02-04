package Tree.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _655_PrintBinaryTree {

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

    /*  Note:
   1) the height of an empty tree is -1, the height of one node is 0
   */
    List<List<String>> results;
    int ht;
    public List<List<String>> printTree(TreeNode root) {
        ht = getHeight(root);
        int rows = ht+1, cols = (int)Math.pow(2, ht+1)-1;
        results = new ArrayList<>();
        for(int i=0; i<rows; i++){
            List<String> row = new ArrayList<>();
            for(int j=0; j<cols; j++){
                row.add("");
            }
            results.add(row);
        }
        int rootR = 0, rootC = (cols-1)/2;
        preOrder(root, rootR, rootC);
        return results;
    }

    private void preOrder(TreeNode root, int r, int c){
        if(root==null) return;
        List<String> currList = results.get(r);
        currList.set(c, root.val+"");
        results.set(r, currList);
        int leftC = c-(int)Math.pow(2, ht-r-1);
        int rightC = c+(int)Math.pow(2, ht-r-1);
        if(root.left != null) preOrder(root.left, r+1, leftC);
        if(root.right != null) preOrder(root.right, r+1, rightC);
    }

    private int getHeight(TreeNode root){
        if(root==null) return -1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}
