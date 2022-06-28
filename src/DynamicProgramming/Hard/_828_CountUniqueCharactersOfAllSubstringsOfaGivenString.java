package DynamicProgramming.Hard;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _828_CountUniqueCharactersOfAllSubstringsOfaGivenString {
    //Time = O(n), Space = O(n)

    public int uniqueLetterString(String s) {
        int n = s.length();
        int[] prev = new int[n], next = new int[n];
        Arrays.fill(prev, -1);
        Arrays.fill(next, n);
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx, -1);
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            prev[i] = lastIdx[c-'A'];
            lastIdx[c-'A'] = i;
            if(prev[i]!=-1){
                next[prev[i]] = i;
            }
        }
        int result = 0;
        for(int i=0; i<n; i++){
            result += (i-prev[i]) * (next[i]-i);
        }
        return result;
    }

    /*
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
            //res += leftDistance * rightDistance
            res += (i-leftBound+1) * (rightBound-i+1);
        }
        return res;
    }

     */
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




/*
Solution-1: Brute Force
find each substring, and count how many unique char
for each substring

Solution-1: Hashtable
1) define an array prev and next
   prev[] : record the previous same char's index
   next[] : record the next same char's index

e.g
      0  1  2  3  4  5  6
      A  B  C  A  D  E  A
            |
prev -1 -1 -1  0  -1 -1  3
next  3  7 -7  6   7  7  7
 for char A at 3, it is in 3 * 3 = 9 total
 substring
 (3-0) * (6-3) = 9
 */
 