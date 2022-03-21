package Tree.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _145_BinaryTreePostOrderTraversal {
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

    //Iteration
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> resStack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){
            //root-->right-->left
            if(curr!=null){
                resStack.push(curr); //root
                stack.push(curr);
                curr = curr.right;   //right
            }else{
                curr = stack.pop();
                curr = curr.left;    //left
            }
        }
        //results: left-->right-->root
        while(!resStack.isEmpty()) res.add(resStack.pop().val);
        return res;
    }

   /*  recursion
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res){
        if(root==null) return;
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }

    */
}
