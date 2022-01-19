package Greedy.Medium;

/**
 * Created by Shuhua Song
 */
public class _921_MinimumAddToMakeParentheseValid {
    public int minAddToMakeValid(String s) {
        int res = 0, count = 0;
        for(char c : s.toCharArray()){
            if(c==')') count--;
            else
                count++;
            if(count < 0){
                res++;
                count++;
            }
        }
        return res+count;
    }

    /*
     public int minAddToMakeValid(String s) {
       int res = 0, count = 0;
       Stack<Character> stack = new Stack<>();
       for(char c : s.toCharArray()){
          if(!stack.isEmpty() && stack.peek()=='(' && c==')'){
               stack.pop();
          }else{
              stack.push(c);
          }
       }
        return stack.size();
    }
     */
}

/*
)  (  )  )  )
-1 1  0  -1

( (  ( )
1 2  3 2

( ( ( ) ) )
1 2 3 3 2 1
( ) )  ( ( ) ) ( ( ( (
1 0 -1 1 2 1 0
     1
*/
