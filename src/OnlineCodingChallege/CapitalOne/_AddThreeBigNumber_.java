package OnlineCodingChallege.CapitalOne;

/**
 * Created by Shuhua Song
 */
public class _AddThreeBigNumber_ {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addThreeNumber(ListNode l1, ListNode l2, ListNode l3){
       ListNode newL1 = reverse(l1);
       ListNode newL2 = reverse(l2);
       ListNode newL3 = reverse(l3);
       int sum = 0, carry = 0, avg = 0;
       int count = 0;
       ListNode dummy = new ListNode(-1);
       ListNode head = dummy, temp = null;
       while(l1 != null || l2 != null || l3 != null){
           sum = carry;
           if(l1 != null){
               sum += l1.val;
               l1 = l1.next;
           }
           if(l2 != null){
               sum += l2.val;
               l2 = l2.next;
           }
           if(l3 != null){
               sum += l3.val;
               l3 = l3.next;
           }
           ListNode newNode = new ListNode(sum%1000);
           if(dummy.next == null){
               dummy.next = newNode;
               newNode.next = null;
           }else{
               temp = dummy.next;
               dummy.next = newNode;
               newNode.next = temp;
           }
           carry = sum/1000;
       }
       if(carry > 0){
           ListNode newNode = new ListNode(carry);
           temp = dummy.next;
           dummy.next = newNode;
           newNode.next = temp;
       }
       ListNode curr = dummy.next;
       int rem = 0, num = 0;
       while(curr != null){
           num = rem * 1000 + curr.val;
           int newVal = num/3;
           curr.val = newVal;
           rem = num % 3;
           curr = curr.next;
       }
       return dummy.next;
    }

    private static ListNode reverse(ListNode head){
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

    public static void main(String[] args) {

    }
}
