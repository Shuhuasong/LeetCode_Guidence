package Stack.Medium;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _227_BasicCalculatorII {
    public int calculate(String s) {
        if(s==null || s.length()==0) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int currNum = 0, v = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currNum = currNum * 10 + (c-'0');
            }
            if(isOperator(c) || i==len-1){
                if(operator=='+'){
                    stack.push(currNum);
                }else if(operator=='-'){
                    stack.push(-currNum);
                }else if(operator=='*'){
                    v = currNum * stack.pop();
                    stack.push(v);
                    // System.out.println("v1 = " + v);
                }else if(operator=='/'){
                    v = stack.pop()/currNum;
                    stack.push(v);
                    //System.out.println("v2 = " + v);
                }
                operator = c;
                currNum = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            int val = stack.pop();
            res += val;
            // System.out.println(res + " " + val);
        }
        return res;
    }

    private boolean isOperator(char c){
        return (c=='+' || c=='-' || c=='*' || c=='/');
    }
}
