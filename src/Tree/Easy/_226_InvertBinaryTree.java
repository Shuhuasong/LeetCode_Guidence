package Tree.Easy;

/**
 * Created by Shuhua Song
 */
public class _226_InvertBinaryTree {

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


    //Time = O(n), Space = O(h)
    //O(h) function calls will be placed on the stack
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /*
     //Time = O(n), Space = O(h)
    //O(h) function calls will be placed on the stack
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }
        return root;
    }
    //solve the problem iteratively, in a manner similar to BFS
     */
}
