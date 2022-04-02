package Trie.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _472_ConcatenatedWords {
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }
    TrieNode root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b)->a.length()-b.length());
        root = new TrieNode();

        List<String> results = new ArrayList<>();
        for(String word : words){
            if(!word.equals("") && isValid(word)){
                results.add(word);
            }
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(node.children[c-'a']==null){
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.isWord = true;
        }
        return results;
    }

    private boolean isValid(String word){
        boolean[] visited = new boolean[word.length()];
        return dfs(word, 0, visited);
    }

    private boolean dfs(String word, int idx, boolean[] visited){
        if(idx==word.length()) return true;
        if(visited[idx]) return false;
        TrieNode curr = root;
        for(int i=idx; i<word.length(); i++){
            if(curr.children[word.charAt(i)-'a'] != null){
                curr = curr.children[word.charAt(i)-'a'];
                if(curr.isWord && dfs(word, i+1, visited)){
                    return true;
                }
            }else{
                break;
            }
        }
        //remark the place which is failed
        visited[idx] = true;
        return false;
    }
}

/*
Solution: Trie
1) Sort the words dictionary according to the length
2) iterate each word from shortest length to check if the word can be
   segemented by several words by finding words in Tree
3) After finish check the current word, add it into Tree so that the word
   after can check depend on this
4) to do the memoization for dfs: words = {"a", "aa", "aaa", ....}
*/
