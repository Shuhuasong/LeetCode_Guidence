package Trie.Medium;

/**
 * Created by Shuhua Song
 */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


/*
Solution 1: Trie Implementation using Array

In insert() Method we insert a key by searching into the trie. We start from the root and search a link, which corresponds to the first key character. There are two cases:
A link exists. Then we move down the tree following the link to the next child level. The algorithm continues with searching for the next key character.

A link does not exist. Then we create a new node and link it with the parent's link matching the current key character. We repeat this step until we encounter the last character of the key, then we mark the current node as an end node and the process ends.

search() Method: Each key is represented in the trie as a path from the root to the internal node or leaf. We start from the root with the first key character. We examine the current node for a link corresponding to the key character. There are two cases :
A link exist. We move to the next node in the path following this link, and proceed searching for the next key character.

A link does not exist. If there are no available key characters and current node is marked as isEnd we return true. Otherwise there are possible two cases in each of them we return false :

There are key characters left, but it is impossible to follow the key path in the trie, and the key is missing.
No key characters left, but current node is not marked as isEnd. Therefore the search key is only a prefix of another key in the trie.
For prefix() method, the approach is very similar to the one we used for searching a key in a trie. We traverse the trie from the root, till there are no characters left in key prefix or it is impossible to continue the path in the trie with the current key character.
The only difference with the mentioned above search for a key algorithm is that when we come to an end of the key prefix, we always return true. We don't need to consider the isEnd mark of the current trie node, because we are searching for a prefix of a key, not for a whole key.


Complexity Analysis:

1. insert() Method:

Time complexity : O(m) - where m is the key length. In each iteration of the algorithm, we either examine or create a node in the trie till we reach the end of the key. This takes only m operations.
Space complexity : O(m) - In the worst case newly inserted key doesn't share a prefix with the the keys already inserted in the trie. We have to add m new nodes, which takes us O(m) space.
2. search() Method:

Time complexity : O(m) - since in each step of the algorithm we search for the next key character. In the worst case, the algorithm performs m operations.
Space complexity : O(1)
3. prefix() Method:

Time complexity : O(m)
Space complexity : O(1)
*/

public class _208_ImplementTrie_PrefixTree {

    class Trie {

        /** Initialize your data structure here. */
        class TrieNode{
            boolean isEnd;
            TrieNode[] children;
            public TrieNode(){
                this.isEnd = false;
                this.children = new TrieNode[26];
            }
        }
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                int index = c-'a';
                if(curr.children[index]==null){
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                if(curr.children[c-'a'] != null){
                    curr = curr.children[c-'a'];
                }else{
                    return false;
                }
            }
            return (curr.isEnd);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for(char c : prefix.toCharArray()){
                if(curr.children[c-'a'] != null){
                    curr = curr.children[c-'a'];
                }else{
                    return false;
                }
            }
            //return true;
            return curr != null;
        }
    }

}
