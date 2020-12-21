package Tree.BST;

import org.w3c.dom.Node;

public class _510_InorderSuccessorInBSTII {


    class Node{
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }


    public Node inOrderSuccessor(Node node){
        if(node.right!=null){
            node = node.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }

        Node p = node.parent;
        Node cur = node;
        while(p!=null && p.right==cur){ //when the node is 7
            cur = p;
            p = p.parent;
        }
        return p;
    }
}

/*
Algorithm

If the node has a right child, and hence its successor is somewhere lower in the tree. Go to the right once and then as many times to the left as you could. Return the node you end up with.

Node has no right child, and hence its successor is somewhere upper in the tree. Go up till the node that is left child of its parent. The answer is the parent.
              5
            /   \
           3     8
         /     /   \9
        2     6
               \
                7
 */
