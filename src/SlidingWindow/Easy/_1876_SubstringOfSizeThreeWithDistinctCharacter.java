package SlidingWindow.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1876_SubstringOfSizeThreeWithDistinctCharacter {


    //Time = O(n), Space = O(n)
    public int countGoodSubstrings(String s) {
        if(s==null || s.length()==0) return 0;
        int l = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(r-l+1 == 3){
                if(map.size()==3) res++;
                char leftC = s.charAt(l);
                map.put(leftC, map.getOrDefault(leftC,0)-1);
                if(map.getOrDefault(leftC,0)==0){
                    map.remove(leftC);
                }
                l++;
            }
        }
        return res;
    }

    /*
      //Time = O(n), Space = O(1)
    public int countGoodSubstrings(String s) {
        if(s==null || s.length()==0) return 0;
        int res = 0;
        for(int i=1; i<s.length()-1; i++){
            char c1 = s.charAt(i-1);
            char c2 = s.charAt(i);
            char c3 = s.charAt(i+1);
            if(c1==c2 || c2==c3 || c1==c3) continue;
            res++;
        }
        return res;
    }
     */
}
