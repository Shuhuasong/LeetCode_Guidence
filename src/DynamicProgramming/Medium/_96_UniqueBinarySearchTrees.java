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
e.g:
i = 2
j = 1 : dp[2] += dp[0] * dp[1] = 1 * 1 = 1
j = 2 : dp[2] += dp[1] * dp[0] = 1 + 1 * 1 = 2
i = 3
j = 1 : dp[3] += dp[0] * dp[2] = 1 * 2
j = 2 : dp[3] += dp[1] * dp[1] = 2 + 1 * 1
j = 3 : dp[3] += dp[2] * dp[0] = 3 +  2 * 1
*/

/*
intuitive:
Assuem there are a sequence of number:
      [1, 2, 3, 4, 5, 6, 7]
   G(i-1)BST |  G(n-i) BST
   G(2)         G(4)

we want to use it to build unique BST. We can iterate each
number i(e.g 3) as root, and use the number on the left [1,2]
and right[4, 5, 6,7] as left subtree and right subtree.
F(i, n) = F(3, 7) = G(2) * G(4) (cartesian product)
G(0) = 1 (empty tree), G(1) = one node
G(n) = SUM_i [G(i-1)*G(n-i)] (0 <= i <= n)

n = 5
l = 0, r = 4
l = 1, r = 3
l = 2, r = 2
l = 3, r = 1
l = 4, r = 0
*/
