package Backtrack.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _131_PalindromePartition {

    //BackTrack + DP
    //Tine = O(N * 2^N), Space = O(N * N)
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if(s.length()==0) return results;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        backtrack(s, 0, new ArrayList<>(), results, dp);
        return results;
    }

    public void backtrack(String s, int start, List<String> list, List<List<String>> results, boolean[][] dp){
        if(start>=s.length()){
            results.add(new ArrayList<>(list));
            return;
        }
        for(int end=start; end<s.length(); end++){
            if(s.charAt(start)==s.charAt(end) && (end-start<=2 || dp[start+1][end-1])){
                dp[start][end] = true;
                list.add(s.substring(start, end+1));
                backtrack(s, end+1, list, results, dp);
                list.remove(list.size()-1);
            }

        }
    }

    public boolean isPalindrom(String s, int l, int r ){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    //Backtrack: Time = O(N * 2^n), worst case = when all path are all palindrome
    // Space = O(n)
    /*
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if(s.length()==0) return results;
        backtrack(s, 0, new ArrayList<>(), results);
        return results;
    }

    public void backtrack(String s, int start, List<String> list, List<List<String>> results){
        if(start>=s.length() && list.size()>0){
            results.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<s.length(); i++){
            if(isPalindrom(s, start, i)){
                list.add(s.substring(start, i+1));
                backtrack(s, i+1, list, results);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPalindrom(String s, int l, int r ){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    } */
}
