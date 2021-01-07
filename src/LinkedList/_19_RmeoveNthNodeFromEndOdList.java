package LinkedList;

public class _19_RmeoveNthNodeFromEndOdList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int total;
        ListNode curr = head;
        for(total=0; curr!=null; total++){
            curr = curr.next;
        }

        curr = dummy;
        for(int i=0; i<total-n; i++){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}
