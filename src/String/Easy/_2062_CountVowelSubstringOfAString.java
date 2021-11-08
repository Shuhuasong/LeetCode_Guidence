package String.Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _2062_CountVowelSubstringOfAString {
    Set<Character> vowel;
    public int countVowelSubstrings(String word) {
        if(word==null || word.length()==0) return 0;
        int res = 0, n = word.length();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n; j++){
                String s = word.substring(i, j);
                if(s.length()>=5 && isValid(s)){
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isValid(String s){
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if("aeiou".indexOf(c) == -1){
                return false;
            }
            set.add(c);
        }
        return set.size()==5;
    }
}
