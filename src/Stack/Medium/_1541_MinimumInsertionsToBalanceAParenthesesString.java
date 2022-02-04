package Stack.Medium;

/**
 * Created by Shuhua Song
 */
public class _1541_MinimumInsertionsToBalanceAParenthesesString {
    public int minInsertions(String s) {
        int left = 0, res = 0;
        int n = s.length();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                left++;
            }else{
                //if have two consecutive ')', cancel one '('
                if(i+1 < n && s.charAt(i+1)==')'){
                    left--;
                    i++;
                }else{
                    //if only have one sigle ')', then need to add one ')' by incrase res += 1
                    //and cancel one '('
                    res++;
                    left--;
                }
            }
            //if the ')' too many, we need to add '(' by increase res += 1
            //and reset left = 0
            if(left < 0){
                res++;
                left = 0;
            }
        }
        res += left * 2; //each left parenthesis have 2 ')'
        return res;
    }

    /*
      //Stack
    public int minInsertions(String s) {
       Stack<Character> stack = new Stack<>();
       int res = 0, n = s.length();
       int i = 0;
       while(i < s.length()){
           char c = s.charAt(i);
           if(c=='('){
               stack.push(c);
               i++;
           }else if(i+1 < n && s.substring(i, i+2).equals("))")){
               //1> with 2 consecutive close ')'
               if(stack.isEmpty()){
                   res++;//add one open parenthesis
               }else{
                   stack.pop();
               }
               i += 2;
           }else if(c==')'){
               //2> with 1 close ')'
               if(stack.isEmpty()){
                   res += 2; //add one open and one close
               }else{
                   res += 1; //add one close
                   stack.pop(); //pop the open one
               }
               i++;
           }
       }
        res += stack.size() * 2;
        return res;
    }
     */
}

/*
1) Stack

2) Greedy
   leftCount == unmatched left parenthesis
   1> two consecutive ')' to cancel one '('
   2> in the end, res += 2 * leftCount;

"))())("
"())"
"(()))"
"))())("
*/
