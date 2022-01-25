package SlidingWindow.Medium;

import java.util.TreeMap;

/**
 * Created by Shuhua Song
 */
public class _1438_LongestContinuousSubarrayWithAbsoluteDiffLessThanLimit {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int maxLen = 0;
        int maxEle = Integer.MIN_VALUE, minEle = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int l = 0;
        for(int r=0; r<n; r++){
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            int diff = Math.abs(map.lastKey()-map.firstKey());
            while(diff > limit){
                map.put(nums[l], map.getOrDefault(nums[l], 0)-1);
                if(map.get(nums[l])==0) map.remove(nums[l]);
                l++;
                diff = Math.abs(map.lastKey()-map.firstKey());
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}

/*
Solution:
1) Use treemap to keep a max value and min value in a sliding window;
2) Use the two pointer, move right pointer as far as possible to the
   right until the subarray is not valid (maxVal-minVal > limit),
   then move the left pointer until the subarray is valid again (
   maxVal-minVal <= limit). Keep repeating this process.

minEle maxEle

8 2 1 3 8 4 5 6 7
*/

