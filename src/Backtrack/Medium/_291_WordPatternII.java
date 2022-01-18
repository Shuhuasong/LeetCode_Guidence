package Backtrack.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _291_WordPatternII {
    //Time complexity: the problem is more like slicing the string into m pieces.
    // How many slicing ways? C(n^m). For each slice, it takes O(n) to validate.
    // So the total complexity is O(n * C(n^m))
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> matched = new HashSet<>();
        return backtrack(pattern, 0, s, 0, map, matched);
    }

    private boolean backtrack(String pat,  int i, String inputS, int j, Map<Character, String> map, Set<String> matched){
        //base case
        if(i==pat.length() && j==inputS.length()) return true;
        if(i==pat.length() || j==inputS.length()){
            return false;
        }
        //get current pattern character
        char c = pat.charAt(i);

        //if the pattern character exists
        if(map.containsKey(c)){
            String s = map.get(c);
            //check if the substring can match the string from inputS(j, j+s.length())
            if(!inputS.startsWith(s, j)) return false;
            //if the curr position can match, continue to check the rest of string
            return backtrack(pat, i+1, inputS, j+s.length(), map, matched);
        }
        //when pattern char is not exist in the map
        for(int y=j; y<inputS.length(); y++){
            //take a substring by exploring all the length from input string
            String sub = inputS.substring(j, y+1);
            //we can't match ("a"-->cat && "b"-->cat), if the substring is in the set, we
            //keep take another substring to match the character
            if(matched.contains(sub)) continue;
            //creat a mapping
            map.put(c, sub);
            matched.add(sub);
            //continue to match the rest
            if(backtrack(pat, i+1, inputS, y+1, map, matched)) return true;
            //backtracking
            map.remove(c, sub);
            matched.remove(sub);
        }
        return false;
    }
}

/*
Intuitive: use the backtrack
we can use a character in pattern to match different length of substring in the input string, keep it trying
untill we go through the input string and the pattern.

for example, we can use 'a' to match :
       sub in input string
a  -->  r
a  -->  re
___________________
a  -->  red
b  --> blue
now when we see 'a' again, we know that is should match with 'red', the length is 3, then we see if
inputS(j, j+3) matches 'a' (the j is the current index of input string), we can use inputS.startsWith(s, i) check

in addition, we can use a set to avoid duplicate matches, if a character a matches string 'red', other character
e.g 'b' cannot be used to match "red" again.


case-1:
p = "abab"  s = "redblueredblue"

a--> r
a--> re
a--> red
a--> redb

case-2:
p = "aba"  s = "aaaa"
"a" = "a"
"b" = "aa"

               "redblueredblue"
            /       /    /       /    \  \  \  \
a         r         re  red     redb....
    /  /  / \ \       /  /  \
b  e  ed edb         b   bl.. blue
                                \
a                                red
                                    \
b                                    blue

*/