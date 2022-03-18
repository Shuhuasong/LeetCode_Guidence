package Greedy.Easy;

/**
 * Created by Shuhua Song
 */
public class _1614_MaximumNestingDepthOfTheParenthese {
    //Rolling State
    public int maxDepth(String s) {
        int bal = 0, res = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                bal++;
            }else if(c==')'){
                bal--;
            }
            res = Math.max(res, bal);
        }
        return res;
    }
}
