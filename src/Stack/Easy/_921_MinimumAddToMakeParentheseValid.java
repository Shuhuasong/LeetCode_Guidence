package Stack.Easy;

/**
 * Created by Shuhua Song
 */
public class _921_MinimumAddToMakeParentheseValid {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(') open++;
            else{
                if(open > 0)
                    open--;
                else
                    close++;
            }
        }
        return open+close;
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
