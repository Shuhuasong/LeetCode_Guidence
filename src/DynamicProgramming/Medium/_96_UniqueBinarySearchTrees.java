package DynamicProgramming.Medium;

public class _96_UniqueBinarySearchTrees {

    public int numTrees(int n) {
        //dp[i] = means how many BST when there are i nodes
        int[] dp =new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        for(int a : dp){
            System.out.print(a + " ");
        }
        return dp[n];
    }
}

/*
state: dp[i]
init:   dp[0] = dp[1] = 0
function:  sum(dp[j] * dp[k-j-1]) (when total nodes is k, -1 is substract root)
results:  dp[n]

*/
