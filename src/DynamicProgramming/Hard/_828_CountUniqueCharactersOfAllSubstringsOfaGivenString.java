package DynamicProgramming.Hard;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _828_CountUniqueCharactersOfAllSubstringsOfaGivenString {
    //Time = O(n), Space = O(n)
    public int uniqueLetterString(String s) {
        int[] letter = new int[26];
        int n = s.length(), res = 0;
        int[] leftPos = new int[n], rightPos = new int[n];
        Arrays.fill(letter, -1);
        Arrays.fill(leftPos, -1); Arrays.fill(rightPos, -1);
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(letter[c-'A']!=-1){
                leftPos[i] = letter[c-'A'];
            }
            letter[c-'A'] = i;
        }
        Arrays.fill(letter, -1);
        for(int i=n-1; i>=0; i--){
            char c = s.charAt(i);
            if(letter[c-'A']!=-1){
                rightPos[i] = letter[c-'A'];
            }
            letter[c-'A'] = i;
        }
        for(int i=0; i<n; i++){
            int leftBound = leftPos[i]==-1 ? 0 : leftPos[i]+1;
            int rightBound = rightPos[i]==-1 ? n-1 : rightPos[i]-1;
            //i-leftBound+1 : look at explain <1>
            //rightBound-i+1: look at explain <2>
            res += (i-leftBound+1) * (rightBound-i+1);
        }
        return res;
    }
}

/*
Solution:
the naive solution is to take each substring and check one by one, but
the time complexit will be O(n^3), it will cause TLE.
So, we need think in the other way:
find out the number of substrings a character can be a part of can be done by find out:
1) the number of character between the current character and its duplicate on the left, if any
2) the number of character between the current character and its duplicate on the right, if nay

Let's look at the example 'LEETCODE' and the following graph:

			L   E   E*  T   C   O   D   E**
Left        0   1   0   3   4   5   6   4
Right       7   0   4   4   3   2   1   0

For E*:
   Left: E* sits immediately next to it's duplicate tn the left, therefore, there are no other characters to its left. We use 0
   Right: There are 4 characters between E* and E**, its duplicate on the right. We use 4.

<1> 1 + Left amount of characters (or the number of characters between this current character and it's duplicate on the left, if any) to all the substrings from the left
<2> 1 + right amount of characters (same number) to Right number of substrings to it's right (or the number of characters betwen this current character and it's duplicate on the right)

 */