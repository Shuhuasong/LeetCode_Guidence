package HashTable.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] bank = new int[26];
        for(char c : s1.toCharArray()) bank[c-'a']++;

        int[] count = new int[26];
        int n1 = s1.length();
        int l = 0;
        for(int r=0; r<s2.length(); r++){
            count[s2.charAt(r)-'a']++;
            while(r-l+1>n1){
                count[s2.charAt(l)-'a']--;
                l++;
            }
            if(r-l+1==n1 && Arrays.equals(bank, count)) return true;
        }
        return false;
    }
}

/*
Solution:
1) count the number of char in s1 and store them in array;
   we can also use map, but array is faster.
2) iterate the s2 and also store char in array;
   and keep a sliding window by using left and right pointer;
   if the size is equal to n1, it means this window has a potencial
   answer, check it.
   if the size is greater than n1, we need to narrow the window by
   move left pointer forward. And decrease the number of char
   in array. At this process, also check if both array are equals.

    0 1 2 3 4 5 6 7
  "e i d b a o o o"
 l r
"eeeaffbddd"
*/

