package String;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _394_DecodeString {

    public String decodeString(String s) {
        if(s==null || s.length()==0) return s;
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c != ']'){
                stack.push(c);
            }else{
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '['){
                    sb.append(stack.pop());
                }

                stack.pop();
                int time = 0, base = 1;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    time = time + base * (int)(stack.pop()-'0');
                    base *= 10;
                }
                String st = sb.toString();
                //System.out.println(st + " " + time);
                int len = st.length();
                for(int t=0; t<time; t++){
                    for(int j=len-1; j>=0; j--){
                        stack.push(st.charAt(j));
                    }
                }
            }
        }
        StringBuilder sbR = new StringBuilder();
        while(!stack.isEmpty()){
            sbR.insert(0, stack.pop());
        }
        return sbR.toString();
    }
}
