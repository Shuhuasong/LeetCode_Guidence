package Stack.MonotonicStack;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _739_DailyTemperatures {
    //Monotonic Stack
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int i = 0;
        while(i < n){
            while(!stack.isEmpty() && temps[stack.peek()] < temps[i]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
            i++;
        }
        return res;
    }
}
