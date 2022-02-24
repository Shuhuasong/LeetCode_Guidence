package LinkedList.Medium;

/**
 * Created by Shuhua Song
 */
public class _148_SortList {

        class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
                next = null;
            }
        }

        public ListNode sortList(ListNode head) {
            if(head==null || head.next==null) return head;
            ListNode mid = getMid(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
            return merge(left, right);
        }

        private ListNode merge(ListNode l1, ListNode l2){
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            while(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    curr.next = l1;
                    l1 = l1.next;
                }else{
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }
            if(l1!=null) curr.next = l1;
            if(l2!=null) curr.next = l2;
            return dummy.next;
        }

        private ListNode getMid(ListNode head){
            ListNode slow = head, fast = head.next;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode mid = slow.next;
            slow.next = null;
            return mid;
        }
}
