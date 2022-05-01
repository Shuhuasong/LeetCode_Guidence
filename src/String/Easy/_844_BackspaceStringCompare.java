package String.Easy;

/**
 * Created by Shuhua Song
 */
public class _844_BackspaceStringCompare {

    /*
    public boolean backspaceCompare(String s, String t) {
        if(s.length()==0 && t.length()==0) return true;
        return getStr(s).equals(getStr(t));
    }

    private String getStr(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='#'){
                if(!stack.isEmpty())
                    stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop());
        s = sb.toString();
        return s;
    }
     */
}
