package DynamicProgramming.Medium;

public class _91_DecodeWays {

    //Time = O(n) Space = O(n)
    public int numDecodings(String s) {
        if(s==null || s.length()==0) return 0;
        int n = s.length();
        //dp[i] : store the number of decode ways for substring of s from index 0 to index i-1
        int[] dp = new int[n+1];
        //show nothing to deconde is one way
        //Initialize dp array. dp[0] = 1 to provide the baton to be passed.
        dp[0] = 1;
        //ways to decode a string of size 1 is 1. '0' doesn't have a single digit secode
        dp[1] = s.charAt(0)=='0' ? 0 : 1;
        for(int i=2; i<=n; i++){
            //the current digit is valid single decode. thus whatever is in dp[i-1], we copy to dp[i].
            //this means if there are N ways of reaching dp[i-1], then those N ways also lead to dp[i]
            if(s.charAt(i-1) != '0'){
                dp[i] = dp[i-1];
            }
            //check if the two digit decode is possible. "226", at index 2, the previous two number 22 is valid,
            //so we can add the total decode ways from dp[i-2] into dp[i], the decode ways that lead to dp[i-2], it also lead to dp[i]
            //"326", "32" is not valid decode, thus the decode path that lead to dp[i] do not lead to dp[i]
            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            if(twoDigit>=10 && twoDigit<=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
