package String.Medium;

/**
 * Created by Shuhua Song
 */
public class _1347_MinimumNumberOfStepsToMakeTwoStringsAnagram {
    //calculate each character in string s and t
    //compare each character to see if the sVal[i] greater
    //than tVal[i], if it is, means there are (sVal[i]-tVal[i])
    //character we need to change in the string t, add all these
    //diff when (sVal[i]>tVal[i])
    public int minSteps(String s, String t) {
        if(s.length() != t.length()) return 0;
        int n = s.length(), res = 0;
        int[] sVal = new int[26];
        int[] tVal = new int[26];
        for(char c : s.toCharArray()){
            sVal[c-'a']++;
        }
        for(char c: t.toCharArray()){
            tVal[c-'a']++;
        }
        for(int i=0; i<26; i++){
            if(sVal[i] > tVal[i]){
                res += sVal[i]-tVal[i];
            }
        }
        return res;
    }
}

/*
s:  "bab"

t:  "aba"

s : a  b
    1  2
t : a  b
    2  1

s: "leetcode"
    c d e l o t
    1 1 3 1 1 1
t   "practice"
    a c e i r t p
    1 2 1 1 1 1 1

    1 + 2 + 1 + 1
*/

