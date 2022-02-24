package Prefix_Sum.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1590_MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        //Change all the variable to long type
        long total = 0, res = Integer.MAX_VALUE;
        for(int num : nums)
            total = (total+num)%p; //note1: need to mod p, otherwise, the total will too large
        long r0 = total%p;
        if(r0==0) return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, -1); //the first index should be -1
        long preSum = 0;
        for(int i=0; i<nums.length; i++){
            preSum += nums[i];
            long r = preSum % p;
            //if r-r0 is negative
            long newR = (r-r0+p)%p;
            if(map.containsKey(newR)){
                int preIdx = map.get(newR) + 1; //preSum[i-1] % p ==> r-r0
                res = Math.min(res, i-preIdx+1);
            }
            map.put(r, i);
        }
        return res >= nums.length ? -1 : (int)res;
    }
}


/*

 XXXX[iXXXXj]XXXX
        sub
 if we need to remove sub so the remain sum is divisible by p: remain_sum%p = r0(removed) + 0
 then: sum[i:j] = r0
       sum[i:j] = presum[j]-presum[i-1]
           r0        r        r-r0
           3         1         -2 + 5(再加一个余数周期)
Map[r]  = i
prefix + hash + mod
hash[prefix[i]%mod] = index

假设整个数组的和除以P的余数是r0. 题目要求subarray的剩余数字和除以P于0，那么就意味着这个subarray sum除以P的余数就是r0. 于是本题就转化成了求最短的subarray，满足和是r0.

假设我们探索这样的subarray，令其右边界是j，那么左边界i可以取在哪里呢？我们可以利用前缀和的思想。如果presum[j]%P==r，那么我们必然要求presum[i]%P==r-r0（当然如果r-r0<0，那么我们就要补上一个周期变成r-r0+P）. 所以我们转化为了求与j最接近的索引i，满足presum[i]%P==r-r0。 显然，我们在遍历之前的presum的时候，可以每次都求一下它除以P的余数，然后存下余数->索引的映射关系。此时，我们就可以直接调用Map[r-r0]得到该余数对应的、最近的presum的索引值。

本题要注意，计算totalSum和preSum的过程中，都有可能会溢出。但事实上，所有的操作都和取余有关，所以我们只需要每一步求和都取余就行了。
*/