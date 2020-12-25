package LinkedList;

public class _206_ReverseLinkedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    //Iterative:  Time: O(n) Space = O(1)
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode cur = head;
        ListNode prev = null;
        ListNode nextCur = null;
        while(cur != null){
            nextCur = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextCur;
        }
        return prev;
    }


    //Recursive
    /* idea:
    Assume from node nk+1 to nm had been reversed and you are at node nk.

    n1 → … → nk-1 → nk → nk+1 ← … ← nm

    We want nk+1’s next node to point to nk.

    So,

    nk.next.next = nk;
     */
    //Time: O(n) Space = O(n)
  /*  public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

   */
}
