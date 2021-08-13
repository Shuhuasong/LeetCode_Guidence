package HashTable.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
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
    }
}
