package SlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _340_LongestSubstringWithAtMostKdistinctCharacter {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, maxLen = 0;
        String res = "";
        for(int r=0; r<n; r++){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);
            //Once find the size of map is greater than k==> get the result
            while(map.size() > k){
                if(r-l > maxLen){
                    maxLen = r-l;
                }
                char leftC = s.charAt(l);
                l++;
                map.put(leftC, map.get(leftC)-1);
                if(map.get(leftC)==0) map.remove(leftC);
            }
        }
        maxLen = Math.max(maxLen, n-l);
        return maxLen;
    }
}

/*
case-1:
association
with repeat character==> use map

at most k diff char
<= k diff char
"e c e b a"
 l   r
 */
