package Stack.MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Shuhua Song
 */
public class _402_Remove_K_Digits_IIIIIIII {
    //Greedy With Stack
    //Time = O(n)
    public String removeKdigits(String num, int k) {
        char[] chs = num.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<chs.length; i++){
            while(!stack.isEmpty() && k>0 && stack.peekLast() > chs[i]){
                stack.pollLast(); k = k-1;
            }
            stack.addLast(chs[i]);
        }
        for(int i=0; i<k; i++){
            stack.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && stack.peekFirst()=='0'){
            stack.pollFirst();
        }
        while(!stack.isEmpty()) sb.append(stack.pollFirst());
        return sb.length()==0 ? "0" : sb.toString();
    }
}

/*
num = {1, 2, 3, 4, 5, 2, 6, 4}, k = 4
                    |
              |     |
           |  |     |  |
        |  |  |     |  |
     |  |  |  |  |  |  |
  |  |  |  |  |  |  |  |
       ++++++++     +
  1  2  3  4  5  2  6  4

case-1:
Input
"10200"
1
Output
"0200"
Expected
"200"

case-2:
Input
"9"
1
Output
"9"
Expected
"0"
*/

