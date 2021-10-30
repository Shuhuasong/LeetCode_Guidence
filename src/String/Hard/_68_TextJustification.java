package LintCode.String.Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
class _68_TextJusification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> results = new ArrayList<>();
        int n = words.length;
        int idx = 0;
        while(idx < n){
            int totalChars = words[idx].length();
            int right = idx + 1;
            while(right<n){
                if(totalChars+words[right].length()+1 > maxWidth) break;
                totalChars += 1 + words[right].length();
                right++;
            }
            int gaps = right-idx-1;
            StringBuilder sb = new StringBuilder();
            if(right==n || gaps==0){
                for(int i=idx; i<right; i++){
                    sb.append(words[i]);
                    sb.append(' ');
                }
                sb.deleteCharAt(sb.length()-1);
                while(sb.length() < maxWidth){
                    sb.append(' ');
                }
            }else{
                int spaces = (maxWidth-totalChars)/gaps;
                int remind = (maxWidth-totalChars)%gaps;
                for(int i=idx; i<right-1; i++){
                    sb.append(words[i]);
                    sb.append(' '); //in the above totalChars, we have count 1 space
                    for(int j=0; j<spaces+(i-idx<remind ? 1 : 0); j++){
                        sb.append(' ');
                    }
                }
                sb.append(words[right-1]);
            }
            results.add(sb.toString());
            idx = right;
        }
        return results;
    }
}

/*
words = ["This", "is", "an", "example", "of", "text", "justification."]
      = { 4, 2, 2, 7, 2, 4, 3}


Rules : (1) Greedy as many words as possible
  (2) --Not the last line: spaces between words should be distributed
      as evenly as possible, as left as possible
      --the last line / only 1 word in the line
        no extra space between words
Algorithm:
   Step 0 : decide how many words could be put in the same line
   Step 1; add the spaces between words

wordIndex : keep record the index in words
right : the rightMost word index that in the same line (exclusive)
totalChars : the total chars used in the line : one word + one space
gaps : the number of gaps between wordIndex and right ==> (right-wordIndex-1)

Use StringBuilder to collect all the word in a line
-- last line/only 1 word : {w1 + space + w2 + space + ... + space}
-- not last line :
   totalChars = word1 + space(gap1) + word2 + space(gap2) + word3
   (maxWidth - totalChars)/gaps
   spaces: (17-10)/2 = 3 (spaces for each gap)
   reminder : (17-10)%2 = 1 ==> the first gap has (2+1) spaces

    */

