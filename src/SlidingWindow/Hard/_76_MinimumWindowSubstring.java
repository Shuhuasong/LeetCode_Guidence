package SlidingWindow.Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s==null || s.length()==0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        int count = 0, left = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(map.containsKey(curr)){
                if(map.get(curr) > 0) count++; //valid count
                map.put(curr, map.get(curr)-1);
            }
            while(count==t.length()){
                if(i-left+1 < minLen){ //find a smaller length, updaate the result
                    minLen = i-left+1;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);
                    if(map.get(leftChar) > 0) count--;
                }
                left++;
            }
        }
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart+minLen);
    }
}

/*
Solution:
1) add all the char from t into map
2) iterate the char from s
   1> if the curr character is in the map,
      if it is, then add the count when it's occurence is greater than 0
      then we need to substract one of from map to indicate one char match with char
      int t.
3) check if the number of char we capture in s has the same of num of t.length()
   1> if it is, we update the result when current length is smaller than minLen
   2> shrink th window
      when the left char is in map, we need to put it back into map
      when the occurence of left char is greater than 0, then we need to
      substract count(means remove the left char from window)
   3> move forward left pointer
4) if minLen is not update, then we return ""
    otherwise, return s.substring(minStart, minStart+minLen)
 */
