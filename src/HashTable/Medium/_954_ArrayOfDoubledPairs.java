package HashTable.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _954_ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        //Time = O(nlogn), Space = O(n)
        Integer[] nums = new Integer[arr.length];
        int i=0;
        for(int a : arr) nums[i++] = a;
        Arrays.sort(nums, (a, b)->(Integer.compare(Math.abs(a), Math.abs(b))));
        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int a : arr){
            freq.put(a, freq.getOrDefault(a, 0)+1);
        }
        for(int a : nums){
            //If this can't be consumed, skip it
            if(freq.get(a)==0) continue;
            //if this doesn't have a doubled partner, the anser is false
            if(freq.getOrDefault(2*a,0) <=0){
                return false;
            }
            //if both x, 2x exist, remove one of each
            freq.put(a, freq.get(a)-1);
            freq.put(2*a, freq.get(2*a)-1);
        }
        return true;
    }
}
