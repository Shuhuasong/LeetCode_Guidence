package Array.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _565_ArrayNesting {

    public int arrayNesting(int[] nums) {
        Set<Integer> seenNum = new HashSet<>();
        Set<Integer> seenIdx = new HashSet<>();
        int maxLen = 0, curLen = 0;
        for(int i=0; i<nums.length; i++){
            if(seenIdx.contains(i)) continue;
            while(!seenNum.contains(nums[i])){
                curLen++;
                seenNum.add(nums[i]);
                seenIdx.add(i);
                i = nums[i];
            }
            maxLen = Math.max(maxLen, curLen);
            curLen = 0;
        }
        return maxLen;
    }
}
