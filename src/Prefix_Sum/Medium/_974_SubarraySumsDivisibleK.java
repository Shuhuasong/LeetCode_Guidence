package Prefix_Sum.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _974_SubarraySumsDivisibleK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0, res = 0;
        for(int num : nums){
            preSum += num;
            int reminder = preSum >= 0 ? preSum%k : (preSum%k+k)%k;
            if(map.containsKey(reminder)){
                res += map.get(reminder);
            }
            map.put(reminder, map.getOrDefault(reminder, 0)+1);
        }
        return res;
    }
}

/*
Solution: Prefix-Sum + map
when we fix the right position j, where is the left position i, so
the sum[i : j] is divisible by k ?
If we want sum[i:j] divisible by k, then presum[i] and presum[j-1]
must have the same reminder. So we need to record where we have the
same reminder of preSum:
e.g
nums =    {4, 5, 0, -2, -3, 1}, k = 5
presum =  {4, 9, 9,  7,  4, 5}, k = 5  ==> preSum % k
reminder= {4, 4, 4,  2,  4, 0}

我们考虑右端点在i位置的话，符合条件的区间的左端点j在哪里？如果我们将区间和转化为前缀和来看，
sum[i:j]能被K整除的充要条件就是：presum[i]和presum[j-1]除以K的余数相同。于是我们用
计数器记录i之前presum对K除的余数各自出现了多少次。如果presum[i]%K=r，那么count[r]
就意味着有多少个位置j能配对成符合条件的区间。

注意前缀和可能是负数，而C++中整除的余数允许是负数。所以我们在计算余数的时候需要转化为 (presum % k + k) % k。
*/