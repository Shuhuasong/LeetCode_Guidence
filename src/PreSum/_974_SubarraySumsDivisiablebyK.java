package PreSum;

/**
 * Created by Shuhua Song
 */
public class _974_SubarraySumsDivisiablebyK {

    public int subarraysDivByK(int[] A, int K) {
        int n = A.length;
        int[] preSum = new int[n+1];
        for(int i=1; i<=n; i++){
            preSum[i] = A[i-1] + preSum[i-1];
        }
        int[] count = new int[K];
        for(int p : preSum){
            count[(p%K+K)%K]++;
        }
        int res = 0, curCount = 0;
        for(int c : count){
            if(c > 1){
                curCount = c*(c-1)/2;
                res += curCount;
            }
        }
        return res;
    }
}

 /*
 /*
We calculate all possible r's and map them to their counts, map[r] = count, there are two situations:

---r != 0, then count * (count - 1) / 2 subarrays found, we can combine any two preSum with same reminder. they are must can    be divided by K
---r == 0, the sum itself is divisible by k, thencount subarrays found
Please note that when calculate sum % K for sum < 0, we keep adding K to sum until sum is above 0 then mod K.
               intput
          R    4  5  0  -2  -3  1
reminder  4  | 4 |
          4  | 9    |
          4  | 9       |
          2  | 7            |
          4  | 4               |
          0  | 5                   |
             | preSum
*/





