package LinkedList.Medium;

public class _92_ReverseLinkedListII {

    class ListNode {
        int val;
       ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null) return null;
        ListNode curr = head, prev = null;
        //Move the two pointers until they reach the proper starting point in the list
        while(left > 1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        //keep the two pointer for fixing the final connection
        ListNode priorNode = prev, tail = curr;
        ListNode temp = null;
        //Iteratively reverse the nodes until n becomes 0
        while(right > 0){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            right--;
        }
        //Adjuct the final connections
        if(priorNode != null){
            priorNode.next = prev;
        }else{
            head = prev;
        }
        tail.next = curr;
        return head;
    }
}
