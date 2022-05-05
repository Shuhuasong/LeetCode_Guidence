package Design.Easy;

/**
 * Created by Shuhua Song
 */
public class _225_ImplementStackUsingQueue {

    /* Time = O(1), Space = O(n)
     Queue<Integer> q1, q2;
    int top = -1;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
        top = x;
    }

    public int pop() {
        while(q1.size()>1){
            top = q1.poll();
            q2.add(top);
        }
        int val = q1.poll();
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        return val;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
     */
}
