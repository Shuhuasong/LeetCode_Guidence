package LinkedList.Easy;
import LinkedList.ListNode;
/**
 * Created by Shuhua Song
 */
public class _237_DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        ListNode cur = node;
        cur.val = node.next.val;
        cur.next = cur.next.next;
    }
}
