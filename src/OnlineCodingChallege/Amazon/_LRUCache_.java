package OnlineCodingChallege.Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _LRUCache_ {
    class ListNode{
        int key, val;
        ListNode next;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    int capacity, size;
    ListNode dummy, tail;
    Map<Integer, ListNode> keyToPrev;

    public _LRUCache_(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.dummy = new ListNode(0,0);
        this.tail = this.dummy;
        keyToPrev = new HashMap<Integer, ListNode>();
    }

    public int get(int key) {
        if(!keyToPrev.containsKey(key)){
            return -1;
        }
        moveToTail(key);
        return tail.val;
    }

    private void moveToTail(int key){
        ListNode prev = keyToPrev.get(key);
        ListNode curr = prev.next;
        if(tail==curr) return;
        prev.next = prev.next.next;
        tail.next = curr;
        curr.next = null;
        if(prev.next != null){
            keyToPrev.put(prev.next.key, prev);
        }
        keyToPrev.put(curr.key, tail);
        tail = curr;
    }

    public void put(int key, int value) {
        if(get(key)!=-1){
            ListNode preNode = keyToPrev.get(key);
            preNode.next.val = value;
            return;
        }
        if(size < capacity){
            size++;
            ListNode node = new ListNode(key, value);
            tail.next = node;
            keyToPrev.put(key, tail);
            tail = node;
            return;
        }
        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        first.key = key;
        first.val = value;
        keyToPrev.put(key, dummy);
        moveToTail(key);
    }
}
