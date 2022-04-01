package Stack.MonotonicStack;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _901_OnlineStockSpan {
    Stack<int[]> stack;
    public _901_OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int res = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            res += stack.pop()[1];
        }
        stack.push(new int[]{price, res});
        return res;
    }
}
