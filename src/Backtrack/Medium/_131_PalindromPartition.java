package Backtrack.Medium;

import java.util.ArrayList;
import java.util.List;

public class _131_PalindromPartition {

    //Backtracking with Dynamic Programming
    //Time = O(n * 2^n)  Space = O(n*n)
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if(s==null || s.length()==0) return results;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dfs(s, 0, results, new ArrayList<>(), dp);
        return results;
    }

    private void dfs(String s, int start, List<List<String>> results, List<String> curList, boolean[][] dp){
        if(start==s.length()){
            results.add(new ArrayList<String>(curList));
        }

        for(int i=start; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(start) && (i-start<=2 || dp[start+1][i-1])){
                dp[start][i] = true;
                curList.add(s.substring(start, i+1));
                dfs(s, i+1, results, curList, dp);
                curList.remove(curList.size()-1);
            }
        }
    }


    //Time = O(n * 2^n)  Space = O(n)
 /*   public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        dfs(s, 0, results, new ArrayList<>());
        return results;
    }

    private void dfs(String s, int start, List<List<String>> results, List<String> curList){
        if(start == s.length()){
            results.add(new ArrayList<String>(curList));
        }

        for(int i=start; i<s.length(); i++){
            String str = s.substring(start, i+1);
            if(isPalindrom(str)){
                curList.add(str);
                dfs(s, i+1, results, curList);
                curList.remove(curList.size()-1);
            }
        }
    }

    private boolean isPalindrom(String s){
        int l = 0, r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

  */


}
