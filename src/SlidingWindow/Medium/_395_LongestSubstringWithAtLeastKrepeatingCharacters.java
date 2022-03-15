package SlidingWindow.Medium;

import java.util.*;

/**
 * Created by Shuhua Song
 */
public class _395_LongestSubstringWithAtLeastKrepeatingCharacters {

    //Note: all the character into the window must at least k
    //Time = O(26*N)
    public int longestSubstring(String s, int k) {
        if(s==null || s.length()==0) return 0;
        int res = 0;
        for(int uniq=1; uniq<=26; uniq++){
            Map<Character, Integer> map = new HashMap<>();
            int left = 0, count = 0;
            for(int i=0; i<s.length(); i++){
                char curr = s.charAt(i);
                map.put(curr, map.getOrDefault(curr, 0)+1);
                if(map.get(curr)==k) count++;
                while(map.size() > uniq){
                    char c = s.charAt(left);
                    if(map.getOrDefault(c, 0)==k) count--;
                    map.put(c,map.getOrDefault(c, 0)-1);
                    if(map.get(c)==0) map.remove(c);
                    left++;
                }
                //all the character in the map has at least k occurence
                int validCount = map.size();
                if(validCount==uniq && validCount==count)
                    res = Math.max(res, i-left+1);
            }
        }
        return res;
    }

    //Sliding Window
    //Time = O(n), Space= O(n)
 /*   public int longestSubstring(String s, int k) {
        if(s==null || s.length() < k) return 0;
        int n = s.length(), maxLen = 0;
        // totalUnique = numUniqueChar(s);
        //dont' need to go through s one time to find totalUnique
        //if all letter are small, then max total char is 26
        for(int L=1; L<=26;L++){
            HashMap<Character, Integer> map = new HashMap<>();
            Queue<Character> q = new LinkedList<>();
            for(char c : s.toCharArray()){
                q.add(c);
                map.put(c, map.getOrDefault(c, 0)+1);
                while(q.size() > 0 && map.size() > L){
                    char leftC = q.poll();
                    map.put(leftC, map.get(leftC)-1);
                    if(map.get(leftC)==0) map.remove(leftC);
                }
                if(isValid(map, k)){
                    maxLen = Math.max(maxLen, q.size());
                }
            }
        }
        return maxLen;
    }

    private int numUniqueChar(String s){
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){ set.add(c); }
        return set.size();
    }

    private boolean isValid(HashMap<Character, Integer> map, int k){
        for(char c : map.keySet()){
            if(map.get(c) < k) return false;
        }
        return true;
    }

  */

    /*
     //Brute Force--check each substring has each char's freq = k
    //Time = O(n^2), Space= O(1)
    public int longestSubstring(String s, int k) {
        if(s==null || s.length() < k) return 0;
        int n = s.length();
        int maxLen = 0;
        int[] count = new int[26];
        for(int l=0; l<n; l++){
            Arrays.fill(count, 0);
            for(int r=l; r<n; r++){
                count[s.charAt(r)-'a']++;
                if(isValid(s, l, r, k, count)){
                    maxLen = Math.max(maxLen, r-l+1);
                }
            }
        }
        return maxLen;
    }
    private boolean isValid(String s, int l, int r, int k, int[] count){
        int unique = 0, atLeastK = 0;
        for(int freq : count){
            if(freq > 0) unique++;
            if(freq >= k) atLeastK++;
        }
        return unique==atLeastK;
    }
     */
}
