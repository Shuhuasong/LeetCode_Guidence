package Stack.Hard;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _224_BasicCalcultor {

    public int calculate(String s) {
        if(s==null || s.length()==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int sign = 1, res = 0, n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int val = c - '0';
                while(i+1 < n && Character.isDigit(s.charAt(i+1))){
                    val = val * 10 + (s.charAt(i+1)-'0');
                    i++;
                }
                res += sign * val;
            }else if(c=='+'){
                sign = 1;
            }else if(c=='-'){
                sign = -1;
            }else if(c=='('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }else if(c==')'){
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}
