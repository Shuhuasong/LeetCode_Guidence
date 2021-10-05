package SlidingWindow;

/**
 * Created by Shuhua Song
 */
public class _2024_MaximumTheConfusionofAnExam {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int[] count = new int[26];
        int maxF = 0, l = 0, res = 0;
        for(int r=0; r<n; r++){
            char c = answerKey.charAt(r);
            count[c-'A']++;
            //the max Frequency of repeating number.
            maxF = Math.max(maxF, count[c-'A']);
            //(r-l+1) == the size of window
            //(r-l+1)-maxF == the number of replacement
            //shrink the window when the replacement exceed k
            while(r-l-maxF+1 > k){
                count[answerKey.charAt(l)-'A']--;
                l++;
            }
            //update the window when the window is valid
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
