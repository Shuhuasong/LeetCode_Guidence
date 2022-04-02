package Trie.Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _140_WordBreak_II {
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
    List<String> results;
    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        memo = new boolean[s.length()+1];
        results = new ArrayList<>();
        buildTree(wordDict);

        List<String> words = new ArrayList<>();
        dfs(s, 0, words);
        return results;
    }

    private boolean dfs(String s, int start, List<String> words){
        if(start==s.length()){
            StringBuilder sb = new StringBuilder();
            for(String w : words) sb.append(w).append(" ");
            sb.deleteCharAt(sb.length()-1);
            results.add(sb.toString());
            return true;
        }
        if(memo[start]) return false;
        TrieNode curr = root;
        boolean flag = false;
        for(int i=start; i<s.length(); i++){
            char c = s.charAt(i);
            if(curr.children[c-'a']!=null){
                curr = curr.children[c-'a'];
                if(curr.isWord){
                    words.add(s.substring(start, i+1)); //add s[start, i] is a word
                    if(dfs(s, i+1, words)){
                        flag = true;
                    }
                    //remove the last word, to collect a longer word next round
                    words.remove(words.size()-1);
                }
            }else{
                break;
            }
        }
        if(flag==false)
            memo[start] = true;
        return flag;
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
}
