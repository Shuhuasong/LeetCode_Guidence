package HashTable.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 */
public class _697_DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> leftIdx = new HashMap<>();
        Map<Integer, Integer> rightIdx = new HashMap<>();
        int maxFreq = 0, n = nums.length;
        for(int i=0; i<n; i++){
            int val = nums[i];
            if(leftIdx.get(val) == null) leftIdx.put(val, i);
            rightIdx.put(val, i);
            freq.put(val, freq.getOrDefault(val, 0)+1);
            maxFreq = Math.max(maxFreq, freq.get(val));
        }
        int minLen = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int val = nums[i];
            if(freq.get(val)==maxFreq){
                minLen = Math.min(minLen, rightIdx.get(val)-leftIdx.get(val)+1);
            }
        }
        return minLen;
    }
}
