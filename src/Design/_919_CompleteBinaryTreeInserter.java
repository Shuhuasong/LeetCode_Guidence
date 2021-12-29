package Design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _919_CompleteBinaryTreeInserter {

    class TreeNode {
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

    //Solution - 1: insert = O(n), use BFS in the insert funciton

    //Solution - 2: BuildTree Time = O(n), insert = O(1)

    TreeNode root;
    Queue<TreeNode> q = new LinkedList<>();
    public _919_CompleteBinaryTreeInserter(TreeNode root) {
        this.root = root;
        q.add(root);
        while(q.peek().right != null){ //the node has two child
            q.add(q.peek().left);
            q.add(q.peek().right);
            q.poll();
        }
    }

    public int insert(int val) {
        TreeNode node = q.peek(); //don't poll() here
        if(node.left==null){
            node.left = new TreeNode(val);
        }else{
            node.right = new TreeNode(val);
            q.add(node.left);
            q.add(node.right);
            q.poll();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }

    /*
     //Solution - 1: insert = O(n), use BFS in the insert funciton

    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int val) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.add(node.left);
            }else{
                node.left = new TreeNode(val);
                return node.val;
            }

            if(node.right!=null){
                q.add(node.right);
            }else{
                node.right = new TreeNode(val);
                return node.val;
            }
        }
        return 0;
    }

    public TreeNode get_root() {
        return root;
    }
     */
}
