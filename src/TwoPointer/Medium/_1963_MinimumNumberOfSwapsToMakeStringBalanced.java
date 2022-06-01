package TwoPointer.Medium;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _1963_MinimumNumberOfSwapsToMakeStringBalanced {

    public int minSwaps(String s) {
        int misMatch = 0;//misMatch_Pair
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='['){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    misMatch++;
                }
            }
        }
        if(misMatch%2==0) return misMatch/2;
        return (misMatch+1)/2;
    }

    /*

    public int minSwaps(String s) {
        int open = 0, close = 0;
        int left = 0, right = s.length()-1;
        int res = 0;
        while(left < right){
            char c = s.charAt(left);
            if(c=='['){
                open++;
            }else{
                close++;
            }
            //when close > open, there is mismatch, so need to swop with open
            if(close > open){
                //from right, find a open
                while(right > left && s.charAt(right)==']'){
                    right--;
                }
                //until find the open, we update result, meaning this is a pair need to swap
                res++;
                //then update the close and open, meaning with one more open, less one close
                close--;
                open++;
            }
            left++;
        }
        return res;
    }

     */

}

/*
Solution-1: Stack
1) use stack to store open '(' when encounter
2) if the current is ')', we check if the stack have '(',
   if have, then pop; otherwise, we increase misMatch
3) if misMatch is even when misMatch%2==0, then need to swap (misMathch/2) times
   if misMatch is odd when misMatch%2==1, then need to swap (misMatch+1)/2 times

   e.g.
case-1:  ]]] [[[  misMatch = 3, swap = (misMatch+1)/2
case-2:  ]]]] [[[[  misMatch = 4, swap = (misMatch+1)/2


Solution-2: Two Pointer
1) Iterate over the string and keep track of the number of opening and closing brackets on each step.
2) If the number of closing brackets is ever larger, you need to make a swap.
3) after swap, need to update the number of opening and closing:
   closing--, opening++
*/