package Tree.BST.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Tree.TreeNode;

/**
 * Created by Shuhua Song
 */
public class _538_ConvertBSTtoGreaaterTree {



    /*
     int currSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return root;
        int total = getSum(root);
        changeValue(root, total);
        return root;
    }

    private int getSum(TreeNode root){
        if(root==null) return 0;
        return getSum(root.left) + root.val + getSum(root.right);
    }

    private void changeValue(TreeNode root, int total){
        if(root==null) return;
        changeValue(root.left, total);
        currSum += root.val;
        root.val = root.val + (total-currSum);
        changeValue(root.right, total);
    }
     */

}
