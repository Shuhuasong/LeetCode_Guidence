package SlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _159_LongestSubstringWithAtMostTwoDistinctCharacter {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s==null || s.length()==0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1); //1. Add the char into window
            while(map.size() > 2){
                char c = s.charAt(left);
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) map.remove(c); //2. Remove char from window when it is not valid
                left++;
            }
            res = Math.max(res, i-left+1);
        }
        return res;
    }
}
