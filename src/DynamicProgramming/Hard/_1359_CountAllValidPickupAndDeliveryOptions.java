package DynamicProgramming.Hard;

/**
 * Created by Shuhua Song
 */
public class _1359_CountAllValidPickupAndDeliveryOptions {
    //Time = O(N^2), Space = O(N^2)
    long[][] memo;
    int MOD = (int)1e9+7;
    public int countOrders(int n) {
        memo = new long[n+1][n+1];
        return (int)backtrack(n, n);
    }

    private long backtrack(int unpick, int undeliver){
        //we have completed all orders
        if(unpick==0 && undeliver==0) return 1;
        //We can't pick or deliver more than n items
        //number of deliver can't be greater than pickups
        //because we can only deliver after a pickup
        if(unpick<0 || undeliver<0 || unpick>undeliver) return 0;
        //If the result is cached, we return it
        if(memo[unpick][undeliver] != 0) return memo[unpick][undeliver];

        //Count all choices of picking up an order
        long ways = unpick * backtrack(unpick-1, undeliver);
        //Handle integer overflow
        ways %= MOD;
        //Count all choices of delivering a picked order
        ways += (undeliver-unpick) * backtrack(unpick, undeliver-1);
        //Handle integer overflow
        ways %= MOD;
        memo[unpick][undeliver] = ways;
        return ways;
    }

    /*
    Permutation:
      Place N pickups we have N! ways, and to place N deliveries we have
      1 * 3 * 5 * (2*N-1) ways 
    //Time = O(N), Space = O(1)
    public int countOrders(int n) {
        long ans = 1;
        int MOD = (int)1e9+7;
        for(int i=1; i<=n; i++){
            //ways to arrange all pickups, 1*2*3*4..
            ans = ans * i;
            //ways to arrange all deliveries, 1*3*5*....
            ans = ans * (2*i-1);
            ans %= MOD;
        }
        return (int)ans;
    }
     */
}
