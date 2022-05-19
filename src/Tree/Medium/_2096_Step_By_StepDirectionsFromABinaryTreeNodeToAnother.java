package Tree.Medium;
import Tree.TreeNode;
import java.util.ArrayDeque;

/**
 * Created by Shuhua Song
 */
public class _2096_Step_By_StepDirectionsFromABinaryTreeNodeToAnother {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        if(root==null) return "";
        TreeNode LCA = lowestCommonAncenstor(root, startValue, destValue);

        ArrayDeque<String> lcaToStart = new ArrayDeque<>();
        findPath(LCA, startValue, lcaToStart);

        ArrayDeque<String> lcaToEnd = new ArrayDeque<>();
        findPath(LCA, destValue, lcaToEnd);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<lcaToStart.size(); i++) sb.append("U");
        while(!lcaToEnd.isEmpty()) sb.append(lcaToEnd.poll());
        return sb.toString();
    }

    private boolean findPath(TreeNode node, int target, ArrayDeque<String> dq){
        if(node==null) return false;
        if(node.val==target) return true;

        dq.offer("L");
        boolean leftFound = findPath(node.left, target, dq);
        if(leftFound) return true;
        dq.removeLast();

        dq.offer("R");
        boolean rightFound = findPath(node.right, target, dq);
        if(rightFound) return true;
        dq.removeLast();

        return false;
    }

    private TreeNode lowestCommonAncenstor(TreeNode root, int p, int q){
        if(root==null) return null;
        if(root.val == p || root.val==q) return root;
        TreeNode leftAnc = lowestCommonAncenstor(root.left, p, q);
        TreeNode rightAnc = lowestCommonAncenstor(root.right, p, q);
        //current root contains both p and q,
        if(leftAnc != null && rightAnc != null) return root;
        //left or right at least one of them contains LCA
        return leftAnc==null ? rightAnc : leftAnc;
    }



    /* BFS
     Map<Integer, int[]> parents; //child to parent : key = child value, value = parent value
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if(root==null) return "";
        TreeNode ancestor = lowestCommonAncestor(root, startValue, destValue);
        String startToAncestor = getPath(ancestor, startValue);
        String startPath = "";
        for(int i=0; i<startToAncestor.length(); i++){
            startPath += "U";
        }
        String endToAncestor = getPath(ancestor, destValue);
        return startPath+endToAncestor;
    }

    private String getPath(TreeNode node, int target){
        parents = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            TreeNode currNode = q.poll();
            if(currNode.val==target) break;
            if(currNode.left!=null){
                parents.put(currNode.left.val, new int[]{currNode.val, 1});
                q.add(currNode.left);
            }
            if(currNode.right!=null){
                parents.put(currNode.right.val, new int[]{currNode.val, 2});
                q.add(currNode.right);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(target!=node.val){
            String direction = parents.get(target)[1]==1 ? "L" : "R";
            sb.append(direction);
            target = parents.get(target)[0];
        }
        return sb.reverse().toString();
    }

    private TreeNode lowestCommonAncestor(TreeNode root, int start, int end){
        if(root==null) return null;
        if(root.val==start || root.val==end) return root;
        TreeNode left = lowestCommonAncestor(root.left, start, end);
        TreeNode right = lowestCommonAncestor(root.right, start, end);
        if(left!=null && right!=null) return root;
        return left==null ? right : left;
    }
     */
}
