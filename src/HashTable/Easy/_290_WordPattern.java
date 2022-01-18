package HashTable.Easy;

import java.util.HashMap;

/**
 * Created by Shuhua Song
 */
public class _290_WordPattern {
    //bijective mapping of single characters to strings
    public boolean wordPattern(String pattern, String s) {
        //type of map is <Object, Object>
        String[] words = s.trim().split("\\s+");
        if(pattern.length() != words.length) return false;
        HashMap map = new HashMap<>();
        //remember use Integer in for loop as type
        for(Integer i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            String word = words[i];
            if(!map.containsKey(c)){
                map.put(c, i);
            }
            if(!map.containsKey(word)){
                map.put(word, i);
            }
            if(map.get(c) != map.get(word)){
                return false;
            }
        }
        return true;
    }

    /*
    public boolean wordPattern(String pattern, String s) {
        Map<String, String> map = new HashMap<>();
        String[] words = s.split("\\s+");
        if(pattern.length() != words.length) return false;
        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            System.out.println(c + " " + words[i]);
            if(!map.containsKey(c+"")){
                if(!map.containsValue(words[i])){
                    map.put(c+"", words[i]);
                }else{
                    return false;
                }
            }else{
                if(!map.get(c+"").equals(words[i])){
                    return false;
                }
            }
        }
        return true;
    }
     */
}

/*
"abba"
"dog dog dog dog"
*/
