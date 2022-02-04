package Queue.Medium;

/**
 * Created by Shuhua Song
 */
public class _622_DesignCircularQueue {

    /*
1-Array-Solution: have concurrency problem, is not thread-safe. It would end up with corrupting data structure in a multi-threaded environment.
Race Condition Example:
e.g an excution sequence where we exceeed the designed capacity of the queue and overwrited the tail element undesirably.
Timeline   Thread#1       Thread#2         Capacity
   1       enQueue()                       count = 4
   2                      enQueue()        count = 4
   3   if(count<capacity)                  count = 4
   4                  if(count<capacity)   count = 4
   5         ....                          count = 4
   6      count += 1                       count = 4
   6                                       count = 5
   7                                       count = 5
   8                    count += 1         count = 6

2-LinkedList-Solution: more memory efficient, it does not pre-allocate memory for unused capacity

*/

    class MyCircularQueue {

        class Node {
            int val;
            Node next;
            public Node(int val){
                this.val = val;
                next = null;
            }
        }

        Node head, tail;
        int size;
        int capacity;

        public MyCircularQueue(int k) {
            this.capacity = k;
        }

        public boolean enQueue(int value) {
            if(size==capacity) return false;
            Node newNode = new Node(value);
            if(size==0){
                head = tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
            }
            size += 1;
            return true;
        }

        public boolean deQueue() {
            if(size==0) return false;
            head = head.next;
            size--;
            return true;
        }

        public int Front() {
            if(size==0) return -1;
            return head.val;
        }

        public int Rear() {
            if(size==0) return -1;
            return tail.val;
        }

        public boolean isEmpty() {
            return size==0;
        }

        public boolean isFull() {
            return size==capacity;
        }
    }

    /*
    class MyCircularQueue {
    int front = 0, tail = -1;
    int size = 0;
    int[] nums;
    int k;
    public MyCircularQueue(int k) {
        nums = new int[k];
        this.k = k;
    }

    public boolean enQueue(int value) {
        if(size < k){
            tail++;
            tail = (tail >= k ? tail%k : tail);
            nums[tail] = value;
            size++;
            return true;
        }else{
            return false;
        }
    }

    public boolean deQueue() {
        if(size<=0) return false;
        front++;
        size--;
        return true;
    }

    public int Front() {
        if(size<=0) return -1;
        front %= k;
        int val = nums[front];
        //front %= k;
        return val;
    }

    public int Rear() {
        if(size <= 0) return -1;
        tail %= k;
        int val = nums[tail];
        return val;
    }

    public boolean isEmpty() {
        return size<=0;
    }

    public boolean isFull() {
        return size >= k;
    }
}
     */
}
