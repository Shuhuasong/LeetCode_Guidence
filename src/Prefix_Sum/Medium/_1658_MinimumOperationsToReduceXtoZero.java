package Prefix_Sum.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _1658_MinimumOperationsToReduceXtoZero {

    //Min(preFix+sufix)==Max(subArray)
    public int minOperations(int[] nums, int x) {
        int n = nums.length, preSum = 0;
        int left = 0, maxLen = -1, total = 0;
        for(int num : nums) total += num;
        int target = total-x;//the sum for the Subarray

        for(int right=0; right<n; right++){
            preSum += nums[right];
            while(preSum >target && left <= right){
                preSum -= nums[left];
                left++;
            }
            if(preSum==target){
                maxLen = Math.max(maxLen, right-left+1);
                //System.out.println(maxLen);
            }
        }
        return maxLen==-1 ? -1 : n-maxLen;
    }


 /*   public int minOperations(int[] nums, int x) {
        int n = nums.length, preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i=0; i<n; i++){
            preSum += nums[i];
            if(!map.containsKey(preSum)){
                map.put(preSum, i);
            }
        }
        if(x > preSum) return -1;
        int res = Integer.MAX_VALUE;
        if(map.containsKey(x)) res = map.get(x)+1;
        int sufixSum = 0;
        for(int i=n-1; i>=0; i--){
            sufixSum += nums[i];
            int prefix = x-sufixSum;
            if(map.containsKey(prefix)){
                int preIdx = map.get(prefix);
                res = Math.min(res, preIdx+1 + n-i);
            }
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }

  */
}

/*
Question: Maximum Size Subarray Sum Equals K (when input array only with positive number)
        Solution-1: Two Pointer


        Solution-2: Prefix + HashMap
        本题的题意是：在nums数组里找a个元素的前缀和，与b个元素的后缀和，使得他们的sum是x，问如果能找到的话，a+b最少是多少？

        比较直观的算法就是：从右往左遍历b的数目，给定了b，我们就要确定多少个元素的前缀和presum[a]，恰好等于x-sufsum[b]。显然，我们可以提前遍历数组来构建所有presum[i]->i的hash表。利用这个hash表就能用o(1)时间快速得到指定前缀和所对应的位置。只要这个位置i小于b，那么i和b就是一对合法的解。

        最终答案是遍历所有的b，找到i+(n-b)的最小值。
*/