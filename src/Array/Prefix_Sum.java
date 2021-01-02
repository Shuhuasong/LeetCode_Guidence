package Array;

import java.util.HashMap;

public class Prefix_Sum {

    /*
Queuestion: find how many continuos subarrays whose sum is equal  to target?
 */
    public int subarraySum(int[] nums, int k) {
        int count = 0, currSum = 0;
        HashMap<Integer, Integer> h = new HashMap();

        for (int num : nums) {
            // current prefix sum
            currSum += num;

            // situation 1:
            // continuous subarray starts
            // from the beginning of the array
            if (currSum == k)
                count++;

            // situation 2:
            // number of times the curr_sum − k has occured already,
            // determines the number of times a subarray with sum k
            // has occured upto the current index
            count += h.getOrDefault(currSum - k, 0);

            // add the current sum
            h.put(currSum, h.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }



    /*
    Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
     */
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    int count = 0;
    int k;
    HashMap<Integer, Integer> h = new HashMap();

    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
    }

    public void preorder(TreeNode node, int currSum) {
        if (node == null)
            return;

        // current prefix sum
        currSum += node.val;

        // here is the sum we're looking for
        if (currSum == k)
            count++;

        // number of times the curr_sum − k has occured already,
        // determines the number of times a path with sum k
        // has occured upto the current node
        count += h.getOrDefault(currSum - k, 0);

        // add the current sum into hashmap
        // to use it during the child nodes processing
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);

        // process left subtree
        preorder(node.left, currSum);
        // process right subtree
        preorder(node.right, currSum);

        // remove the current sum from the hashmap
        // in order not to use it during
        // the parallel subtree processing
        h.put(currSum, h.get(currSum) - 1);
    }
}
