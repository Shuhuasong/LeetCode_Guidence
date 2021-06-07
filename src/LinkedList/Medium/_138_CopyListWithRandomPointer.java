package LinkedList.Medium;

import org.w3c.dom.Node;

import java.util.HashMap;


public class _138_CopyListWithRandomPointer {

    public class Node {
        int val;
        Node next, random;
        Node(int x, Node next, Node random){
            val = x;
            next = null;
            random = null;
        }
    }

    // Use map to store the node from original as Key, and new node as Value
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur, new Node(cur.val, null, null));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
