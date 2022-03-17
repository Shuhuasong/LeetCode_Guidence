package Tree.Easy;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _653_TwoSumIV_InputBST {

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

    //Time=O(n), Space = O(n)
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        return dfs(root, k);
    }

    private boolean dfs(TreeNode root, int k){
        if(root==null) return false;
        int comp = k-root.val;
        if(set.contains(comp)) return true;
        set.add(root.val);
        return dfs(root.left, k) || dfs(root.right, k);
    }

    /*

      //Time=O(n), Space = O(n)
    public boolean findTarget(TreeNode root, int k) {
       BSTIterator left = new BSTIterator(root, true);
       BSTIterator right = new BSTIterator(root, false);
       while(left.hasNext() && right.hasNext()){
           int l = left.peek(), r = right.peek();
           if(l >= r) return false;
           if(l+r == k) return true;
           else if(l+r < k) left.next();
           else
               right.next();
       }
        return false;
    }

    class BSTIterator{
        Stack<TreeNode> stack = new Stack<>();
        boolean forward;
        public BSTIterator(TreeNode root, boolean forward){
            this.stack = stack;
            this.forward = forward;
            if(forward) pushAllLeft(root);
            else
                pushAllRight(root);
        }
        public boolean hasNext(){
            return !stack.isEmpty();
        }
        public int next(){
            TreeNode node = stack.pop();
            if(forward) pushAllLeft(node.right);
            else pushAllRight(node.left);
            return node.val;
        }
        public void pushAllLeft(TreeNode root){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
        }
        public void pushAllRight(TreeNode root){
            while(root != null){
                stack.push(root);
                root = root.right;
            }
        }
        public int peek(){
            return stack.peek().val;
        }
    }

     */
}


/*
Solution-1:
Use list to collect all the nodes' val, and then use two pointer
to check if there are two nodes' val sum to to k
Solution-2:
Use Set
Solution-3: Use BSTIterator
Follow up: Time =O(n), Space = O(h)
Can we reduce the space from O(n) to O(h)

*/