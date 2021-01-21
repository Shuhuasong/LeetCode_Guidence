package DynamicProgramming.Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_WordBreak {

    //Time = O(n^3) Space = O(n)
    public boolean wordBreak(String s, List<String> wordDict) {

        return dfs(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean dfs(String s, Set<String> dict, int start, Boolean[] memo){
        if(start==s.length()){
            return true;
        }
        if(memo[start]!=null){
            return memo[start];
        }
        for(int len=start+1; len<=s.length(); len++){
            if(dict.contains(s.substring(start, len)) && dfs(s, dict, len, memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
