package LinkedList;

import java.util.HashSet;
import java.util.Set;



public class _142_LinkedListCycleII {

 /*
 Floy'd Tortoise and Hare Algorithm
 phase-1: determine whether a cycle is exist in the list, if no cycle is present, return null directly
          otherwise, uses the located "intersection node" to find the entrance of the cycle via slow and fast pointer
 phase-2: given finding the intersection, set a pointer fast pointer to the head of list, and slow stay original place,
          then advance them by 1 until they meet. Then the node is the entrance of the cycle.
*/

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



    /*
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
     */
}
