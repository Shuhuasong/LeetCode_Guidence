package Prefix_Sum.Medium;

/**
 * Created by Shuhua Song
 */
public class _1524_NumberOfSub_ArraysWithOddSum {

    //Time = o(n), Space = O(1)
    //Note: odd-even = odd(15-4=11), even-odd=odd(14-7=7)
    public int numOfSubarrays(int[] arr) {
        int n = arr.length, preSum = 0;
        int even = 1, odd = 0;//track the number of even or odd preSum
        int res = 0, MOD = (int)1e9+7;
        for(int i=0; i<n; i++){
            preSum += arr[i];
            if(preSum%2==0){
                even++;
                res = (res+odd)%MOD;
            }else{
                odd++;
                res = (res+even)%MOD;
            }
        }
        return res;
    }

    /*
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
    }*/
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
