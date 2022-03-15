package Stack.Medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _71_SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        //sb.append("/");
        for(String p : paths){
            if(p.equals(".") || p.isEmpty()) continue;
            if(p.equals("..")){
                if(!stack.isEmpty()) stack.pollLast();
            }else{
                stack.addLast(p);
            }
        }
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
            sb.append("/");
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }

  /*  public String simplifyPath(String path) {
        if(path==null || path.length()==0) return "";
        String[] combs = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String com : combs){
            if(com.equals(".") || com.isEmpty()){
                continue;
            }else if(com.equals("..")){
                if(!stack.isEmpty()) stack.pop(); // go to up level
            }else{
                stack.push(com);
            }
        }
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        //sb.insert() will cause the time complexity O(n^2), because the when StringBuilder is implemented by char[],
        //all the character need to shift and leave an empty space for the insertion: abc==> _ a b c
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return  sb.toString();
    } */
}

 /*
Intuitive:
e.g:
"/a/./b/../d//e../c/"

note: /a//b ===> [a, , b], there is an empty between a and b

".." : means go up one level, here we pop one component from stack when it is not empty.
"." :  single dot is kind of a no-operation,            because it means the current directory.          So, continue;

1) use '/' as delimilter to split the string
*/