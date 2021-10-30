package Tree.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _987_VerticalOrderTraversalOfABinaryTree {

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


    List<List<Integer>> results = new ArrayList<>();
    //TreeMap : key = col number, value = (row number, node value)
    TreeMap<Integer, List<int[]>> colMap = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null) return results;
        dfs(root, 0, 0);
        for(int col : colMap.keySet()){
            List<int[]> rowList = colMap.get(col);
            Collections.sort(rowList, (a, b)->{
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }else{
                    return a[0]-b[0];
                }
            });
            List<Integer> currList = new ArrayList<>();
            for(int[] node : rowList){
                currList.add(node[1]);
            }
            results.add(currList);
        }
        return results;
    }

    private void dfs(TreeNode root, int row, int col){
        if(root==null) return;
        if(!colMap.containsKey(col)){
            colMap.put(col, new ArrayList<int[]>());
        }
        List<int[]> rowList = colMap.get(col);
        rowList.add(new int[]{row, root.val});
        colMap.put(col, rowList);
        dfs(root.left, row+1, col-1);
        dfs(root.right, row+1, col+1);
    }
}
