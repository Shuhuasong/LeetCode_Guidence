package LinkedList.Medium;
import LinkedList.ListNode;
public class _61_RotateList_IIIIIIII {



    //Time: O(n) Space = O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        if(head.next==null || k==0) return head;
        ListNode old_tail = head;
        int count = 1;
        while(old_tail.next!=null){
            count++;
            old_tail = old_tail.next;
        }

        System.out.println(count);
        old_tail.next = head;
        ListNode new_tail = head;
        for(int i=0; i<count-k%count-1; i++){
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;
        new_tail.next = null;

        return new_head;
    }
}

/*
Algorithm

1) Find the old tail and connect it with the head old_tail.next = head to close the ring. Compute the length of the list n at the same time.

2) Find the new tail, which is (n - k % n - 1)th node from the head and the new head, which is (n - k % n)th node.

3) Break the ring new_tail.next = None and return new_head.
*/

