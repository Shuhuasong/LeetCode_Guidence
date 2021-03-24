package Tree.Medium;

import java.util.HashMap;

public class _105_ConstructBinaryTreeFromPreorderInorder {
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

    int[] preorder;
    // int[] inorder;
    int preIndex = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        //this.inorder = inorder;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(0, inorder.length-1);
    }

    private TreeNode build(int left, int right){
        if(left>right) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.left = build(left, rootIdx-1);
        root.right = build(rootIdx+1, right);
        return root;
    }


}
