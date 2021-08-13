package HashTable.Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuhua Song
 */
public class _128_LongestConsecutiveSequence {
    //Time = O(n) Space = O(n)
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        // if(nums.length==1) return 1;
        Set<Integer> set = new HashSet<>();
        for(int a : nums) set.add(a);
        int res = 0, curCount = 1;
        for(int a : nums){
            if(!set.contains(a-1)){
                while(set.contains(a+1)){
                    curCount++;
                    a = a + 1;
                }
            }
            res = Math.max(res, curCount);
            curCount = 1;
        }
        return res;
    }
}
