package Trie.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _1268_SearchSuggestionSystem {

    //Binary Search
    //Time = O(n*logn) + O(m*logn), n = length of products, m = length of search word
    //Space = O(1) - > O(n), using for sorting
    private int findIndex(String[] products, int start, String prefix){
        int left = start, right = products.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(products[mid].compareTo(prefix) >= 0){ //word[mid] > prefix
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public List<List<String>> suggestedProducts(String[] products, String search) {
        List<List<String>> results = new ArrayList<>();
        Arrays.sort(products);
        int start = 0, bsStart = 0, n = products.length;
        String prefix = "";
        for(char c : search.toCharArray()){
            prefix += c;
            start = findIndex(products, bsStart, prefix);
            List<String> list = new ArrayList<>();
            int len = prefix.length();
            for(int i=start; i<Math.min(start+3, n); i++){
                if(products[i].length() < len || !products[i].startsWith(prefix)) break;
                list.add(products[i]);
            }
            results.add(list);
            bsStart = start;
        }
        return results;
    }



     /* Trie + DFS
    Time = O(M), M = total # of char in products, creating the tree
    For each prefix, we find its representation node in O(len(prefix)) and dfs to find at most 3 words which is an O(1) operation.
    Space = O(26*n), n = # of nodes in trie */

 /*   class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            isWord = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    List<String> tempList = new ArrayList<>();
    private void insertTree(String p){
        TrieNode curr = root;
        for(char c : p.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
    }

    private void dfsWithPrefix(TrieNode curr, String word){
        if(tempList.size()>=3) return;
        if(curr.isWord) tempList.add(word);
        for(char c='a'; c<='z'; c++){
            if(curr.children[c-'a'] != null)
                dfsWithPrefix(curr.children[c-'a'], word+c);
        }
    }

    private List<String> searchPrefix(String prefix){
        TrieNode curr = root;
        tempList = new ArrayList<>();
        for(char c : prefix.toCharArray()){
            if(curr.children[c-'a']==null){
                return tempList;
            }
            curr = curr.children[c-'a'];
        }
        dfsWithPrefix(curr, prefix);
        return tempList;
    }

    public List<List<String>> suggestedProducts(String[] products, String search) {
        List<List<String>> results = new ArrayList<>();
        for(String p : products){
            insertTree(p);
        }
        String prefix = "";
        for(char c : search.toCharArray()){
            prefix += c;
            results.add(searchPrefix(prefix));
        }
        return results;
    }  */


    /*  Heap
    Time = O(n * m * n), n = length of word search, m = # words in products
    Space = O(m)
    public List<List<String>> suggestedProducts(String[] products, String search) {
        int n = search.length();
        List<List<String>> results = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>((s2, s1)->s1.compareTo(s2));
        for(int i=0; i<n; i++){
            String s = search.substring(0, i+1);
            for(String p : products){
                if(p.startsWith(s)){
                    pq.offer(p);
                    if(pq.size() > 3) pq.poll();
                }
            }
            List<String> list = new ArrayList<>();
            while(!pq.isEmpty()){
                list.add(pq.poll());
            }
            Collections.sort(list);
            results.add(list);
        }
        return results;
    }
     */
}
