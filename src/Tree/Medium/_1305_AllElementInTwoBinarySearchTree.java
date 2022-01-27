package Tree.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _1305_AllElementInTwoBinarySearchTree {

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

    //iterative
    //Time = O((M+N)*log(M+N))
    //Space = O(M+N)
    LinkedList<Integer> results;
    ArrayDeque<TreeNode> st1, st2;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2){
        results = new LinkedList<>();
        st1 = new ArrayDeque<>(); st2 = new ArrayDeque<>();
        //put all the elements into stack until reach the leaf node for both tree.                            // First left, then right
        while(root1!=null || root2!=null || !st1.isEmpty() || !st2.isEmpty()){
            //filling stack1 with left node of root1 tree
            while(root1!=null){
                st1.push(root1);
                root1 = root1.left;
            }
            //filling stack2 with left node of root2 tree
            while(root2!=null){
                st2.push(root2);
                root2 = root2.left;
            }
            //stack2 is empty, pop all node from stack1
            //Or when stack2's peek node val greater than stack1's
            if(st2.isEmpty() || !st1.isEmpty() && st1.getFirst().val <= st2.getFirst().val){
                root1 = st1.pop();
                results.add(root1.val);
                root1 = root1.right;
            }else
            //stack1 is empty, pop all node from stack2
            //Or when stack1's peek node val greater than stack2's
            {
                root2 = st2.pop();
                results.add(root2.val);
                root2 = root2.right;
            }
        }
        return results;
    }

    //Time = O(M+N)
    //Space = O(M+N)
/*    List<Integer> results;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        results = new LinkedList<>();
        inOrder(root1, list1);
        inOrder(root2, list2);
        merge(list1, list2);
        return results;
    }
    private void inOrder(TreeNode node, List<Integer> list){
        if(node==null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
    private void merge(List<Integer> l1, List<Integer> l2){
        int p1 = 0, p2 = 0;
        while(p1 < l1.size() && p2 < l2.size()){
            int val1 = l1.get(p1);
            int val2 = l2.get(p2);
            if(val1 <= val2){
                results.add(val1);
                p1++;
            }else{
                results.add(val2);
                p2++;
            }
        }
        while(p1 < l1.size()){
            results.add(l1.get(p1));
            p1++;
        }
        while(p2 < l2.size()){
            results.add(l2.get(p2));
            p2++;
        }
    }  */

    //Time = O((M+N)*log(M+N))
    //Space = O(M+N)
/*    LinkedList<Integer> results;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        results = new LinkedList<>();
        inOrder(root1);
        inOrder(root2);
        Collections.sort(results);
        return results;
    }
    private void inOrder(TreeNode node){
        if(node==null) return;
        inOrder(node.left);
        results.add(node.val);
        inOrder(node.right);
    } */
}
