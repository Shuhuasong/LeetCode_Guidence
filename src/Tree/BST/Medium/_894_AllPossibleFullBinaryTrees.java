package Tree.BST.Medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _894_AllPossibleFullBinaryTrees {

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

    Map<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(!map.containsKey(n)){
            List<TreeNode> list = new LinkedList<>();
            if(n==1){
                list.add(new TreeNode(0));
            }else if(n%2==1){
                for(int x=0; x<n; x++){
                    int  y = n-x-1;
                    for(TreeNode left : allPossibleFBT(x)){
                        for(TreeNode right : allPossibleFBT(y)){
                            TreeNode root = new TreeNode(0);
                            root.left = left;
                            root.right = right;
                            list.add(root);
                        }
                    }
                }
            }
            map.put(n, list);
        }
        return map.get(n);
    }
}
