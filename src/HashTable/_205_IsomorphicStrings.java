package HashTable;

import java.util.HashMap;
import java.util.Map;

public class _205_IsomorphicStrings {

    /*
    idea:
    check if there is a key of char in map, if it does, check if u = v, then continue; otherwise, return false;
    if it doesn't contain the key, and dosen't contain the value, then put them into map;
    if it doesn't contain the key, but contain the value, then it is false also;

    when s1 = aaabbcc, s2 = bbbaadd
    in map: (a,b) != (b, a), they must represent and store individually
     */

    public boolean isIsomorphic(String s, String t) {
         /*
       在 word 和 pattern 之间找一个双射函数
       */
        if(s.length()==0 || t.length()==0) return false;
        Map<Character, Character> match = new HashMap<>();
        int m = s.length(), n = t.length();
        int i = 0, j = 0;
        while(i < m && j < n){
            char u = s.charAt(i++);
            char v = t.charAt(j++);

            if(match.containsKey(u)){
                if(v==match.get(u))
                    continue;
                else
                    return false;
            }else{
                if(!match.containsValue(v)){
                    match.put(u, v);
                }
                else
                    return false;
            }
        }
        return true;
    }

    /*
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
