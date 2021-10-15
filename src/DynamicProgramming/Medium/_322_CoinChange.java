package DynamicProgramming.Medium;

import java.util.Arrays;

/**
 * Created by Shuhua Song
 */
public class _322_CoinChange {

    //Dynamic Programming
    //Time = O(S * n), S = amount, for each amount, we need to iterate the different coins
    //Space = O(S)
    public int coinChange(int[] coins, int amount) {
        //dp[i] : store the least number of coins to form amount i
        int[] dp = new int[amount+1];
        //if we assign Integer.MAX_VALUE(instead amount+1), it will cause overflow when +1
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1; i<= amount; i++){
            for(int coin : coins){
                if(i-coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        //if the dp[amount] has update, then return, otherwise, return -1;
        return dp[amount] == (amount+1) ? -1 :  dp[amount];
    }


/*
    //2-Recursive + memoization
    //Time = O(S * n), S = amount, for each amount, we need to iterate the different coins
    //Space = O(S)
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        //use memo[i] to store the fewest number of coins to make up the amount i
        memo = new int[amount+1];
        //Solve the problem recursively
        return recursionHelper(coins, amount);
    }

    private int recursionHelper(int[] coins, int remain){
        //Cannot make up a negative amount
        if(remain < 0) return -1;
        //Do not need to choose a coin to make up 0 amount
        if(remain == 0) return 0;
        //Declare a variable to update the minCount
        if(memo[remain] != 0) return memo[remain];
        int minCount = Integer.MAX_VALUE;
        for(int coin : coins){
            //Choose a coin, solve the subproble and update the minCount
            int count = recursionHelper(coins, remain-coin);
            if(count==-1) continue;
            minCount = Math.min(minCount, count+1);
        }
        memo[remain] =  minCount ==Integer.MAX_VALUE ? -1 : minCount;
        //Return the minCount if it has been updated, otherwise return -1;
        return memo[remain];
    }

 */


/*
    // 1- Recursive (TLE_
    // Time : O(S^n), S = amount
    // Space : O(n), the depth of the recursion
    public int coinChange(int[] coins, int amount) {
        //Solve the problem recursively
        return recursionHelper(coins, amount);
    }

    private int recursionHelper(int[] coins, int remain){
        //Cannot make up a negative amount
        if(remain < 0) return -1;
        //Do not need to choose a coin to make up 0 amount
        if(remain == 0) return 0;
        //Declare a variable to update the minCount
        int minCount = Integer.MAX_VALUE;
        for(int coin : coins){
            //Choose a coin, solve the subproble and update the minCount
            int count = recursionHelper(coins, remain-coin);
            if(count==-1) continue;
            minCount = Math.min(minCount, count+1);
        }
        //Return the minCount if it has been updated, otherwise return -1;
        return minCount ==Integer.MAX_VALUE ? -1 : minCount;
    }

    /*
 */
}

/*
/*
Approach #1: (Brute Force--Recursion) Time Limit Exceeeded
                    11
             /(1)   | (2)    \ (5)
           10       9        6
        /1 |2 \5  /1|2 \5  /1|2\5
       9   8   5 8  7   4 5  4   1
     / | \                     / | \
    8  7  4                   0 -1 -1


Approach #2 : Dynamic Programmin
define :     dp[i] : store the least number of coins to form amount i
init state : dp[i] = 0
transition function: dp[i] = min(dp[i], dp[i-coin]+1)
*/



