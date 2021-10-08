package DynamicProgramming.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _368_LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        int maxSize = -1;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i]%nums[j]==0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(maxSize < dp[i]){
                maxSize = dp[i];
            }
        }
        int prev = -1;
        List<Integer> res = new ArrayList<>();
        for(int i=n-1; i>=0; i--){
            if(dp[i]==maxSize && (prev==-1 || prev%nums[i]==0)){
                res.add(nums[i]);
                maxSize -= 1;
                prev = nums[i];
            }
        }
        return res;
    }
}

/*
Longest Increasing subSequence:
1) Sorting
2) Apply DP
3) find subset
e.g.
 0  1  2   3  index
 1  2  3   6  array
 1  2  2   3  dp

 Time = O(Nlogn + N^2 + N)
 Nlogn : sort
 N^2 : dp
 N : find subset
 */



