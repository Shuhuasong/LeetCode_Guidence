package LinkedList.Medium;

/**
 * Created by Shuhua Song
 */
public class _143_ReorderList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    //Step 1: cut the original list into two half list
    //prev = the tail of 1st half list
    //slow = the head of 2nd half list
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l2 = reverse(slow);
        merge(head, l2);
    }

    private void merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1 != null || l2 != null){
            if(l1 != null) {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }
            if(l2 != null) {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }

        }
    }

    private ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode prev = null, temp = null;
        while(head != null){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
