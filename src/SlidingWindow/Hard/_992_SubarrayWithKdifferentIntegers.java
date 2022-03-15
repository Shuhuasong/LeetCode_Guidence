package SlidingWindow.Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _992_SubarrayWithKdifferentIntegers {
    // Exactily(K) = atMost(K) - atMost(K-1);
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k)-atMost(nums, k-1);
    }
    private int atMost(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, res = 0, count = 0;
        for(int i=0; i<nums.length; i++){
            //find a new number which is not in map, increase count
            if(map.getOrDefault(nums[i], 0)==0) count++;
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            while(count > k){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left])==0) count--;
                left++;
            }
            //count<=k, in this window, any subarray have
            //at most k distinct number
            res += i-left+1;
        }
        return res;
    }
}

/*
if a subarray has k distinct elements, then total subarrays will be
n * (n+1)/2, which will include subarrays with k-1, k-2, k-3....distinct
elements;
example : [1, 2, 3], k = 1
res: [1], [2], [3], [1,2] [1,3], [1,2,3]
res = (1+3)*3/6 ===> use Gauss Alogirithm
*/
