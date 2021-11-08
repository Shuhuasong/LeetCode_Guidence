package DynamicProgramming.Example;

/**
 * Created by Shuhua Song
 */
/*
Given weights and values of n items, put these items in a knapsack of capacity W
to get the maximum total value in the knapsack.
items:
total weight  W = 7
weight[] = {1,3,4,5}
values[] = {1,4,5,7}

val   weight   0  1  2  3  4  5  6  7
1        1     0  1  1  1  1  1  1  1
4        3     0  1  1  4  5  5  5  5
5        4     0  1  1  4  5  6  6  9
7        5     0  1  1  4  5  7  8  9

Case 1: The item is included in the optimal subset.
Case 2: The item is not included in the optimal set.
 */

public class _01Knapsack_Problem {


    //Memoization + dp
    //
    static int[][] dp;
    public static int knapSack(int W, int[] wt, int[] val, int n){
        dp = new int[n+1][W+1];
        if(n==0 || W==0) return 0;
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(wt[n-1] > W){
            return dp[n][W] = knapSack(W, wt, val, n-1);
        }
        else{
            return Math.max(knapSack(W, wt, val, n-1),
                    knapSack(W-wt[n-1], wt, val, n-1)+val[n-1]);
        }
    }


    //Recursion
    //function computes the same sub-problems again and again
    //Time = O(2^n)
/*    public static int knapSack(int W, int[] wt, int[] val, int n){
        if(n==0 || W==0) return 0;

        if(wt[n-1] > W){
            return knapSack(W, wt, val, n-1);
        }
        else{
            return Math.max(knapSack(W, wt, val, n-1),
                            knapSack(W-wt[n-1], wt, val, n-1)+val[n-1]);
        }
    }
 */


    public static void main(String[] args) {
        int wt[] = new int[] { 1,3,4,5 };
        int val[] = new int[] { 1,4,5,7};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
