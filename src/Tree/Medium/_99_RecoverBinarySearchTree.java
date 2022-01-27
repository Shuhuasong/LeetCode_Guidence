package Tree.Medium;

/**
 * Created by Shuhua Song
 */
public class _99_RecoverBinarySearchTree {

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

    //InOrder traversal
    TreeNode first = null, second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        findNode(root);
        swap(first, second);
    }


    private void findNode(TreeNode root){
        if(root==null) return;
        //prev = 3
        findNode(root.left);
        //find invalid node
        if(prev != null && root.val < prev.val){
            second = root; //second = 1
            if(first==null) first = prev; //first = 3
            else
                return; //already found the first node
        }
        prev = root;
        findNode(root.right);
    }

    private void swap(TreeNode x, TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    /*
     //Iterative: Time = O(n), Space = O(n)
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, prev = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(prev != null && prev.val > root.val){
                second = root;
                if(first==null) first = prev;
                else
                    break;
            }
            prev = root;
            root = root.right;
        }
        swap(first, second);
    }

    private void swap(TreeNode x, TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
     */
}
