package Design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */

class LRUCache {

    class ListNode {
        int key, value;
        ListNode prev, next;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void moveToHead(ListNode node) {
        //move certain node in between to the head
        removeNode(node);
        addNode(node);
    }

    public void removeNode(ListNode node) {
        // remove an existing node from the linked list
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addNode(ListNode node) {
        //  Add the new node right after head
        node.prev = head;
        node.next = head.next;
        head.next.prev = node; //be careful the order of this line and next line, this line must be the first
        head.next = node;
    }

    public ListNode removeTail() {
        //pop the current tail
        ListNode last = tail.prev;
        removeNode(last);
        return last;
    }


    Map<Integer, ListNode> cache = new HashMap<>();
    ListNode head, tail;
    int capacity, size;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node == null) {
            ListNode newNode = new ListNode(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
            if (size > capacity) {
                ListNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}

/*
 class _LRUCache_ {

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


/*
class LRUCache extends LinkedHashMap<Integer, Integer>{

    int capacity;
    //This constructor is also used to initialize both the capacity and fill ratio for a LinkedHashMap along with whether to follow the insertion order or not.
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    // Returns true if this map should remove its eldest entry.
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
        return size() > capacity;
    }
}

*/


