package LinkedList.Easy;
import LinkedList.ListNode;
/**
 * Created by Shuhua Song
 */
public class _206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        ListNode temp = null;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
