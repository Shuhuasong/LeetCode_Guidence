package SlidingWindow.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[] bank = new int[26];
        Arrays.fill(bank, 0);
        for(char c : s1.toCharArray()){
            bank[c-'a']++;
        }
        int l =0;
        int[] count = new int[26];
        for(int r=0; r<n2; r++){
            char c = s2.charAt(r);
            count[c-'a']++;
            if(r-l+1==n1 && Arrays.equals(bank, count)) return true;
            while(r-l+1 > n1){
                char leftC = s2.charAt(l);
                count[leftC-'a']--;
                l++;
                if(r-l+1==n1 && Arrays.equals(bank, count)) return true;
            }
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

