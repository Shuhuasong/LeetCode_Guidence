package LinkedList.Medium;
import LinkedList.ListNode;
/**
 * Created by Shuhua Song
 */
public class _445_AddTwoNumber_II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        if(l1==null && l2 != null) return l2;
        if(l1!=null && l2==null) return l1;
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy, temp = null;
        int sum = 0, carry = 0;
        while(l1 != null || l2 != null){
            sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(sum%10);
            if(dummy.next == null){
                dummy.next = newNode;
                newNode.next = null;
            }else{
                //insert new node into head
                temp = dummy.next;
                dummy.next = newNode;
                newNode.next= temp;
            }
            carry = sum/10;
        }
        if(carry > 0){
            ListNode  node = new ListNode(carry);
            temp = dummy.next;
            dummy.next = node;
            node.next = temp;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
