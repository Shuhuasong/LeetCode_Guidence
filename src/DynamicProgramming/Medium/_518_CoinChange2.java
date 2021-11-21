package DynamicProgramming.Medium;

/**
 * Created by Shuhua Song
 */
public class _518_CoinChange2 {
    public int change(int amount, int[] coins) {
        //dp[i] : the number of ways to form the amunt of i
        int[] dp = new int[amount+1];
        dp[0] = 1; // no chose coin to form amout 0
        for(int coin : coins ) {
            for(int  i=coin; i<=amount; i++) {
                dp[i]  += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
/*
Algorithm:
--initialize number of combinations array with base case no coins :dp[0] = 1
  and all the rest = 0
  -- Loop over all coins:
     --For each coin, loop over all amounts from 0 to amount:
        --for each amount x, compute the number of combinations : dp[x] += dp[x-coin]
  -- return dp[amount]

e.g : amount = 10, coins = {2, 5, 10 }

1 0 1 0 1 0 1 0 1 0 1 0
1 0 1 0 1 1 1 1 1 1 2 1
1 0 1 0 1 1 1 1 1 1 3 1
*/


