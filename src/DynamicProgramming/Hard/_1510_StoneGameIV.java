package DynamicProgramming.Hard;

/**
 * Created by Shuhua Song
 */
public class _1510_StoneGameIV {

    //DP
    //Time = O(N*sqrt(N)), we spend O(sqrt(N)) at most for each dfs call
    //       and there are O(N) dfs calls in total
    //Space = O(N), need this space to store dfs's result
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        for(int i=0; i<n+1; i++){
            for(int k=1; k*k<=i; k++){
                if(dp[i-k*k]==false){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    /*
     //DFS==TLE
    public boolean winnerSquareGame(int n) {
        if(n==1) return true;
        return dfs(n);
    }

    private boolean dfs(int remain){
        if(remain==0) return false;
        if(remain==1) return true;
        for(int i=1; i*i<=remain; i++){
            //If there is any chance to make the opponent lose the game in
            // the next round, then the current play wins
            if(!dfs(remain-i*i)){
                return true;
            }
        }
        return false;
    }
     */

    /*
      //DFS + memo
    //Time = O(N*sqrt(N)), we spend O(sqrt(N)) at most for each dfs call
    //       and there are O(N) dfs calls in total
    //Space = O(N), need this space to store dfs's result
    public boolean winnerSquareGame(int n) {
        if(n==1) return true;
        HashMap<Integer, Boolean> memo = new HashMap<>();
        return dfs(n, memo);
    }

    private boolean dfs(int remain, HashMap<Integer, Boolean> memo){
        if(memo.containsKey(remain)){
            return memo.get(remain);
        }
        if(remain==0){
            memo.put(0, false);
            return false;
        }
        if(remain==1){
            memo.put(1, true);
            return true;
        }
        for(int i=1; i*i<=remain; i++){
            //If there is any chance to make the opponent lose the game in
            // the next round, then the current player wins
            if(!dfs(remain-i*i, memo)){
                memo.put(remain, true);
                return true;
            }
        }
        memo.put(remain, false);
        return false;
    }
     */
}
