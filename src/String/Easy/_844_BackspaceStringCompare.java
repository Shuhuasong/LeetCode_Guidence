package String.Easy;

/**
 * Created by Shuhua Song
 */
public class _844_BackspaceStringCompare {

    //Two Pointer: Time = O(m+n)
    public boolean backspaceCompare(String s, String t) {
        int m = s.length(), n = t.length();
        int p1 = m-1, p2 = n-1;
        int move1 = 0, move2 = 0;
        while(p1>=0 || p2>=0){
            while(p1 >= 0){
                if(s.charAt(p1)=='#'){
                    move1++; p1--;
                }else if(move1>0){ move1--; p1--;}
                else break;
            }
            while(p2 >= 0){
                if(t.charAt(p2)=='#'){
                    move2++; p2--;
                }else if(move2>0){ move2--; p2--;}
                else break;
            }
            if(p1>=0 && p2>=0 && s.charAt(p1)!=t.charAt(p2)) return false;
            if((p1>=0) != (p2>=0)) return false;
            p1--;
            p2--;
        }
        return true;
    }

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
