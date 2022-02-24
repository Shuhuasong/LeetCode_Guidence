package Prefix_Sum.Medium;

/**
 * Created by Shuhua Song
 */
public class _1524_NumberOfSub_ArraysWithOddSum {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int res = 0, MOD = (int)1e9+7;
        int[] preSum = new int[n+1];
        for(int i=0; i<n; i++){
            preSum[i+1] = preSum[i]+arr[i];
        }
        for(int i=0; i<=n; i++){
            if(preSum[i]%2==0) preSum[i] = 0;
            else
                preSum[i] = 1;
        }
        int zero = 0, one = 0;
        for(int i=0; i<=n; i++){
            if(preSum[i]==0){
                zero++;
                res = (res+one)%MOD;
            }else{
                one++;
                res = (res+zero)%MOD;
            }
        }
        return res;
    }
}

/*
Solution: prefix Sum
e.g
arr =    [1, 2, 3,  4, 5,   6,  7]
presum = {1, 3, 6, 10, 15, 21, 28}
preSum = {1, 1, 0,  0,  1,  1,  0}
if the current accu sum is odd, we care only about
previous even accu sums and vice versa.
    For each element in A:
if current prefix sum is even, res += the number of odd prefix sum
if current prefix sum is odd, res += the number of even prefix sum
*/
