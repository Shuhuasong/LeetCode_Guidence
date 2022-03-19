package Stack.Medium;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        boolean[] used = new boolean[26];
        for(char c : s.toCharArray()) count[c-'a']++;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            count[c-'a']--;//use one char, substract 1
            if(used[c-'a']) continue;//if current char was used, continue
            //otherwise, if current char is  c < stack.peek(), and we still have char(stack.peek()),
            //pop it from stack, and mark it unused
            while(!stack.isEmpty() && stack.peek()>c && count[stack.peek()-'a'] > 0){
                used[stack.peek()-'a'] = false;
                stack.pop();
            }
            //mark the current character is used
            used[c-'a'] = true;
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
