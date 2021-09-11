package Tree.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _437_PathSumIII {

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
    Map<Integer, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        dfs(root, 0, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int sum, int target){
        if(root==null) return;
        sum += root.val;
        if(sum==target) res++;
        //number of times (sum-target) has occurred already,
        //it means the number of times a path with sum target
        //has occured upto the current node
        if(map.containsKey(sum-target)){
            res += map.get(sum-target);
        }
        //Add the currrent sum into hashmap
        //to use it during the child nodes processing
        map.put(sum, map.getOrDefault(sum, 0)+1);
        dfs(root.left, sum, target);
        dfs(root.right, sum, target);
        //Now the current subtree is processed. It's time to remove the current prefix sum
        //from the hashmap, in order not to blend the parallel subtrees
        map.put(sum, map.getOrDefault(sum, 0)-1);
    }
}

/*
idea come from --- Array prefix Sum
e.g.  nums = {3, 4, 1, 6, -3}  target sum k = 7
                       14      because 14-7=7, which is already in the map, so the target has occur
 preSum occurrence frequency:
{{3, 1}, {7, 1}, {8, 1}, {14, 1}, {11, 1}};

So, when updat the count, we need to consider two situation:
1) when preSum = k ==> count++ (the preSum start from root)
2) when (preSum-k) has in the map, then we need to add freq of (preSum-k) from map,
   ===> the tree path with target sum starts somewhere downwards
 */
