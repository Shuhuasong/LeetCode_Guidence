package Trie.Medium;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Shuhua Song
 */
public class _720_LongestWordInDictionary {

    public String longestWord(String[] words) {
        Arrays.sort(words);
        String res = "";
        HashSet<String> buildWords = new HashSet<>();
        for(String w : words){
            if(w.length()==1 || buildWords.contains(w.substring(0, w.length()-1))){
                if(w.length() > res.length())
                    res = w;
                buildWords.add(w);
            }
        }
        return res;
    }

    /*
    //Time = O(SUM(wi^2)), wi is the length of words[i];
    //check wether all prefixes of words[i] are in the set is O(SUM(wi^2))
    //Space = O(SUM(wi^2)), to create the substring

     public String longestWord(String[] words) {
        Arrays.sort(words, (a, b)->{
        //when length are the same, word with smaller lexicographical come first
            if(a.length()==b.length()){
                return a.compareTo(b);
            }else{
                return b.length()-a.length();//length different==> longer word come first
            }
        });
        Set<String> set = new HashSet<>();
        for(String word : words) set.add(word);
        int n = words.length;
        String res = "";
        for(String w : words){
             boolean isValid = true;
             for(int j=0; j<w.length(); j++){
                  if(!set.contains(w.substring(0, j+1))){
                      isValid = false;
                      break;
                  }
             }
            if(isValid){
                return w;
            }
        }
        return "";
    }
     */

    /*
     //Trie + BFS
    class TrieNode{
        String word = "";
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
           children  = new TrieNode[26];
        }
    }


    class Trie {
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                if(curr.children[c-'a']==null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.word = word;
            curr.isWord = true;
        }

        private String bfs(){
            String result = "";
            Queue<TrieNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                TrieNode node = q.poll();
                //from last char to first char, in order to get smaller lexicographical order word
                    for(int j=25; j>=0; j--){
                        if(node.children[j] != null && node.children[j].isWord){
                            result = node.children[j].word;
                            q.offer(node.children[j]);
                        }
                    }
            }
            return result;
        }
    }


    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String word : words){
             trie.insert(word);
        }
        return trie.bfs();
    }
     */
}
