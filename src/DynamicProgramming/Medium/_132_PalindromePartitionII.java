package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _132_PalindromePartitionII {
    //BackTrack  + DP (top-down)
    //Time = O(N^2 * N),N^2 = recursive method getMinCut(), N/2 = isPalin()
    Integer[][] memoCuts;
    Boolean[][] isPalin;
    public int minCut(String s) {
        if(s==null || s.length()==0) return 0;
        int n = s.length();
        memoCuts = new Integer[n][n];
        isPalin = new Boolean[n][n];
        return getMinCut(s, 0, n-1, n-1);
    }

    private int getMinCut(String s, int start, int end, int minCuts){
        if(start==end || isPalindrome(s, start, end)){
            return 0;
        }
        if(memoCuts[start][end] != null) return memoCuts[start][end];
        for(int endCut=start; endCut<=end; endCut++){
            if(isPalindrome(s, start, endCut)){
                minCuts = Math.min(minCuts, 1+getMinCut(s, endCut+1, end, minCuts));
            }
        }
        memoCuts[start][end] = minCuts;
        return minCuts;
    }
    private boolean isPalindrome(String s, int lo, int hi){
        if(lo >= hi) return true;
        if(isPalin[lo][hi] != null) return isPalin[lo][hi];
        isPalin[lo][hi] = (s.charAt(lo)==s.charAt(hi) && isPalindrome(s, lo+1, hi-1));
        return isPalin[lo][hi];
    }

    //backtrack -- Time Limited Exceed
    // Time = O(N * 2^N), Space = O(N)
 /*   public int minCut(String s) {
        if(s==null || s.length()==0) return 0;
        int n = s.length();
        return getMinCut(s, 0, n-1, n-1);
    }

    private int getMinCut(String s, int start, int end, int minCuts){
        if(start==end || isPalin(s, start, end)){
            return 0;
        }

        for(int endCut=start; endCut<=end; endCut++){
            if(isPalin(s, start, endCut)){
                minCuts = Math.min(minCuts, 1+getMinCut(s, endCut+1, end, minCuts));
            }
        }
        return minCuts;
    }
    private boolean isPalin(String s, int lo, int hi){
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi)){
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    } */


}
