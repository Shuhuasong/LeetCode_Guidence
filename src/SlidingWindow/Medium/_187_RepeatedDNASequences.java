package SlidingWindow.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _187_RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> results = new ArrayList<>();
        if(s==null || s.length()<10) return results;
        int n = s.length(), len = 10;
        Set<String> seen = new HashSet<>(), ans = new HashSet<>();
        for(int start=0; start<=n-len; start++){
            String sub = s.substring(start, start+len);
            if(seen.contains(sub)) ans.add(sub);
            seen.add(sub);
        }
        for(String st : ans) results.add(st);
        return results;
    }

 /*   public List<String> findRepeatedDnaSequences(String s) {
        List<String> results = new ArrayList<>();
        if(s==null || s.length()<10) return results;
        int l = 0, n = s.length();
        Map<String, Integer> count = new HashMap<>();
        for(int r=9; r<n; r++){
            String st = s.substring(l, r+1);
            count.put(st, count.getOrDefault(st, 0)+1);
            l++;
        }
        for(String key : count.keySet()){
            if(count.get(key) > 1){
                results.add(key);
            }
        }
        return results;
    }  */
}

/*
Solution:
1) use a pointer start to iterate  String s, and take
   a substring from s; if the sub already contains in the
   set seen, then we can add it into answer. Otherwise,
   add it into seen for next time checking.
2) we can use map or set to keep if a substring show up
   more than one itme.
 */
