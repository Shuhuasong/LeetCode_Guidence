package TwoPointer.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _30_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        int m = words.length, n = words[0].length();

        for(int l=0; l<=s.length()-m*n; l++){
            Map<String, Integer> copy = new HashMap<>(map);
            int r = l;
            int count = m;
            while(count > 0){
                String word = s.substring(r, r+n);
                //The word we found is not match word in map, we can break loop
                if(!copy.containsKey(word) || copy.get(word) < 1){
                    break;
                }
                copy.put(word, copy.get(word)-1);
                r = r+n;
                count--;
            }
            if(count==0) results.add(l);
        }
        return results;
    }
}

/*
s = "barfoothefoobarman", words = ["foo","bar"]
           i
At i position, the word the is not in the map, so we can skip this while loop
*/
