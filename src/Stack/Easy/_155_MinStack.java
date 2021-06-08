package Stack.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class _155_MinStack {
    // Solution-#1  Time = O(1) Space = O(1)
    /** initialize your data structure here. */
    Stack<int[]> stack;
    public _155_MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val, val});
            return;  //!!! remember to return when stack is Empty
        }
        //To use the
        //int curMin = stack.peek()[1];
        stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
    }


    public void pop() {
        stack.pop();
    }

    public  int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }


    //Solution-#2  Time = O(1) Space = O(1)
 /*   Stack<Integer> stack;
    Stack<Integer> minStack;

    public _155_MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    // If we use stack.peek()==minStack.peek(), it compare the address of the peek element;
    // so we need to use stack.peek().equals(minStack.peek()), it compare the content of element, like String
    public void pop() {
        int val = stack.peek();
        if(val==(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
    }

    public  int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
*/

    //  Solution-#3  Time = O(nlogn)  Space = O(n)
    /** initialize your data structure here. */
 /*   List<Integer> list;
    PriorityQueue<Integer> pq;
    public _155_MinStack() {
        list = new ArrayList<>();
        pq = new PriorityQueue<>();
    }

    public void push(int val) {
        list.add(val);
        pq.add(val);
    }

    public void pop() {
        int val = list.remove(list.size()-1);
        if(pq.peek()==val){
            pq.poll();
        }
    }

    public  int top() {
        int val = list.get(list.size()-1);
        return val;
    }

    public int getMin() {
        int val = pq.peek();
        while(!list.contains(val)){
            pq.poll();
            val = pq.peek();
        }
        return val;
    }  */

}