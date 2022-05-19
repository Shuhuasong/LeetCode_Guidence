import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class Test4 {

    public static List<String> printTags(String s)
    {
        Stack<Integer> stack = new Stack<>();
        List<String> results = new ArrayList<>();
        char[] chs = s.toCharArray();
        int i = 0, n = chs.length;
        while(i < n){
            int right = i;
            if(chs[right]=='<'){
                if(right+1<n && chs[right+1]=='/'){
                    while(chs[right]!='>') {
                        right++;
                    }
                    int left = stack.pop();
                    System.out.println("pop : " + left + " == " + right + " --- " + s.substring(right-5, right+1));
                    String tagContent = s.substring(left, right+1);
                    results.add(tagContent);
                    i = right;
                }else{
                    stack.push(right);
                    if(s.substring(right,right+5).equals("<inpu")) stack.pop();
                }
            }
            i++;
        }
        return results;
    }
    public static void main(String[] args) {
        String paragraph = "<div><label>First Name<sup>*</sup></label><div><input type=\\\"text\\\" name=\\\"firstname\\\"/></div></div>\"<div>test</div>";
        List<String> results = printTags(paragraph);
        for(String word : results){
            System.out.println(word);
        }
    }
}
