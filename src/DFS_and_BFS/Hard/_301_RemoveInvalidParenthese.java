package DFS_and_BFS.Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _301_RemoveInvalidParenthese {
    List<String> results;
    public List<String> removeInvalidParentheses(String s) {
        results = new ArrayList<>();
        int left = 0, right = 0;
        int bal = 0;
        for(char c : s.toCharArray()){
            if(c=='(') left++;
            if(c==')') left--;
            if(left < 0){
                right++;
                left = 0;
            }
        }
        dfs(s, 0, left, right);
        return results;
    }

    private boolean isValid(String s){
        int bal = 0;
        for(char c : s.toCharArray()){
            if(c=='(') bal++;
            if(c==')') bal--;
            if(bal < 0) return false;
        }
        return bal==0;
    }

    private void dfs(String s, int start, int left, int right){
        if(left==0 && right==0){
            if(isValid(s)){
                results.add(s);
                return;
            }
        }
        for(int k=start; k<s.length(); k++){
            if(k!=start && s.charAt(k-1)==s.charAt(k)) continue;
            if(s.charAt(k)=='(' || s.charAt(k)==')'){
                String curr = s.substring(0, k) + s.substring(k+1);
                if(left > 0 && s.charAt(k)=='('){
                    dfs(curr, k, left-1, right);
                }
                if(right>0 && s.charAt(k)==')'){
                    dfs(curr, k, left, right-1);
                }
            }
        }
    }
}
