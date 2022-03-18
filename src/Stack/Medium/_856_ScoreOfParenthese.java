package Stack.Medium;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _856_ScoreOfParenthese {

    public int scoreOfParentheses(String s) {
        int n = s.length();
        int balance = -1, ans = 0;
        for(int i=0; i<n-1; i++){
            balance += s.charAt(i)=='(' ? 1 : -1;
            if(s.charAt(i)=='(' && s.charAt(i+1)==')'){
                ans += 1 << balance;
            }
        }
        return ans;
    }

    /*
     public int scoreOfParentheses(String s) {
        return score(s, 0, s.length()-1);
    }
    private int score(String s, int l, int r){
        if(r-l==1) return 1;
        int balance = 0;
        for(int i=l; i<r; i++){
            if(s.charAt(i)=='(') balance++;
            if(s.charAt(i)==')') balance--;
            if(balance==0){
                //score("(A)(B)(C)") = score("(A)") + score("(B)(C)")
                return score(s, l, i) + score(s, i+1, r);
            }
        }
        //score("(A)") = 2 * score("A")
        return 2 * score(s, l+1, r-1);
    }



    //stack store the number from previous layer.
    //when c==')', we need to set:  curr =  stack.pop() + Math.max(2 * curr, 1);

    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(curr);
                curr = 0;
            }else{
                curr = stack.pop() + Math.max(2 * curr, 1);
            }
        }
        return curr;
    }
     */
}


/*
Solution-1: Recursion --- Time = O(n^2)
Case 0 : "()" = 1
Case 1 : The whole string is balanced
Example: "(A)" ===> score = 2 * score("A")
Case 2 : Substring is balance
Example: "(A)(B)(C)"
    score = score("(A)") + score("(B)(C)")
Time Complexity: O(n) ~ O(n^2)
Best case: "()()()....()"
Worst case: "(((((())))))"
Example:
score("((()))")
= 2 * score("(())") case 1
= 2 * 2 * score("()") case 1
= 2 * 2 * 1
= 4       case 0


Solution-2: Counting---Time = O(n)

All scores come from "()"
scan the string from left to right, record the number of open '(' as bal
when see "()", add 2^(bal-1) to the answer
"Convert" the original string into a set of full balance strings

"(()(()))" ====> "(())" + "((()))"
"(()(()))" ====> "(())" + "((()))" + "((()))"

*/
