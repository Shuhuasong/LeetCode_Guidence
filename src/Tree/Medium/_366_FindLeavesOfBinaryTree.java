package Tree.Medium;

import java.util.ArrayList;
import java.util.List;
import Tree.TreeNode;
/**
 * Created by Shuhua Song
 */
public class _366_FindLeavesOfBinaryTree {

    //Divide and conquer
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root==null) return results;
        List<List<Integer>> left = findLeaves(root.left);
        List<List<Integer>> right = findLeaves(root.right);
        List<Integer> last = new ArrayList<>();
        last.add(root.val);
        results = (left.size() > right.size()) ? mergeList(left, right) : mergeList(right, left);
        results.add(last);
        return results;
    }

    private List<List<Integer>> mergeList(List<List<Integer>> bigList, List<List<Integer>> smallList){
        for(int i=0; i<smallList.size(); i++){
            bigList.get(i).addAll(smallList.get(i));
        }
        return bigList;
    }

    /*
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root==null) return results;
        getHeight(root, results);
        return results;
    }

    private int getHeight(TreeNode root, List<List<Integer>> res){
        if(root==null) return -1;
        int left = getHeight(root.left, res);
        int right = getHeight(root.right, res);
        int currHeight = Math.max(left, right)+1;
        if(currHeight >= res.size()){
            res.add(new ArrayList<>());;
        }
        res.get(currHeight).add(root.val);
        return currHeight;
    } */
}
