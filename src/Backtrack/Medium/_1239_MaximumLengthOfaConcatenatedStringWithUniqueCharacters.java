package Backtrack.Medium;

import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _1239_MaximumLengthOfaConcatenatedStringWithUniqueCharacters {

    //Backtrack: Time = O(2^n), Space = O(n)
    int res = 0;
    public int maxLength(List<String> arr) {
        backtrack(arr, 0, "");
        return res;
    }
    private void backtrack(List<String> arr, int start, String s){
        if(noDuplicate(s)){
            res = Math.max(res, s.length());
        }else{
            return;
        }
        for(int i=start; i<arr.size(); i++){
            if(noDuplicate(s)){
                backtrack(arr, i+1, s+arr.get(i));
            }
        }
    }
    private boolean noDuplicate(String s){
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c-'a']++;
            if(count[c-'a'] > 1) return false;
        }
        return true;
    }

    /*
     //Time = O(2^n), Space = O(n)
    int res = 0;
    public int maxLength(List<String> arr) {
        //translate letter to bitString, such as : abc==>111
        //also find the word that have duplicate letter to set it as 0
        int[] words = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            words[i] = getMask(arr.get(i));
        }
        dfs(words, 0, 0);
        return res;
    }

    private void dfs(int[] words, int idx, int prevNum){
        res = Math.max(res, Integer.bitCount(prevNum));
        if(idx >= words.length){
            return;
        }
        //skip this curr index
        dfs(words, idx+1, prevNum);
        //if the curr index is not have the same letter with prevNum of bitString, we can take it
        if((prevNum & words[idx])==0){
            int currBitStr = prevNum | words[idx];
            dfs(words, idx+1, currBitStr);
        }
    }

    private int getMask(String s){
        char[] chs = s.toCharArray();
        int bitStr = 0;
        boolean flag = true;// check if the word with duplicate char
        for(char c : s.toCharArray()){
            int mask = 1 << (c-'a');
            if((bitStr&mask) > 0){ //if there are duplicate char, return 0
                return 0;
            }
            bitStr |= mask; //merge
        }
        return bitStr;
    }
     */

        /*
    use 6 bits ===> 6*6=36 > 32
    "abc" === >  "000111", "ef" ===> "110000"
    "aef" ====>  "110001"
    "abc" & "ef"===> 000111 & 110000 == 000000 ==> no duplicate
    "abc" & "aef" ===> 000111 & 110001 = 000001 > 0 ===> with duplicate

    how to add a character into a string?
    given  "abef" ===>   110011, want to add 'd'
    use: mask = 1 << (c-'a') = 1 << 3 = 1000
    then: 110011 + 1000 = 110011 | 1000   = 111011
    */
}
