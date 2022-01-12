package SlidingWindow.Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _1763_LongestNiceSubstring {


    //Divide and Conquer : when see character that pair with upcase and lowercase,
    // dividing string at this position, and check substring
    //Time = O(n^2), Space = O(n)
    public String longestNiceSubstring(String s) {
        int n = s.length();
        if(n < 2) return "";
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))) continue;
            String str1 = longestNiceSubstring(s.substring(0, i));
            String str2 = longestNiceSubstring(s.substring(i+1));
            return str1.length() >= str2.length() ? str1 : str2;
        }
        return s;
    }


    //Time = O(n^3), Space = O(n)
 /*   public String longestNiceSubstring(String s) {
        int n = s.length();
        String res = "";
        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n; j++){
                String sub = s.substring(i, j);
                if(isNice(sub) && sub.length() > res.length()){
                    res = sub;
                }
            }
        }
        return res;
    }

    private boolean isNice(String s){
        Set<Character> set = new HashSet<>();
        Set<Character> small = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
            small.add(Character.toLowerCase(c));
        }
        int size1 = set.size(), smallS = small.size();
        return size1==2*smallS;
    } */
}
