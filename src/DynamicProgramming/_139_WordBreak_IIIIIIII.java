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
     class TrieNode{
       TrieNode[] children;
       boolean isWord;
       public TrieNode(){
           children = new TrieNode[26];
           isWord = false;
       }
   }
    TrieNode root;
    boolean[] memo; //save the position which is failure
   public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        memo = new boolean[s.length()];
        buildTree(wordDict);
        return dfs(s, 0);
    }

    private boolean dfs(String s, int start){
        if(start==s.length()) return true;
        if(memo[start]) return false;
        TrieNode curr = root;
        for(int i=start; i<s.length(); i++){
            char c = s.charAt(i);
            if(curr.children[c-'a']!=null){
                curr = curr.children[c-'a'];
                if(curr.isWord && dfs(s, i+1)){
                    return true;
                }
            }else{
                break;
            }
        }
        memo[start] = true;
        return false;
    }

    private void buildTree(List<String> wordDict){
        for(String word : wordDict){
             TrieNode curr = root;
            for(char c : word.toCharArray()){
                if(curr.children[c-'a']==null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isWord = true;
        }
    }
     */



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
