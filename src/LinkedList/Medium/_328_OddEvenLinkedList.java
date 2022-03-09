package LinkedList.Medium;
import LinkedList.ListNode;
/**
 * Created by Shuhua Song
 */
public class _328_OddEvenLinkedList {


    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode oddHead = head, evenHead = head.next;
        ListNode odd = oddHead, even = evenHead;
        while(even!=null && even.next!= null){
            ListNode temp = even.next;
            odd.next = temp;
            odd = odd.next;
            even.next = temp.next;
            even = even.next;
        }
        odd.next = evenHead;
        return oddHead;
    }
}
