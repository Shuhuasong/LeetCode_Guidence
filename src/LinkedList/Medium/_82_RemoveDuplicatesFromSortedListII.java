package LinkedList.Medium;
import LinkedList.ListNode;
/**
 * Created by Shuhua Song
 */
public class _82_RemoveDuplicatesFromSortedListII {


    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                while(curr.next != null && curr.val==curr.next.val){
                    curr = curr.next;
                }
                prev.next = curr.next;
            }else{
                prev = curr;//prev = curr.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
