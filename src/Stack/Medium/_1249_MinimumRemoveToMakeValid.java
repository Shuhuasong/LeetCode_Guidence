package Stack.Medium;

/**
 * Created by Shuhua Song
 */
public class _1249_MinimumRemoveToMakeValid {

    //Two Pass StringBuilder
    //Time = O(n), Space = O(n)
    public String minRemoveToMakeValid(String s) {
        if(s==null || s.length()==0) return "";
        int n = s.length();
        int open = 0, balance = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c=='('){
                open++;
                balance++;
            }else if(c==')'){
                if(balance==0) continue;
                balance--;
            }
            sb.append(c);
        }
        int openMove = open-balance;
        StringBuilder res = new StringBuilder();
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(c=='('){
                openMove--;
                if(openMove < 0) continue;
            }
            res.append(c);
        }
        return res.toString();
    }

    /*
     //Two Pass
    public String minRemoveToMakeValid(String s) {
        if(s==null || s.length()==0) return "";
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else if(c==')'){
                if(!stack.isEmpty() && s.charAt(stack.peek())=='('){
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        while(!stack.isEmpty()){
            set.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(set.contains(i)) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
     */




    /*
   public String minRemoveToMakeValid(String s) {
        //pass1 from left to right: remove all invalid ')'
        StringBuilder sb = new StringBuilder();
        int bal = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(') bal++;
            else if(c==')'){
                if(bal==0) continue;
                bal--;
            }
            sb.append(c);
        }
        //pass2 from right to left: remove all invalid '('
        StringBuilder result = new StringBuilder();
        bal = 0;
        for(int i=sb.length()-1; i>=0; i--){
            char c = sb.charAt(i);
            if(c==')') bal++;
            else if(c=='('){
                if(bal==0) continue;
                bal--;
            }
            result.append(c);
        }
        return result.reverse().toString();
    }
     */
}
