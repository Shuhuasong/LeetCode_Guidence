package Tree.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _314_BinaryTreeVerticalOrderTraversal {

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

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Map<Integer, List<Integer>> colToNode = new HashMap<>();
        Map<TreeNode, Integer> nodeCol = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        int minCol = Integer.MAX_VALUE;
        q.add(root);
        nodeCol.put(root, 0);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int col = nodeCol.get(node);
            colToNode.computeIfAbsent(col, k->new ArrayList<>()).add(node.val);
            if(node.left != null){
                nodeCol.put(node.left, col-1);
                q.add(node.left);
            }
            if(node.right != null){
                nodeCol.put(node.right, col+1);
                q.add(node.right);
            }
            minCol = Math.min(minCol, col);
        }
        List<List<Integer>> res = new ArrayList<>();
        while(colToNode.containsKey(minCol)){
            res.add(colToNode.get(minCol++));
        }
        return res;
    }

    //DFS: Time = O(n), Space = O(n)
 /*   TreeMap<Integer, List<int[]>> colMap = new TreeMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root==null) return results;
        colMap = new TreeMap<>();
        preOrder(root, 0, 0);
        for(int col : colMap.keySet()){
            List<int[]> rowList = colMap.get(col);
            //sort the list according to the row number under the ordered col number
            Collections.sort(rowList, (a, b)->a[0]-b[0]);
            List<Integer> currList = new ArrayList<>();
            for(int[] node : rowList){
                currList.add(node[1]);
            }
            results.add(currList);
        }
        return results;
    }

    private void preOrder(TreeNode root, int row, int col){
        if(root==null) return;
        //System.out.println(root.val);
        int[] currNode = new int[]{row, root.val};
        colMap.putIfAbsent(col, new ArrayList<int[]>());

        colMap.get(col).add(currNode);

        preOrder(root.left, row+1, col-1);
        preOrder(root.right, row+1, col+1);
    } */

    /*
     //BFS
    class Item{
        TreeNode node;
        int row, col;
        public Item(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    //DFS: Time = O(n), Space = O(n)
    TreeMap<Integer, List<int[]>> colMap = new TreeMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root==null) return results;
        colMap = new TreeMap<>();
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(root, 0, 0));
        while(!q.isEmpty()){
            Item item = q.poll();
            TreeNode node = item.node;
            int row = item.row, col = item.col;
            int[] currPair = new int[]{row, node.val};
            colMap.putIfAbsent(col, new ArrayList<int[]>());
            colMap.get(col).add(currPair);
            if(node.left != null){
                q.add(new Item(node.left, row+1, col-1));
            }
            if(node.right != null){
                q.add(new Item(node.right, row+1, col+1));
            }
        }

         for(int col : colMap.keySet()){
            List<int[]> rowList = colMap.get(col);
            //sort the list according to the row number under the ordered col number
            Collections.sort(rowList, (a, b)->a[0]-b[0]);
            List<Integer> currList = new ArrayList<>();
            for(int[] node : rowList){
                currList.add(node[1]);
            }
            results.add(currList);
        }
        return results;
    }
     */
}
