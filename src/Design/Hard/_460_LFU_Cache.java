package Design.Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _460_LFU_Cache {
    class ListNode {
        int key, value, count;
        ListNode prev, next;
        public ListNode(){}
        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }

    class DList{
        ListNode head, tail;
        int len;
        public DList(){
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.prev =head;
            len = 0;
        }

        public void addHead(ListNode node){
            ListNode nextNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = nextNode;
            nextNode.prev = node;
            cache.put(node.key, node);
            len++;
        }
        public void remove(ListNode node){
            ListNode prevNode = node.prev;
            ListNode nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            len--;
            cache.remove(node.key);
        }
        public void removeTail(){
            ListNode last = tail.prev;
            remove(last);
        }
    }



    Map<Integer, ListNode> cache;
    Map<Integer, DList> freq;
    int size, capacity;
    int maxFreq;
    public _460_LFU_Cache(int capacity) {
        cache = new HashMap<>();
        freq = new HashMap<>();
        this.size = 0;
        maxFreq = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.get(key)==null) return -1;
        ListNode node = cache.get(key);
        int prevFreq = node.count;
        DList prevList = freq.get(prevFreq);
        prevList.remove(node);
        int currFreq = prevFreq + 1;
        maxFreq = Math.max(maxFreq, currFreq);
        DList currList = freq.getOrDefault(currFreq, new DList());
        currList.addHead(node);
        node.count += 1;

        freq.put(prevFreq, prevList);
        freq.put(currFreq, currList);
        return node.value;
    }

    public void put(int key, int value) {
        if(capacity==0) return;
        ListNode node = cache.get(key);
        if(node != null){
            cache.get(key).value = value;
            get(key);
            return;
        }
        node = new ListNode(key, value);
        DList currList = freq.getOrDefault(1, new DList());
        currList.addHead(node);
        size++;
        if(size > capacity){
            if(currList.len > 1){
                currList.removeTail();
            }else{
                for(int i=2; i<=maxFreq; i++){
                    if(freq.get(i)!=null && freq.get(i).len > 0){
                        freq.get(i).removeTail();
                        break;
                    }
                }
            }
            size--;
        }
        freq.put(1, currList);
    }
}
