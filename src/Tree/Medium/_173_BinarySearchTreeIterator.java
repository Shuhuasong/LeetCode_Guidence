package Tree.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _173_BinarySearchTreeIterator {
    /*
    when implementing a class, it's important to also note the time it takes to initialize
    a new object of the class
     */
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

    List<Integer> list;
    int index = 0;
    public _173_BinarySearchTreeIterator(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
    }
    //Time = O(n)
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public int next() {
        if(index < list.size()){
            int val = list.get(index);
            index++;
            return val;
        }
        return -1;
    }

    public boolean hasNext() {
        return index < list.size();
    }

    /*
    //Iterate

     Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
       stack = new Stack<>();
       addLeftMost(root);
    }
    //Time = O(n)
    private void addLeftMost(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    //pop = O(n)
    //call recursive function = O(n), which iterate a bunch of nodes.
    //but the number of node is less than N nodes. If we have a skewed tree, the worst case is N nodes
    public int next() {
        TreeNode topNode = stack.pop();
        if(topNode.right != null){
            addLeftMost(topNode.right);
        }
        return topNode.val;
    }
    //Time = O(1)
    public boolean hasNext() {
        return stack.size() > 0;
    }
     */
}
