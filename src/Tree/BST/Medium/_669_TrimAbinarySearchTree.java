package Tree.BST.Medium;
import Tree.TreeNode;
/**
 * Created by Shuhua Song
 */
public class _669_TrimAbinarySearchTree {

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;
        //if root.val < low, all the nodes on the left subtree are smaller than root.val
        //so we need to trim the whole left subtree
        if(root.val < low) return trimBST(root.right, low, high);
        //if root.val > high, all the nodes on the right subtree are greater than root.val
        //so we need to trim the whole right subtree
        if(root.val > high) return trimBST(root.left, low, high);
        //if the root.val within the range, recursively trim left/right
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

}

/*
      A
    /   \
   L'    R'
Case-1: L <= a <= R
root.left = trim(root.left)
root.right = trim(root.right);

Case-2: root.val < Low
root = trim(root.right);

Case-3: root.val > high
root = trim(root.left)
*/


/*  C++

class Solution {
public:
    TreeNode* trimBST(TreeNode* root, int low, int high) {
        if(!root) return root;
        if(root->val < low){
            auto& result = trimBST(root->right, low, high);
            delete root;
            root = nullptr;
            return result;
        }else if(root->val > high){
            auto & result = trimBST(root->left, low, high);
            delete root;
            root = nullptr;
            return result;
        }else{
            root->left = trimBST(root->left, low, high);
            root->right = trimBST(root->right, low, high);
            return root;
        }
    }
    void deleteTree(TreeNode &root){
        if(!root) return;
        delete(root.left);
        delete(root.right);
        root->left = nullptr;
        root->right = nullptr;
        delete root;
    }
};

void printTree(TreeNode* root){
        if(!root){
            cout << "null";
            return;
        };
        if(!root->left && !root->right){
            cout << root->val << " ";
        }else{
            cout << root->val << " ";
            printTree(root->left);
            printTree(root->right);
        }
}

int main(){
    TreeNode* root = new TreeNode(2);
    root->left = new TreeNode(1);
    root->right = new TreeNode(3);
    printTree(root);
    std::cout << std::endl;

    TreeNode* t = Solution().trimBST(root, 3, 4);
    printTree(t);

}
 */