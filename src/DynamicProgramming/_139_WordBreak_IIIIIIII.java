package DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139_WordBreak_IIIIIIII {

    //Time = O(n^3) Space = O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        //partition the current string into smaller substring s1 = s.substring(0, j) and s2 = s.substring(j+1, i)
        //dp[j] = true, means the s1 can be breaked with words in the wordDict
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    /*
      //Time = O(n^3)
    //Space = O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean helper(String s, HashSet<String> wordSet, int start, Boolean[] memo){
        if(start == s.length()){
            return true;
        }
        if(memo[start] != null) return memo[start];
        for(int end=start+1; end<=s.length(); end++){
            String newS = s.substring(start, end);
            if(wordSet.contains(newS) && helper(s, wordSet, end, memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

     */
}
