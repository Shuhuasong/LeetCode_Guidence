package Tree.Medium;

import java.util.HashMap;

public class _106_ConstructBinaryTreefromInorderAndPostorder {
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

    int[] postorder;
    int postIndex;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        postIndex = postorder.length-1;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(0, inorder.length-1); //-1
    }

    private TreeNode build(int left, int right){
        if(left>right) return null; //
        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        postIndex--;
        root.right = build(rootIdx+1, right);
        root.left = build(left, rootIdx-1);
        return root;
    }
}
