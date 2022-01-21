package Stack.Medium;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _71_SimplifyPath {

    public String simplifyPath(String path) {
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
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return  sb.toString();
    }
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