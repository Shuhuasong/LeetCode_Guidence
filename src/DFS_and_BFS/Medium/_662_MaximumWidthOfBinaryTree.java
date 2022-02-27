package DFS_and_BFS.Medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Shuhua Song
 */
public class _662_MaximumWidthOfBinaryTree {


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

    //DFS: Time = o(N), Space = O(n)
    //use a map to store the first col for each level
    class Pair {
        TreeNode node;
        int key;
        public Pair(TreeNode node, int key){
            this.node = node;
            this.key = key;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));
        int maxWide = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            Pair first = q.peekFirst();
            Pair last = q.peekLast();
            for(int i=0; i<size; i++){
                Pair pair = q.poll();
                TreeNode node = pair.node;
                int key = pair.key;
                if(node.left != null) q.offer(new Pair(node.left, 2*key));
                if(node.right != null) q.offer(new Pair(node.right, 2*key+1));
            }
            maxWide = Math.max(maxWide, last.key-first.key+1);
        }
        return maxWide;
    }

    /*
     int maxW = 0;
    Map<Integer, Integer> firstColIdxMap = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);
        return maxW;
    }
    private void dfs(TreeNode root, int depth, int col){
        if(root==null) return;
        if(!firstColIdxMap.containsKey(depth)){
            firstColIdxMap.put(depth, col);
        }
        int firstColIdx = firstColIdxMap.get(depth);
        maxW = Math.max(maxW, col-firstColIdx+1);
        dfs(root.left, depth+1, 2*col);
        dfs(root.right, depth+1, 2*col+1);
    }
     */
}
