package LinkedList;

public class _61_RotateList {

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
