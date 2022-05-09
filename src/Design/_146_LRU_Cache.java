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

    public void addNode(ListNode node){
        //be careful the order of this line and next line, this line must be the first
        node.prev = head;
        node.next = head.next; //  <---newNode--->
        head.next.prev = node; //      newNode<---nextNode
        head.next = node;  //   head--->newNode
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
//-----------------------------------------------------------------------
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



class LRUCache extends LinkedHashMap<Integer, Integer>{


    //This constructor is also used to initialize both the capacity and fill ratio for a LinkedHashMap
    // along with whether to follow the insertion order or not.
    int capacity;
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


/*
Normal thinking:
Map <Key, Value> ==> get key/check key exist ===> O(1)
Map<Integer, Integer>  key==key, value = usage times
e.g  {{1, 2}, {2, 2}, {3, 1}}
To find a key to kick out is O(n)

How can we improve ?
Map<Key, Node>
front:keep recently used, end: least recently use
Head-->{1, 1} ==> the new node(2,2)comes, put it in front of list  :  addAfterHead(node)
Head-->{2, 2}-->{1, 1} ==> use a node, put it in front of list
Head-->{1, 1}-->{2, 2}==> new node(3, 3) comes, put it in front of list, kick out (2,2) :  remove(node), addAfterHead(node)
Head-->{3, 3}-->{1, 1}==> new node(4, 4) comes, put it in front of list, kick out (1,1) :
Head-->{4, 4}-->{3, 3}

1) node exist :
e.g
Head-->{1, 1}-->{3, 6}
  ==> new node(3, 3) comes, update node, remove it and put it in front of list, kick out (2,2) :  remove(node), addAfterHead(node)
Head-->{3, 3}-->{1, 1}
   --update node's value
   --moveToHead() = remove(node) + addAfterHead(node)

2) node not exist:
   --creat  a new node
   --add the new node after head : addAfterHead(node)
   --put in the cache (key, newNode)
   --increase size: size++
   --check size, if size > capacity ==> remove tail node and remove the tail node in the cache : removeTail()
   --update size again: size--


   https://www.hp.com/us-en/shop/tech-takes/what-is-cache-memory#:~:text=Computer%20cache%20definition,your%20computer's%20main%20hard%20drive.
*/



