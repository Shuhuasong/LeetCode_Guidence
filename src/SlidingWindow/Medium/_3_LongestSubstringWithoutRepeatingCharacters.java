package SlidingWindow.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, res = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //with duplicate char
            while(!seen.add(c)){
                seen.remove(s.charAt(left));
                left++;
            }
            //without duplicate char, update the res
            res = Math.max(res, i-left+1);
        }
        return res;
    }

    /* //O(n^2) ==> Time Limit Exceed
     public int lengthOfLongestSubstring(String s) {
       int n = s.length(), res = 0;
       for(int i=0; i<n; i++){
           for(int j=i+1; j<=n; j++){
               String sub = s.substring(i, j);
               if(isValid(sub)){
                   res = Math.max(res, sub.length());
               }
           }
       }
        return res;
    }

    private boolean isValid(String s){
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(set.contains(c)) return false;
            set.add(c);
        }
        return true;
    }
     */
}
