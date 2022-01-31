package TwoPointer.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _809_ExpressiveWords {


    //Use two pointer to get length of each group of character
    //then compare this both length;
    //Time = O(S * M * N), M = lenght of word, N = number of words
    public int expressiveWords(String S, String[] words) {
        if(S.length()==0 || words.length==0) return 0;
        int count = 0;
        for(String word : words){
            if(isStretchy(S, word)){
                count++;
            }
        }
        return count;
    }

    private boolean isStretchy(String S, String w){
        int m = S.length(), n = w.length();
        if(m < n) return false;
        int i = 0, j = 0;
        int len1 = 0, len2 = 0;
        while(i < m && j < n){
            if(S.charAt(i)==w.charAt(j)){
                len1 = numSameChar(S, i);
                len2 = numSameChar(w, j);
                if(len1 > len2 && len1 < 3 || len1 < len2) return false;
            }else{
                return false;
            }
            i += len1;
            j += len2;
        }
        return i==m && j==n;
    }

    private int numSameChar(String s, int i){
        int j = i;
        while(j < s.length() && s.charAt(j) == s.charAt(i)){
            j++;
        }
        return j-i;
    }


 /*   public int expressiveWords(String s, String[] words) {
        int count = 0;
        Set<String> seen = new HashSet<>();
        Set<String> notValid = new HashSet<>();
        for(String word : words){
            if(notValid.contains(word)) continue;
            else if(seen.contains(word)){
                count++;
                continue;
            }
            if(isStretchy(s, word)){
                count++;
                seen.add(word);
            }else{
                notValid.add(word);
            }
        }
        return count;
    }

    private boolean isStretchy(String s, String word){
        if(s.length() < word.length()) return false;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        char prev = s.charAt(0);
        int count = 1;
        for(int i=1; i<s.length(); i++){
            char curr = s.charAt(i);
            if(curr==prev){
                count++;
            }else{
                list1.add(new int[]{prev-'a', count});
                prev = curr;
                count = 1;
            }
        }
        list1.add(new int[]{prev-'a', count});

        prev = word.charAt(0);
        count = 1;
        for(int i=0; i<word.length(); i++){
            if(i==0) continue;
            char c = word.charAt(i);
            if(c==prev){
                count++;
            }else{
                list2.add(new int[]{prev-'a', count});
                prev = c;
                count = 1;
            }
        }
        list2.add(new int[]{prev-'a', count});

        if(list1.size() != list2.size()) return false;

        for(int i=0; i<list1.size(); i++){
            int[] p1 = list1.get(i);
            int[] p2 = list2.get(i);
            if(p1[0] != p2[0]) return false;
            if(p1[1] > p2[1] && p1[1] < 3 || p1[1] < p2[1]) return false;

        }
        return true;
    }

  */
}
