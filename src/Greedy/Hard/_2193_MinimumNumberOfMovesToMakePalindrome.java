package Greedy.Hard;

/**
 * Created by Shuhua Song
 */
public class _2193_MinimumNumberOfMovesToMakePalindrome {

    public int minMovesToMakePalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        int steps = 0;
        while(n > 1){
            char last = sb.charAt(n-1);
            int firstIdx = sb.indexOf(last+"");
            System.out.println(firstIdx + " == " + last);
            if(firstIdx==n-1){
                steps += n/2;
            }else{
                steps += firstIdx;
                sb.deleteCharAt(firstIdx);
                n--;
            }
            n--;
        }
        return steps;
    }
}

/*
Solution-Greedy
1) store the string s into StringBuilder
2) iterate from last index: n-1 to 1
   -get last character: lastChar
   -find idx = s.indexOf(lastChar)
   --if idx==n-1) the character is a single character in the string middle
     add steps: steps += n/2
   --else we delete the char at index idx
     add steps: steps += idx

e.g:
   "letelt"
   firstIdx + " == " + lastCharacter
   2 == t
   0 == l
   0 == e

Tips:
1) Let’s start by making the leftmost and rightmost characters match with some number of swaps.
2) If we figure out how to do that using the minimum number of swaps, then we can delete the leftmost and rightmost characters and solve the problem recursively.
*/
