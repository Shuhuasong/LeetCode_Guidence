package DynamicProgramming.Medium;

public class _375_GuessNumberHigherOrLowerII {

      /*
    idea: Given by n, we guess k. Then we break the interval [1,n] into [1, k-1] and [k+1, n].
          The min of worst cost can be calculated recursively as :
          cost[1, n] = k + max(cost[1, k-1], cost[k+1, n]);
    "Min of Max cost": we can understand in this way==> your startegy is the best, but your luck
          is the the worst. You only guess right when there is no possibility to guess wrong. */

    //Time = O(n^2)
    public int getMoneyAmount(int n) {
        //Add 1 to the length just to make sure the index the same as numbers used
        //dp[i][j] : meas the min cost in the worst case for number(i....j)
        int[][] dp = new int[n+1][n+1];
        //when len = 1, the range[3,3] with only one number, no need money to guess
        //iterate all the intervals with len, the start is s. so the interval is [s, s+(len-1)];
        for(int len=2; len<=n; len++){
            for(int s=1; s<=n-len+1; s++){ //the maximum for s = n
                int e = s+len-1;
                dp[s][e] = Integer.MAX_VALUE;
                //loop all guess
                for(int k=s; k<=e; k++){
                    int currGuestCost = 0;
                    //since k == n is last integer, n+1 is not exist, we have to sepearte this case
                    if(k==n){
                        currGuestCost = dp[s][k-1] + k;
                    }else{
                        currGuestCost = k+Math.max(dp[s][k-1], dp[k+1][e]);
                    }
                    //when k=n, k=n+1 out of range, so we need to add one rows and columns
                    dp[s][e] = Math.min(dp[s][e],  currGuestCost);
                }
            }
        }
        return dp[1][n];
    }


    /*
    //Time = O(n^2)
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+2][n+2];
        //when len = 1, the range[3,3] with only one number, no need money to guess
        for(int len=2; len<=n; len++){
            for(int s=1; s<=n-len+1; s++){ //the maximum for s = n
                int e = s+len-1;
                dp[s][e] = Integer.MAX_VALUE;
                for(int k=s; k<=e; k++){
                    //when k=n, k=n+1 out of range, so we need to add one rows and columns
                    dp[s][e] = Math.min(dp[s][e], k+Math.max(dp[s][k-1], dp[k+1][e]));
                }
            }
        }
        return dp[1][n];
    }
    */



   /*
    public int getMoneyAmount(int n) {
        //dp ; refers to the minimum cost of finding the worst number given only the number in the range(i, j)
        int[][] dp = new int[n+1][n+1];
        return dfs(dp, 1, n);
    }

    private int dfs(int[][] memo, int low, int high){
        if(low >= high) return 0;
        if(memo[low][high] != 0) return memo[low][high];
        int res = Integer.MAX_VALUE;
        for(int i=low; i<=high; i++){
            //choose the side which need max money that we can play
            int cost = i + Math.max(dfs(memo, low, i-1), dfs(memo, i+1, high));
            //Then we take the minimum in these max money, then it guarantee that we can guess the number
            res = Math.min(res, cost);
        }
        memo[low][high] = res;
        return res;
    }  */
}


/*
Intuitive:
1) understand the question
1 2 3 4 5
To guess a number, it is not gurantee the number in the middle is teh best
3 + 4 = 7
4 + 2 = 6
Top-down: 0
          |
1: 1 + ([1,0], [2, 3, 4, 5])
2 : 2 + max([1], [3, 4, 5])
3 : 3 + max([1, 2], [4, 5])
4 : 4 + max([1, 2, 3], [5])
5 : 5 + max([1, 2, 3, 4], [6, 5]) // [6, 5]==> 0
2) transfer the recursion to Dynamic Programming
   faster than recursion + memoization
   1st loop: set a lenght for outer loop, from small range to large range
   2nd loop: set a start point, note the largest of start point, e.g start<=n-len+1
             use the length and start point to define end point
   3rd loop: set a guess point, use the transfer function:
   dp[start][end] = k + max(dp[start][k-1], dp[k+1][end])
3) consider the corner case


*/
