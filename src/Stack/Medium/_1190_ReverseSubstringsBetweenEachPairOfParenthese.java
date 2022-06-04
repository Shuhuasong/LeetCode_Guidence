package Stack.Medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _1190_ReverseSubstringsBetweenEachPairOfParenthese {

    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c!=')'){
                stack.push(c);
            }else{
                //c==')'
                Queue<Character> q = new LinkedList<>();
                while(!stack.isEmpty() && stack.peek() != '('){
                    q.add(stack.pop());
                }
                stack.pop();
                while(!q.isEmpty()){
                    stack.push(q.poll());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
