package String;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _394_DecodeString {


    int idx = 0;
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        while(idx < s.length() && s.charAt(idx)!=']'){
            if(Character.isDigit(s.charAt(idx))){
                int time = 0;
                while(idx<s.length() && Character.isDigit(s.charAt(idx))){
                    time = time * 10 + s.charAt(idx)-'0';
                    idx++;
                }
                idx++; //skip '['
                String nextStr = decodeString(s);
                idx++;  //skip ']'
                for(int t=0; t<time; t++){
                    result.append(nextStr);
                }
            }else{
                result.append(s.charAt(idx));
                idx++;
            }
        }
        return result.toString();
    }
    
    /*

    //Time = O(M^k * n), M = maximum of repeat time, k = the number of nested, n = the maxLen of word
    //Space = O(sum(M^k * n)
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
     */
}




/*
"3[a2[c]]"
    acc
 acc,acc,acc


Solution-Stack
Time = O(M^K * n)
M = 13, K = 2, n = maxLen

Note:
1) the number of repeat over 10 times:

   case-1  : "3[a]2[bc2[dd]]"
                  |
                      bc,dd,dd    bc,dd,dd

     sb = a   time =  3   base = 1
3             time = time + base * curDigit
1             time = 3 + 10 * 1
              base *= 10


      c
 c    b        sb =  c b   time      c b
 b    c
 [
 2    b
 a    a        sbRes = cbcbaaa          sbRes.insert(0, curChar) ==> sb  O(n^2) ==> O(n)
 a    a
 a    a        ==> reverse
               result = aaabcbc

2) the order of character push back to stack
      c
 c    b        sb =  c b   time      c b
 b    c              |
 2    b
 a    a        sbRes = cbcbaaa          sbRes.insert(0, curChar) ==> sb  O(n^2) ==> O(n)
 a    a
 a    a        ==> reverse
               result = aaabcbc

wrong way:
 b    sbRes = bcbcaaa ===> reverse = res = aaacbcb
 c
 b
 c
 a
 a
 a

"100[leetcode]"
wrong output: ""



Solution-2-Recursion
Time = O(maxK * n)
Space = O(n)
k[word1 2[word2]]k[word3]
            word2word2
   |

1) collect a result String when char is [a-z]
2) get repeat time when char is digit (note: over 10)
3) Decode the current pattern K[word] and add it to result
   result = result + nextString
4) base case:  end of string  || the char is ']'

s = " 3 [ a ] 2 [ b c ]"
          |
nextSt = a
time = 3
result = aaa
*/




