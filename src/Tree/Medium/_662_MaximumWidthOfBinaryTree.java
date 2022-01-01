package Tree.Medium;

import java.util.LinkedList;

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

    //Note: the value for each node are not useful, so we will change it to index
    //Time = o(N), Space = O(n)
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        root.val = 0;
        int currW = 0, maxW = 0;
        int start = 0, end = 0;
        while(!q.isEmpty()){
            currW = q.peekLast().val-q.peekFirst().val+1;
            maxW = Math.max(maxW, currW);
            int size = q.size();
            for(int i=0; i<size; i++){
                root = q.poll();
                if(root.left != null){
                    root.left.val = 2 * root.val;
                    q.add(root.left);
                }
                if(root.right != null){
                    root.right.val = 2 * root.val + 1;
                    q.add(root.right);
                }
            }
        }
        return maxW;
    }

    /*
     //Time = o(N), Space = O(n)
    public int widthOfBinaryTree(TreeNode root) {
         if(root==null) return 0;
         Queue<TreeNode> q = new LinkedList<>();
         Map<TreeNode, Integer> map = new HashMap<>();
         q.add(root);
         map.put(root, 1);
         int currW = 0, maxW = 0;
         int start = 0, end = 0;
         while(!q.isEmpty()){
             int size = q.size();
             for(int i=0; i<size; i++){
                 TreeNode node = q.poll();
                 if(i==0) start = map.get(node);
                 if(i==size-1) end = map.get(node);
                 if(node.left != null){
                     q.add(node.left);
                     map.put(node.left, 2*map.get(node));
                 }
                 if(node.right != null){
                     q.add(node.right);
                     map.put(node.right, 2*map.get(node)+1);
                 }
             }
             currW = end-start+1;
             maxW = Math.max(maxW, currW);
         }
        return maxW;
    }
     */
}
