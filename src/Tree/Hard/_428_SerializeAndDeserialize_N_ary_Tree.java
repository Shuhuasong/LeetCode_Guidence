package Tree.Hard;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _428_SerializeAndDeserialize_N_ary_Tree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private void encode(Node root, StringBuilder sb){
        if(root==null) return;
        sb.append(root.val+"").append(",");
        sb.append(root.children.size()+"").append(",");
        for(Node next : root.children){
            encode(next, sb);
        }
    }


    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data==null || data.length()==0) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(q);
    }

    private Node buildTree(Queue<String> q){
        if(q.isEmpty()) return null;
        int val = Integer.parseInt(q.poll());
        int size = Integer.parseInt(q.poll());
        Node root = new Node(val, new ArrayList<Node>());
        for(int i=0; i<size; i++){
            Node child = buildTree(q);
            root.children.add(child);
        }
        return root;
    }
}

/*
Solution:
1) recorde each node's value and it's children size
   {value, # of children}
 e.g
 [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 {1,4}{2,0}{3,2}{6,0}{7,1}{11,1}{14,0}{4,1}{8,1}{12,0}{5,2}{9,1}{13,0}{10,0}

-{1,4}
 --{2,0}
 --{3,2}
 ---{6,0}
 ---{7,1}
 ----{11,1}
 -----{14,0}
 --{4,1}
 ---{8,1}
 ----{12,0}
 --{5,2}
 ---{9,1}
 ----{13,0}
 ---{10,0}
 */

