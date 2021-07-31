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
}
