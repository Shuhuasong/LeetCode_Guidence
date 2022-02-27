package DFS_and_BFS.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _863_AllNodesDistanceKinBinaryTree {

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


    Map<TreeNode, TreeNode> parents;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parents = new HashMap<>();
        dfs(root, null);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.add(target); visited.add(target);
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(steps==k) return getResFromQ(q);
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left != null && !visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                }
                TreeNode parent = parents.get(node);
                if(parent!=null && !visited.contains(parent)){
                    q.add(parent);
                    visited.add(parent);
                }
            }
            steps++;
        }
        return new ArrayList<>();
    }

    private List<Integer> getResFromQ(Queue<TreeNode> q){
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            res.add(node.val);
        }
        return res;
    }

    private void dfs(TreeNode node, TreeNode parent){
        if(node==null) return;
        parents.put(node, parent);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}
