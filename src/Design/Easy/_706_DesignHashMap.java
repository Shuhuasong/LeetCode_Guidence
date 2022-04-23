package Design.Easy;

/**
 * Created by Shuhua Song
 */
public class _706_DesignHashMap {
    class ListNode{
        private int key, value;
        private ListNode next;
        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    ListNode[] bucks;
    int size;
    public _706_DesignHashMap() {
        size = 1009;
        bucks = new ListNode[size];
    }

    public void put(int key, int value) {
        int idx = hashCode(key);
        if(bucks[idx]==null){
            bucks[idx] = new ListNode(-1, -1);
        }
        ListNode prev = getPrevNode(bucks[idx],key);
        if(prev.next==null) prev.next = new ListNode(key, value);
        else
            prev.next.value = value;
    }

    public int get(int key) {
        int idx = hashCode(key);
        if(bucks[idx]==null) return -1;
        ListNode prev = getPrevNode(bucks[idx],key);
        if(prev.next==null) return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int idx = hashCode(key);
        if(bucks[idx]==null) return;
        ListNode prev = getPrevNode(bucks[idx], key);
        if(prev.next==null) return;
        prev.next = prev.next.next;
    }

    private int hashCode(int key){
        return key%size;
    }

    private ListNode getPrevNode(ListNode head, int key){
        ListNode curr = head, prev = null;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
}
