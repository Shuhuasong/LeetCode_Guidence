package String.Medium;

/**
 * Created by Shuhua Song
 */
public class _2207_MaximumNumberOfSubsequenceInaString {
    public long maximumSubsequenceCount(String text, String pattern) {
        long count1 = 0, count2 = 0, res = 0;
        char first = pattern.charAt(0), second = pattern.charAt(1);
        for(char c : text.toCharArray()){
            if(c==second){
                res += count1;
                count2++;
            }
            if(c==first){
                count1++;
            }
        }
        //Add letter either at the begin or end
        return res + Math.max(count1, count2);
    }
}

/*
Solution:
        if we add pattern[0], the best option is to add at the begin
        if we add pattern[1], the best option is to add at the end

        1) iterate each char in text
        if have char==pattern[0], increase count1
        if have char==pattern[1], increase count2
        2) once we encounter patter[1], it means the char can combine with
        all the pattern[0] before this current char to form the subsequence:
        so : res += count1
        and  count2++



        "aabb"
        "abab"

        "abdcdbc"
        "ac"
        "aabb"
        "ab"

        "iekbksdsmuuzwxbpmcngsfkjvpzuknqguzvzik"
        "mp"

        "kbdqjynugpghonpbhnohungpgbbiihqg"
        "yh"

        "fwymvreuftzgrcrxczjacqovduqaiig"
        "yy"
        */
