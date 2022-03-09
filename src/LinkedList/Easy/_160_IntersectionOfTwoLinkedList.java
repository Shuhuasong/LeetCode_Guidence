package LinkedList.Easy;
import LinkedList.ListNode;
public class _160_IntersectionOfTwoLinkedList {


    //Solution #1--use set
    //Solution #2
    /*
    idea : if there is an intersection in both, then then sum length of three part will be the same:
    a + b + c  == b + c + a
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while(pa != pb){
            pa = (pa==null) ? headB : pa.next;
            pb = (pb==null) ? headA : pb.next;
        }
        return pa;
    }
}
