package Tree.Hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import Tree.TreeNode;
/**
 * Created by Shuhua Song
 */
public class _297_SerializeAndDeserializeBinaryTree {

     /*
    Follow-up question: what if the original tree has String as TreeNode value?
    Base64 encode the node.val when appending
    */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "$";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(serialize(root.left)).append(",");
        sb.append(serialize(root.right));
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(q);
    }

    private TreeNode buildTree(Queue<String> q){
        if(q.isEmpty()) return null;
        String val = q.poll();
        if(val.equals("$")) return null;
        int v = Integer.parseInt(val);
        TreeNode root = new TreeNode(v);
        root.left = buildTree(q);
        root.right = buildTree(q);
        return root;
    }
}
