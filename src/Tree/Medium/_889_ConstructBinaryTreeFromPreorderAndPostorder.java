package Tree.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _889_ConstructBinaryTreeFromPreorderAndPostorder {

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


    Map<Integer, Integer> preMap = new HashMap<>();
    Map<Integer, Integer> postMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder.length==0 || preorder.length != postorder.length) return null;
        int n = preorder.length;
        for(int i=0; i<n; i++){
            preMap.put(preorder[i], i);
            postMap.put(postorder[i], i);
        }
        return buildTree(preorder, 0, n-1, postorder, n-1);
    }

    private TreeNode buildTree(int[] pre, int preS, int preE, int[] post, int end){
        if(preS > preE || end < 0) return null;
        TreeNode root = new TreeNode(pre[preS]);
        if(preS==preE) return root;
        int preIdx = preMap.get(post[end-1]);
        int postIdx = postMap.get(pre[preS+1]);
        root.left = buildTree(pre, preS+1, preIdx-1, post, postIdx);
        root.right = buildTree(pre, preIdx, preE, post, end-1);
        return root;
    }
}
