package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _474_OnesAndZeros {

    //Time = m*n*len
    //space = m*n

    //DP -- Iterative
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        for(String str : strs){
            int[] count = getNum(str);
            //the range of # 0 : count[0]-m
            //the range of # 1 : count[1]-n
            //with these two numbers, we need to update them in the array to
            //see wehter we consider the curr str or reject
            for(int zero=m; zero>=count[0]; zero--){
                for(int one=n; one>=count[1]; one--){
                    dp[zero][one] = Math.max(dp[zero-count[0]][one-count[1]]+1, dp[zero][one]);
                }
            }
        }
        return dp[m][n];
    }

    private int[] getNum(String s){
        int[] count = new int[2];
        for(char c : s.toCharArray()){
            count[c-'0']++;
        }
        return count;
    }

    /*
    //DP -- Recursion + Memozation
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        dp = new int[m+1][n+1][len+1];
        return dfs(strs, 0, m, n);
    }

    private int dfs(String[] strs, int index, int m, int n){
        if(index==strs.length || m+n==0) return 0;

        if(dp[m][n][index] > 0) return dp[m][n][index];
        int[] count = getNum(strs[index]);

        //consider the string
        int consider = 0;
        if(m>=count[0] && n>=count[1]){
            consider = 1 + dfs(strs, index+1, m-count[0], n-count[1]);
        }
        //skip the stsring
        int skip = dfs(strs, index+1, m, n);
        dp[m][n][index] = Math.max(consider, skip);
        return dp[m][n][index];
    }


    private int[] getNum(String s){
        int[] count = new int[2];
        for(char c : s.toCharArray()){
            count[c-'0']++;
        }
        return count;
    }

     */


/*
    //DP -- Recursion
    public int findMaxForm(String[] strs, int m, int n) {
        return dfs(strs, 0, m, n);
    }

    private int dfs(String[] strs, int index, int m, int n){
        if(index==strs.length || m+n==0) return 0;

        int[] count = getNum(strs[index]);

        //consider the string
        int consider = 0;
        if(m>=count[0] && n>=count[1]){
            consider = 1 + dfs(strs, index+1, m-count[0], n-count[1]);
        }
        //skip the stsring
        int skip = dfs(strs, index+1, m, n);

        return Math.max(consider, skip);
    }


    private int[] getNum(String s){
        int[] count = new int[2];
        for(char c : s.toCharArray()){
            count[c-'0']++;
        }
        return count;
    }

 */
}

/*
    m=5, n=3
            accept /    \reject
            "10"    m=4,n=2   m=5,n=3
            /a   \r      /a   \r
            "0001" ......


 */




