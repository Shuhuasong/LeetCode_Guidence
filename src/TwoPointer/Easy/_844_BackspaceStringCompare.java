package TwoPointer.Easy;

import java.util.Stack;

public class _844_BackspaceStringCompare {

    //Stack:  Time = O(m+n) Space = O(1)
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String S){
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            if(c!='#'){
                stack.push(c);
            }else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }


    //Two Pointer : Time = O(m+n) Space = O(1)
 /*   public boolean backspaceCompare(String S, String T) {
        if(S==null && T==null) return true;
        if(S==null || T==null) return false;
        int m = S.length(), n = T.length();
        int i=m-1, j=n-1;
        int skipS = 0, skipT = 0;
        while(i>=0 || j>=0){
            while(i>=0){ //Find position of next possible char in S
                if(S.charAt(i)=='#'){
                    skipS++;
                    i--;
                }else if(skipS > 0){
                    skipS--;
                    i--;
                }else{
                    break;
                }
            }

            while(j>=0){//Find position of next possible char in T
                if(T.charAt(j)=='#'){
                    skipT++;
                    j--;
                }else if(skipT > 0){
                    skipT--;
                    j--;
                }else{
                    break;
                }
            }
            //If two actual characters are different
            if(i>=0 && j>=0 && S.charAt(i) != T.charAt(j)){
                return false;
            }
            //if expecting to compare char VS nothing
            if((i>=0) != j>=0) return false;
            i--;
            j--;
        }
        return true;
    }

  */
}
