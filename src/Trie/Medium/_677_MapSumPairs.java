package Trie.Medium;

import java.util.HashMap;
import java.util.Map;

public class _677_MapSumPairs {

    //Trie
    //Time = O(K), K == the length of the key every sum operation
    //Space = linear
    class TrieNode{
        int score;
        TrieNode[] children;
        TrieNode(){
            score = 0;
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    Map<String, Integer> map;

    public _677_MapSumPairs() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode curr = root;
        for(char ch : key.toCharArray()){
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
            curr.score += diff;
        }
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        for(char ch : prefix.toCharArray()){
            if(curr.children[ch-'a']==null){
                return 0;
            }
            curr = curr.children[ch-'a'];
        }
        return curr.score;
    }

    /* Brute force
    //Time = O(N*P), N = the number of items, P = the length of input prefix
    Map<String, Integer> map = new HashMap<>();
    public MapSum() {

    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int total = 0;
        for(String key : map.keySet()){
            if(key.startsWith(prefix)){
                total += map.get(key);
            }
        }
        return total;
    }
     */



    /*
    //Prefix HashMap
    //Time = O(K^2) K = the length of the key

    Map<String, Integer> map;
    Map<String, Integer> score;
    public MapSum() {
         map = new HashMap<>();
         score = new HashMap<>();
    }

    public void insert(String key, int val) {
           int diff = val - map.getOrDefault(key, 0);
           map.put(key, val);
           String prefix = "";
           for(char c : key.toCharArray()){
               prefix += c;
               score.put(prefix, score.getOrDefault(prefix, 0) + diff);
           }
        }

    public int sum(String prefix) {
        return score.getOrDefault(prefix, 0);
    }
     */


    /*
     class TrieNode {
        String word = "";
        TrieNode[] children = new TrieNode[26];

        public void insert(String word){
            TrieNode curr = this;
            for(char c : word.toCharArray()){
                if(curr.children[c-'a']==null){
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.word = word;
        }
    }
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        root.word = "$";
        for(String word : words){
             root.insert(word);
        }
        return dfs(root, "");
    }

    private String dfs(TrieNode node, String currSt){
        if(node==null || node.word.length()==0){
            return currSt;
        }
        if(!node.word.equals("$")){
            currSt = node.word;
        }
        String res = "";
        for(TrieNode child : node.children){
             String childRes = dfs(child, currSt);
            if(childRes.length() > res.length() || (childRes.length()==res.length() && childRes.compareTo(res) < 0)){
                res = childRes;
            }
        }
        return res;
    }
     */


}

/*
Trie Solution:
Since the question is about find the prefix, so we can use trie(prefix Tree).
Build a trie in a general way, then do dfs to find the longes (continuous) downward path from
root.
*/


