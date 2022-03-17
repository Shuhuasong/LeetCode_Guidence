package Tree.Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _1214_TwoSumBSTs {

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

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        dfs(root1, set1); dfs(root2, set2);
        for(int key : set1){
            int comp = target-key;
            if(set2.contains(comp)) return true;
        }
        return false;
    }
    private void dfs(TreeNode root, Set<Integer> set){
        if(root==null) return;
        dfs(root.left, set);
        set.add(root.val);
        dfs(root.right, set);
    }
}
