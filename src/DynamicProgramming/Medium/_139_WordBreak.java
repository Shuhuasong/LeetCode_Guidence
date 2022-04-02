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


    /* //faster than DP
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


}
