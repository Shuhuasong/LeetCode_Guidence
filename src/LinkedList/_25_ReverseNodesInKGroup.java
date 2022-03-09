package LinkedList;
import LinkedList.ListNode;
/**
 * Created by Shuhua Song
 */
public class _25_ReverseNodesInKGroup {

    //recursive
    //Time = O(n), Space = O(n/k), for the recursion stack
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        int count = 0;
        //First, see if there are at least k nodes left to reverse
        //in the list
        ListNode curr = head;
        while(count < k && curr != null){
            count++;
            curr = curr.next;
        }
        //if we have k nodes, then we reverse them
        if(count==k){
            //reverse the first k nodes of the list and
            //get reverse list's head
            ListNode reverseHead = reverse(head, k);
            //Now recurse on the remain list. since our recursion return the head of the overall processed list, we use that and the 'original' head of the "k" nodes to rewrited the connections
            head.next = reverseKGroup(curr, k);
            return reverseHead;
        }
        return head;
    }

    private ListNode reverse(ListNode head, int k){
        ListNode prev = null, curr = head;
        while(k > 0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            k--;
        }
        return prev;
    }

 /*   public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        //if(head==null) return null;
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        while(prev != null){
            prev = reverse(prev, k);
        }
        return dummy.next;
    }

    //   D----> 1----->2---->3---> 4
    //   |      |      |     |
    //   pre   tail   curr  Last
    private ListNode reverse(ListNode prev, int k){
        ListNode  last = prev;
        for(int i=0; i<k+1; i++){
            last = last.next;
            if(i!=k && last==null) return null;
        }
        ListNode tail = prev.next;
        ListNode curr = prev.next.next;
        while(curr != last){
            ListNode temp = curr.next;// temp = 3
            curr.next = prev.next;  //curr.next = 1
            prev.next = curr; // prev.next = 2, connect prev and 2
            tail.next = temp; // tail.next = 3, connect tail and 3
            curr = temp; // move curr forward
        }
        return tail;
    }

  */
}
