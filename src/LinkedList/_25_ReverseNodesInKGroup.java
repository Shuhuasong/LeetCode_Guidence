package LinkedList;

/**
 * Created by Shuhua Song
 */
public class _25_ReverseNodesInKGroup {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        //if(head==null) return null;
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        while(prev != null){
            prev = reverse(prev, k);
        }
        return dummy.next;
    }

    //   D----> 1----->2---->3---> 4
    //   |      |      |     |
    //   pre   tail   curr  Last
    private ListNode reverse(ListNode prev, int k){
        ListNode  last = prev;
        for(int i=0; i<k+1; i++){
            last = last.next;
            if(i!=k && last==null) return null;
        }
        ListNode tail = prev.next;
        ListNode curr = prev.next.next;
        while(curr != last){
            ListNode temp = curr.next;// temp = 3
            curr.next = prev.next;  //curr.next = 1
            prev.next = curr; // prev.next = 2, connect prev and 2
            tail.next = temp; // tail.next = 3, connect tail and 3
            curr = temp; // move curr forward
        }
        return tail;
    }
}
