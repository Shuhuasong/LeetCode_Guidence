package Stack.MonotonicStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _1762_BuildingsWithAnOceanView {

    //Time = O(n), Space = O(n)
    public int[] findBuildings(int[] h) {
        Stack<Integer> stack = new Stack<>();
        int n = h.length;
        for(int i=n-1; i>=0; i--){
            if(!stack.isEmpty() && h[stack.peek()] >= h[i]){
                continue;
            }else{
                stack.push(i);
            }
        }
        if(stack.isEmpty()) return new int[0];
        int size = stack.size();
        int[] res = new int[size];
        int i = 0;
        while(!stack.isEmpty()){
            res[i++] = stack.pop();
        }
        Arrays.sort(res);
        return res;
    }
}

/*
Intuitive-monotonik stack
iterate the array from the last building, and keep an
increasing stack. Once we find the current building
if lower than previous building, we will not push the
index into stack. Otherwise, push it;
Finally, the content in the stack are the result with
index we need.
*/

