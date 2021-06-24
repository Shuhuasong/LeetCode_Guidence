package Backtrack.Medium;

import java.util.ArrayList;
import java.util.List;

public class _22_GenerateParentheses {
    //Time = O(2^(2*n)) = 4^n, lenght(n) = height = 2*n,  Space =  O(2^(2*n)) = 4^n
    //only add open paranthesis when open < n;
    //only add a closing paranthesis when close < open
    //valid iff open == close == n

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        if(n==0) return results;
        StringBuilder sb = new StringBuilder();
        backtrack(results, sb, 0, 0, n);
        return results;
    }

    private void backtrack(List<String> results, StringBuilder sb, int open, int close, int n){
        if(open==n && close==n){
            results.add(sb.toString());
        }
        if(open < n){
            sb.append("(");
            backtrack(results, sb, open+1, close, n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close < open){
            sb.append(")");
            backtrack(results, sb, open, close+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
