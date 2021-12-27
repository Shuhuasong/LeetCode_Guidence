package String.Medium;

import java.util.HashSet;

/**
 * Created by Shuhua Song
 */
public class _1554_StringDifferByOneCharacter {

    //Time = O(m*n^2), m = string's length
    public boolean differByOne(String[] dict) {
        int n = dict.length;
        HashSet<String> set = new HashSet<>();
        for(String word : dict){
            for(int i=0; i<word.length(); i++){
                String s = word.substring(0,i) + "*" + word.substring(i+1);
                if(set.contains(s)) return true;
                set.add(s);
            }
        }
        return false;
    }
}
