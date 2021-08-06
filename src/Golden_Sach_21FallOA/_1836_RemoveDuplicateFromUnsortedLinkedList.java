package Golden_Sach_21FallOA;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1836_RemoveDuplicateFromUnsortedLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        if(head==null) return null;
        ListNode curr = head;
        while(curr != null){
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        curr = dummy;
        while(curr.next != null){
            if(map.get(curr.next.val) > 1){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
