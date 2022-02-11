package HashTable.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _49_GroupAnagrams {

    //Time = (n*L), n = strs.length, L = maximum length of a string
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> results = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String w : strs){
            if(w.length() == 0){
                map.putIfAbsent("", new ArrayList<>());
                map.get("").add("");
            }else{
                int[] bank = new int[26];
                for(char c : w.toCharArray()){
                    bank[c-'a']++;
                }
                String nw = Arrays.toString(bank);
                map.putIfAbsent(nw, new ArrayList<>());
                map.get(nw).add(w);
            }
        }
        for(String key : map.keySet()){
            results.add(map.get(key));
        }
        return results;
    }

 /*   public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(String st : strs){
            char[] chs = st.toCharArray();
            Arrays.sort(chs);
            String newS = new String(chs);
            if(!map.containsKey(newS)){
                map.put(newS, new ArrayList<>());
            }
            map.get(newS).add(st);
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> list : map.values()){
            result.add(list);
        }
        return result;
    } */
}
