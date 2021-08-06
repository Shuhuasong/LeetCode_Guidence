package Tree.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _113_PathSumII {
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
    // Time = O(n^2), O(n) = n/2 leaf node, for every leaf, perform O(n) to copy the list into results
    // Space = O(n)
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        if(root==null) return results;
        List<Integer> list = new ArrayList<Integer>();
        dfs(root, targetSum, list, results);
        return results;
    }

    public void dfs(TreeNode root, int remain, List<Integer> list, List<List<Integer>> results){
        if(root==null) return;
        //Add the current node to the curr list
        list.add(root.val);
        //check if the current node is a leaf and the remain==root.val
        //if yes, add the list into results
        if(remain==root.val && root.left==null && root.right==null){
            results.add(new ArrayList<>(list));
        }else{
            //else, we will recurse on the left and right children
            dfs(root.left, remain-root.val, list, results);
            dfs(root.right, remain-root.val, list, results);
        }
        //backtrack, pop the node we are have added
        list.remove(list.size()-1);
    }
}
