package TwoPointer.Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _992_SubarraysWithKdifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k)-atMost(nums, k-1);
    }

    private int atMost(int[] nums, int k){
        int n = nums.length, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        for(int r=0; r<n; r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            while(map.size() > k){
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l])==0)  map.remove(nums[l]);
                l++;
            }
            res += r-l+1;
        }
        return res;
    }
}

/*

at most 2 diff integer
[1, 2, 1, 2, 3]
*/

