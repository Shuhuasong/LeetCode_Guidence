package LinkedList.Easy;

/**
 * Created by Shuhua Song
 */
public class _141_LinkedListCycle {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow = head, fast = head.next;
        while(slow != fast){
            if(fast==null || fast.next==null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /*
     public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        ListNode cur = head;
        while(cur != null){
            if(!seen.contains(cur)){
                seen.add(cur);
                cur = cur.next;
            }else{
                return true;
            }
        }
        return false;
    }
     */
}
