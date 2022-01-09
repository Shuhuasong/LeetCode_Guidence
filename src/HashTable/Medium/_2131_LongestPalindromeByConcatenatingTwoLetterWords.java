package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _2131_LongestPalindromeByConcatenatingTwoLetterWords {

    //Time = O(n), Space = O(n)
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        int res = 0, numSymmetry = 0;
        for(String word : words){
            String rev = word.charAt(1)+""+word.charAt(0);
            boolean isMirror = word.equals(rev);
            if(freq.containsKey(rev)){
                res += 4;
                freq.put(rev, freq.get(rev)-1);
                if(freq.get(rev)==0) freq.remove(rev);
                numSymmetry -= (isMirror ? 1 : 0);
            }else{
                freq.put(word, freq.getOrDefault(word, 0)+1);
                numSymmetry += (isMirror ? 1 : 0);
            }

        }
        if(numSymmetry > 0){
            res += 2;
        }
        return res;
    }
}
