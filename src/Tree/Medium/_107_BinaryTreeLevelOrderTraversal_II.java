package Tree.Medium;
import java.util.*;
import Tree.TreeNode;
/**
 * Created by Shuhua Song
 */
public class _107_BinaryTreeLevelOrderTraversal_II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp =new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                temp.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(temp);
        }
        Collections.reverse(res);
        return res;
    }
}
