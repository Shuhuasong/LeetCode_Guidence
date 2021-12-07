package String.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _890_FindAndReplacePattern {

     /*
    在 word 和 pattern 之间找一个双射函数
    */

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> results = new ArrayList<>();
        for(String word :  words){
            if(word.length() != pattern.length()) continue;
            if(isPattern(word, pattern)){
                results.add(word);
            }
        }
        return results;
    }

    private boolean isPattern(String word, String pattern){
        Map<Character, Character> map = new HashMap<>();
        int i=0;
        while(i<word.length()){
            char a = word.charAt(i), b = pattern.charAt(i);
            if(!map.containsKey(a)){
                if(!map.containsValue(b)){
                    map.put(a, b);
                }else{
                    return false;
                }
            }else{
                if( map.get(a) != b){
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    /*
    //Same with LC-205
     public boolean isIsomorphic(String s, String t) {
        if(s==null || t==null) return true;
        int n = s.length();
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for(int i=0; i<n; i++){
           char a = s.charAt(i);
           char b = t.charAt(i);
           if(!map1.containsKey(a)){
               map1.put(a, b);
           }
           if(!map2.containsKey(b)){
               map2.put(b, a);
           }
           if(map1.get(a) != b || map2.get(b) != a){
               return false;
           }
        }
        return true;
    }
     */
}
