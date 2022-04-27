package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1400_Construct_K_PalindromeStrings {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) return false;
        int odd = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(int val : map.values()){
            odd += (val%2==1) ? 1 : 0;
        }
        return odd <= k;
    }
}

/*
"annabelle"
2
"leetcode"
3
"true"
4
"cr"
7
"aaa"
2
*/
