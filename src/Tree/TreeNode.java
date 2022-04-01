package Tree;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Shuhua Song
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private static TreeNode readBinaryTree(Scanner in) {
        int numNodes = in.nextInt();
        if (numNodes == 0) {
            return null;
        }

        ArrayList<TreeNode> nodes = new ArrayList<>();
        int currentParentIndex = 0;

        TreeNode root = new TreeNode(in.nextInt());
        nodes.add(root);

        for (int i = 1; i < numNodes; i += 2) {
            int leftData = in.nextInt();
            if (leftData != -1) {
                TreeNode left = new TreeNode(leftData);
                nodes.add(left);
                nodes.get(currentParentIndex).left = left;
            }

            int rightData = in.nextInt();
            if (rightData != -1) {
                TreeNode right = new TreeNode(rightData);
                nodes.add(right);
                nodes.get(currentParentIndex).right = right;
            }

            currentParentIndex += 1;
        }

        return root;
    }
}