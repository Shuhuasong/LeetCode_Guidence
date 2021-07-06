package Tree.Medium;

public class _222_CountCompleteTreeNodes {

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

    public int countNodes(TreeNode root) {
        // if the tree is empty
        if (root == null) return 0;

        int d = getDepth(root);
        // if the tree contains 1 node
        if (d == 0) return 1;

        // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        // Perform binary search to check how many nodes exist.
        int left = 1, right = (int)Math.pow(2, d) - 1;
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (exist(pivot, d, root)) left = pivot + 1;
            else right = pivot - 1;
        }

        // The tree contains 2**d - 1 nodes on the first (d - 1) levels
        // and left nodes on the last level.
        return (int)Math.pow(2, d) - 1 + left;
    }
    // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
    // Return True if last level node idx exists.
    // Binary search with O(d) complexity.
    private boolean exist(int target, int d, TreeNode node){
        int left = 0, right = (int)Math.pow(2, d) - 1;
        int pivot = 0;
        //move the pointer from root to leaf d steps, and see with part it will be in
        for(int i=0; i<d; i++){
            pivot = left + (right-left)/2;
            if(pivot >= target){
                node = node.left;
                right = pivot;
            }else{
                node = node.right;
                left = pivot;
            }
        }
        return node != null;
    }

    // Return tree depth in O(d) time.
    private int getDepth(TreeNode root){
        int d = 0;
        while(root.left != null){
            d++;
            root = root.left;
        }
        return d;
    }
}
