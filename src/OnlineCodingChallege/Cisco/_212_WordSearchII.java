package OnlineCodingChallege.Cisco;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _212_WordSearchII {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        // boolean isWord = false;
        String word = null;
        public TrieNode(){}
    }

    TrieNode root = new TrieNode();

    public void insertTree(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        //curr.isWord = true;
        curr.word = word;
    }
    public boolean searchWord(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null) return false;
            curr = curr.children[c-'a'];
        }
        return true;
    }
    int rows, cols;
    public List<String> findWords(char[][] board, String[] words) {
        int maxLen = 0;
        for(String word : words){
            insertTree(word);
        }
        Set<String> resSet = new HashSet<>();
        List<String> results = new ArrayList<>();
        rows = board.length; cols = board[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1,0}};
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(root.children[board[i][j]-'a'] == null) continue;
                //find the first character of word
                //then use dfs to find whole word
                dfs(board, i, j, visited, results);
            }
        }
        //for(String w : resSet) results.add(w);
        return results;
    }

    private void dfs(char[][] board, int r, int c, boolean[][] visited, List<String> res){
        //Base case
        if(r<0 || r>=rows || c<0 || c>=cols || visited[r][c] || root.children[board[r][c]-'a']==null) return;
        //mark
        visited[r][c] = true;
        TrieNode temp = root;
        root = root.children[board[r][c]-'a'];
        if(root.word!=null){
            res.add(root.word);
            // root.isWord = false;
            root.word = null;
        }
        //four direction traverse
        dfs(board, r+1, c, visited, res);
        dfs(board, r-1, c, visited, res);
        dfs(board, r, c+1, visited, res);
        dfs(board, r, c-1, visited, res);
        //backtrack
        visited[r][c] = false;
        root = temp;
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
