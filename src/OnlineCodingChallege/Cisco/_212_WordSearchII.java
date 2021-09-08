package OnlineCodingChallege.Cisco;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _212_WordSearchII {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    char[][] board;
    int rows, cols;
    List<String> results;
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        results = new ArrayList<>();
        HashSet<String> dict = new HashSet<>();
        for(String w : words){
            dict.add(w);
        }

        TrieNode root = buildTrie(words);
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                boolean[][] visited = new boolean[rows][cols];
                backtrack(dict, i, j, visited, root);
            }
        }
        return results;
    }

    private void backtrack(HashSet<String> dict, int i, int j, boolean[][] visited, TrieNode root){
        char currChar = board[i][j];
        if(root.children[currChar-'a'] != null){
            visited[i][j] = true;
            root = root.children[currChar-'a'];
            if(root.word != null){
                results.add(root.word);
                dict.remove(root.word);
                root.word = null;
            }
            for(int[] dir : dirs){
                int x = i + dir[0];
                int y = j + dir[1];
                if(x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y]) continue;
                backtrack(dict, x, y, visited, root);
            }
            visited[i][j] = false;
        }
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(node.children[c-'a']==null){
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.word = word;
        }
        return root;
    }

    /*
    List<String> res;
    char[][] board;
    int ROWS;
    int COLS;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        ROWS = board.length;
        COLS = board[0].length;
        res = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            if(find(words[i])){
                res.add(words[i]);
            }
        }
        return res;
    }

    public boolean find(String word){
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(backTrack(i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrack(int i, int j, String word, int idx){
        if(idx == word.length()) return true;
        if( i < 0 || i == ROWS || j < 0 || j == COLS || board[i][j] != word.charAt(idx)){
            return false;
        }

        int[] row = {0, 0, 1, -1};
        int[] col = {1, -1, 0, 0};
        char tmp = board[i][j];
        board[i][j] = '#';
        boolean find = false;
        for(int k=0; k<4; k++){
            find = backTrack(i + row[k], j + col[k], word, idx+1);
            if(find){
                break; }
        }
        board[i][j] = tmp;
        return find;
    }

     */
}
