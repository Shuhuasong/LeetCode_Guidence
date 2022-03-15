package SlidingWindow.Medium;

/**
 * Created by Shuhua Song
 */
public class _424_LongestRepeatingCharacterReplacement {
    //Time = O(26*N)
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int res = 0, left = 0;
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            count[curr-'A']++;
            //window size-max occurence char = number of char need to change
            while(i-left+1 - getMaxCount(count) > k){
                char c = s.charAt(left);
                count[c-'A']--;
                left++;
            }
            res = Math.max(res, i-left+1);
        }
        return res;
    }

    private int getMaxCount(int[] count){
        int res = -1;
        for(int i=0; i<26; i++){
            res = Math.max(res, count[i]);
        }
        return res;
    }
}
