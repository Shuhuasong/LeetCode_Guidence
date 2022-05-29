package Bitwise.Medium;

/**
 * Created by Shuhua Song
 */


public class _318_MaximumProductOfWordLengths {
    //Time = O(n^2 * L), n = words.length, L=max len of word
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n], lens = new int[n];
        for(int i=0; i<n; i++){
            masks[i] = getMask(words[i]);
        }
        //Two difference words may have the same bitmask
        //e.g. : ab and aabb
        int res = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if((masks[i] & masks[j])==0){
                    res = Math.max(res, words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }

    private int getMask(String word){
        int mask = 0;
        for(char c : word.toCharArray()){
            mask |= 1 << (c-'a');
        }
        return mask;
    }

    /*
     public int maxProduct(String[] words) {
        int res = 0, n = words.length;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(isValid(words[i], words[j])){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    private boolean isValid(String s, String t){
        Set<Character> seen = new HashSet<>();
        for(char c : s.toCharArray()){
            seen.add(c);
        }
        for(char c : t.toCharArray()){
            if(seen.contains(c)) return false;
        }
        return true;
    }
     */
}
