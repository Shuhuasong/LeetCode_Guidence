package Trie.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _211_DesignAddAndSearchWordsDataStructure {
    class TrieNode {
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        public TrieNode() { }
    }

    TrieNode root;
    public _211_DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    //Time = O(M), M is the length of word; at each step, we either examine or
    //create a node in the trie.
    //Space = O(M). the worst-case when the newly inserted key doesn't share a
    //prefix with the keys already inserted in the trie. Then need to add M new
    //nodes, which take O(M) space.
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        if(word.length()==0) return true;
        return searchInTrie(word, 0, root);
    }

    //word without dots: Time = O(M), M is the length of word
    //word with dots: Time = O(N*26^M), N is the number of words, for each char in word,
    //there are 26 possible to explore
    //Space = O(1)
    private boolean searchInTrie(String word, int index, TrieNode root){
        if(index==word.length()) return root.isWord;
        char ch = word.charAt(index);
        //if the current character is '.', check all possible nodes at this level
        if(ch=='.'){
            for(TrieNode child : root.children){
                if(child!=null && searchInTrie(word, index+1, child)){
                    return true;
                }
            }
        }
        //if the character is found, then go down to the next level in trie
        else if(root.children[ch-'a'] != null){
            return searchInTrie(word, index+1, root.children[ch-'a']);
        }
        //if the character is not found, then the word is not exist in the trie
        return false;
    }
}

/*

    The solution is not efficient for most important use cases:
    1) Finding all keys with a common prefix.
    2) Enumerating a dataset of strings in lexicographical order.
    3) Scalling for the large datasets. Once the hash table increase in size, there
       are a lot of hash collisions and the search time complexity could degrade to
       O(N^2*M), where N is the number of the inserted keys.
    Trie use less space compared to hashmap when storing many keys with the same prefix.
    In this case, time complexity is only O(N*M)

    Map<Integer, Set<String>> map;
    public WordDictionary() {
        map = new HashMap<>();
    }


    public void addWord(String word) {
        int len = word.length();
        map.putIfAbsent(len, new HashSet<String>());
        map.get(len).add(word);
    }

    //Time = O(N*M), N = numbers of words, M = length of word
    public boolean search(String word) {
        int len = word.length();
        if(!map.containsKey(len)) return false;
        Set<String> words = map.get(len);
        for(String w : words){
            int i = 0;
            while(i<len && (w.charAt(i)==word.charAt(i) || word.charAt(i)=='.')){
                i++;
            }
            if(i==len) return true;
        }
        return false;
    }
 */



