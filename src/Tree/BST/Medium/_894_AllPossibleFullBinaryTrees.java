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
    //Cache: don't need to repeat calculate N values
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

    /*
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> results = new ArrayList<>();
        if(n==1){
            results.add(new TreeNode(0));
            return results;
        }
        n = n-1;
        for(int x=1; x<n; x+=2){
            int y = n-x;
            for(TreeNode left : allPossibleFBT(x)){
                for(TreeNode right : allPossibleFBT(y)){
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    results.add(root);
                }
            }
        }
        return results;
    }
     */
}


/*
intuitive:

recurisvely find the the possible children of each node at each level. At every level,
substract 1 from N since the current node counts as a node.
1) when N==1, return a node with no children
2) when N is even, return empty list since it is not possible to make full binary tree with an even
   number of nodes.
3) for every x, x is the number of left children from allPossibleFBT(x);
   for every y, y is the number of right children from allPossibleFBT(N-x)
   then iterate through all possible combination of children to set the current
   node's left and right children, and add it to the results list.


let FBT(n) be the list of all possible full binary trees with n nodes.
every full binary tree T with 3 or more nodes, has 2 children at its root.
Each of those children left and right are thenselves full binary trees.
For n>=3, we can formulate the recursion:
FBT(n) = all trees with left child from FBT(x) and right child from FBT(n-1-x)
         for all x

*/














