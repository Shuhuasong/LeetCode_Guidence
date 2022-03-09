package LinkedList.Medium;

import java.util.PriorityQueue;
import java.util.Queue;

import LinkedList.ListNode;
/**
 * Created by Shuhua Song
 */
public class _23_MergeKsortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((a, b)->a.val-b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(ListNode node : lists){
            if(node==null) continue;
            pq.offer(node);
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next != null){
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
}
