package Stack.Easy;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _20_ValidParenthese {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;
                int topC = stack.pop();
                if(c==')' && topC!='(') return false;
                else if(c==']' && topC!='[') return false;
                else if(c=='}' && topC!='{') return false;
            }
        }
        return stack.isEmpty();
    }
}
