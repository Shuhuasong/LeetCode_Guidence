package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _438_FindAllAnagramInaString {

    //Time = O(m * 26)
/*
    1) count the char in the p String
    2) count the first pLen char in the s String
    3) compare wether both array pCnt and sCnt are the same
    4) check the size of the sliding window. when size is too big,
       remove the character on the left. and move left pointer
       forward at the same time. */


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        int[] pCnt = new int[26];
        for(char c : p.toCharArray()){ pCnt[c-'a']++; }
        int[] sCnt = new int[26];
        int l = 0, pLen = p.length();
        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);
            sCnt[c-'a']++;
            if(Arrays.equals(pCnt, sCnt)){
                results.add(l);
            }
            if(r-l+1 >= pLen){
                sCnt[s.charAt(l)-'a']--;
                l++;
            }
        }
        return results;
    }

    //Time = O(n)
    //Space = O(1)
 /*   public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if(s.length() < p.length()){
            return results;
        }
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        int lenP = p.length();
        for(char c : p.toCharArray()){
            pCnt[c-'a']++;
        }
        //sliding window on the string s
        for(int i=0; i<s.length(); i++){
            //add one letter on the right side of window
            sCnt[s.charAt(i)-'a']++;
            //remove one letter from left side of the window
            if(i>=lenP){
                sCnt[s.charAt(i-lenP)-'a']--;
            }
            //compare array in the sliding window
            //with the reference array
            if(Arrays.equals(pCnt, sCnt)){
                results.add(i-lenP+1);
            }
        }
        return results;
    }

  */

    /* brute force
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if(s.length() < p.length()){
            return results;
        }
        int[] pCnt = new int[26];
        int lenP = p.length();
        for(char c : p.toCharArray()){
            pCnt[c-'a']++;
        }
        String ps = Arrays.toString(pCnt);
       // System.out.println("ps = " + ps);
        for(int i=0; i<=s.length()-lenP; i++){
            String sub = s.substring(i, i+lenP);
            String subS = count(sub);
            if(subS.equals(ps)){
                results.add(i);
            }
        }
        return results;
    }

    private String count(String s){
        int[] bank = new int[26];
        for(char c : s.toCharArray()){
            bank[c-'a']++;
        }
        return Arrays.toString(bank);
    }
     */
}
