package DynamicProgramming.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1048_LongestStringChain {
    //Time = O(n (log(n) + L^2))
    //Space = O(n)

    public int longestStrChain(String[] words) {
        if(words==null || words.length==0) return 0;
        Arrays.sort(words, (a, b)->a.length()-b.length());
        int n = words.length, resLen = 1;
        Map<String, Integer> dp = new HashMap<>();
        for(String word : words){
            int currLen = 1;
            for(int i=0; i<word.length(); i++){
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String prevStr = sb.toString();
                int prevLen = dp.getOrDefault(prevStr, 0);
                currLen = Math.max(currLen, prevLen+1);
            }
            dp.put(word, currLen);
            System.out.println(word + " " + currLen);
            resLen = Math.max(resLen, currLen);
        }
        return resLen;
    }

    /*
    public int longestStrChain(String[] words) {
        if(words==null || words.length==0) return 0;
        Arrays.sort(words, (a, b)->a.length()-b.length());

        int n = words.length, res = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(isPredecessor(words[j], words[i])){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }

    private boolean isPredecessor(String pres, String s){
        if((pres.length()+1) != s.length()) return false;
        int count = 0, i = 0, j = 0;
        while(i<pres.length() && j<s.length()){
            if(pres.charAt(i) != s.charAt(j)){
                count++;
                j++;
            }else{
                i++;
                j++;
            }
        }
        if(j < s.length()) count++;
        return count==1;
    } */
}
