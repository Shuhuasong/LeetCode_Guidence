package Tree.BST;

public class _450_DeleteNodeInBST {

    // Time = O(H1 + H2), H1 = the tree height from the root to the node to delete
    // Time = O(log n)                 H2 = the height from the delete node to leaf
    //Space = O(H) , keep the recursion stack
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        //1. delete from the left subtree if root.val > key
        if(root.val > key){
            root.left = deleteNode(root.left, key);
            //2. delete from the right subtree if root.val < key
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
            //3. delete the current node
        }else{
            //1> the node is a leaf
            if(root.left==null && root.right==null){
                root = null;
                //2> the node is not a leaf and has a right child
            }else if(root.right != null){
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
                //3> the node is not a leaf and has no right child but has a left child
            }else{
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    // One step right and then always left
    public int successor(TreeNode node){
        node = node.right;
        while(node.left != null){
            node = node.left;
        }
        return node.val;
    }
    // One step left and then always right
    public int predecessor(TreeNode node){
        node = node.left;
        while(node.right != null){
            node = node.right;
        }
        return node.val;
    }
}
