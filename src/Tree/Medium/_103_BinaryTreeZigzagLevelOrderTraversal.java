package Tree.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Shuhua Song
 */
public class _103_BinaryTreeZigzagLevelOrderTraversal {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root==null) return results;
        Queue<TreeNode> q = new LinkedList<>();
        boolean isEven = false;
        q.add(root);
        while(!q.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(isEven)
                    list.addFirst(node.val);
                else
                    list.addLast(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            results.add(list);
            isEven = !isEven;
        }
        return results;
    }
}
