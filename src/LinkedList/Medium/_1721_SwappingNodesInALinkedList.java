package LinkedList.Medium;
import LinkedList.ListNode;
/**
 * Created by Shuhua Song
 */
public class _1721_SwappingNodesInALinkedList {
    //One Pass
    public ListNode swapNodes(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        ListNode first = null, second = null;
        while(curr != null){
            if(second!=null) second = second.next;
            count++;
            if(count==k){
                first = curr;
                second = head;
            }
            curr = curr.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }

    /*
     public ListNode swapNodes(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        ListNode first = null, second = head;
        for(int i=1; i<=k; i++){
            first = curr;
            curr = curr.next;
        }
        while(curr != null){
            curr = curr.next;
            second = second.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
     */

    //Two-Pass
 /*   public ListNode swapNodes(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        ListNode first = null, second = null;
        while(curr != null){
            count++;
            if(count==k) first = curr;
            curr = curr.next;
        }
        second = head;
        for(int i=1; i<=count-k; i++){
            second =second.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    } */
}

/*
Solution-1: 3-pass
1) find the length of list
2) start from head, set front pointter
3) start from head, set end pointer
   swap
Solution-2: 2-pass
1) iterate list, add count, when count=k, set front = curr
2) start from head, find end pointer
   swap
Solution-3: 1-pass
1) iterate list, add count
   when count==k, set front = curr, and end = head
   when curr = null, then end is position at count-k

 */
