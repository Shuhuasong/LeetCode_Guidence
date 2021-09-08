package OnlineCodingChallege.Cisco;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _394_DecodeString {

    public String decodeString(String s) {
        if(s.length()==0) return "";
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<chs.length; i++){
            if(chs[i] != ']'){
                stack.push(chs[i]);
            }else{
                List<Character> decode = new ArrayList<>();
                while(stack.peek() != '['){
                    decode.add(stack.pop());
                }
                stack.pop();
                int base = 1;
                int k = 0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = k + (stack.pop()-'0') * base;
                    base *= 10;
                }
                while(k != 0){
                    for(int j=decode.size()-1; j>=0; j--){
                        stack.push(decode.get(j));
                    }
                    k--;
                }
            }
        }
        char[] result = new char[stack.size()];
        for(int i=result.length-1; i>=0; i--){
            result[i] = stack.pop();
        }
        return new String(result);
    }
}
