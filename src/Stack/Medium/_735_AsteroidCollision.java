package Stack.Medium;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _735_AsteroidCollision {
    public int[] asteroidCollision(int[] aste) {
        int n = aste.length;
        if(n<=1) return aste;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            if(stack.isEmpty()){
                stack.push(aste[i]);
            }else{
                //peek > 0 && curr < 0==> collision
                if(stack.peek() > 0 && aste[i] < 0){
                    //peek < curr == > pop, ga back
                    if(Math.abs(stack.peek()) < Math.abs(aste[i])){
                        stack.pop();
                        i--;
                        //peek = curr, cancel
                    }else if(Math.abs(stack.peek()) == Math.abs(aste[i])){
                        stack.pop();
                    }
                    //peek <=0 or curr >= 0
                }else{
                    stack.push(aste[i]);
                }
            }
        }
        int[] res = new int[stack.size()];
        int i = stack.size()-1;
        while(!stack.isEmpty()){
            res[i--] = stack.pop();
        }
        return res;
    }
}
