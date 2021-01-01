package LinkedList;

import java.util.HashSet;
import java.util.Set;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class _142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> seem = new HashSet<>();
        while(head!=null){
            if(seem.contains(head)){
                return head;
            }else{
                seem.add(head);
                head = head.next;
            }
        }
        return null;
    }

    /*
      public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode fast = head, slow = head;
         // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) break;
        }
        if(fast==null || fast.next==null) return null;

        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
     */

    /*
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode fast = head, slow = head;
         // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) break;
        }
         // If there is a cycle, the fast/slow pointers will intersect at some
        // node. Otherwise, there is no cycle, so we cannot find an entrance to
        // a cycle.
        if(fast==null || fast.next==null) return null;
         // To find the entrance to the cycle, we have two pointers traverse at
        // the same speed -- one from the front of the list, and the other from
        // the point of intersection.
        fast = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
     */
}
