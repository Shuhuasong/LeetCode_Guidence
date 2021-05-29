package Array.Medium;

import java.util.HashSet;
import java.util.Set;

/*
Time = O(n)  Space = (n)
Athough the time complexity appears to be quadratic due to the while loop
nested within for loop, but because the inner while loop is only reached
when curNum is the beginning of the sequence. And the while loop can only run n times
throughout the entire runtime of the algorithm. so that it is
O(n+n) = n + 1 *  O(n)
 */

public class _128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int a : nums) { set.add(a); }
        int  res = 0, curNum = -1;
        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i]-1)){
                int count = 0;
                curNum = nums[i];
                while(set.contains(curNum)){
                    count++;
                    curNum++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
