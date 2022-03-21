package Tree.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.TreeNode;

/**
 * Created by Shuhua Song
 */
////BFS
public class _102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }

    /*
     //DFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        dfs(root, 0, res);
        return res;
    }
    private void dfs(TreeNode root, int height, List<List<Integer>> res){
        if(root==null) return;
        if(height==res.size()) res.add(new ArrayList<>());
        res.get(height).add(root.val);
        dfs(root.left, height+1, res);
        dfs(root.right, height+1, res);
    }
     */
}
