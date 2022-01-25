package SlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1297_MaximumNumberOfOccurenceOfAsubstring {

    // Need to keep track the number of unique chars and the length of substring.
    // Only need to count the occurence of minLen, because if a longer substring sub
    // appear k times, the shorter of the sub must also appear k times
    // Only narrow the window when either one condition is false
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if(s==null || s.length() < minSize) return 0;
        Map<Character, Integer> mapC = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        int l = 0, maxFreq = 0;
        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);

            mapC.put(c, mapC.getOrDefault(c, 0)+1);

            while(mapC.size() > maxLetters || r-l+1 > minSize){
                char leftC = s.charAt(l);
                l++;
                mapC.put(leftC, mapC.get(leftC)-1);
                if(mapC.get(leftC)==0){
                    mapC.remove(leftC);
                }
            }
            if(r-l+1==minSize){
                String sub = s.substring(l, r+1);
                System.out.println("sub = " + sub);
                count.put(sub, count.getOrDefault(sub, 0)+1);
                maxFreq = Math.max(maxFreq, count.get(sub));
            }
        }
        return maxFreq;
    }
}

/*
"abcde"
2
3
3

"aababcaab"
2
3
4



"aaaa"
1
3
3
*/
