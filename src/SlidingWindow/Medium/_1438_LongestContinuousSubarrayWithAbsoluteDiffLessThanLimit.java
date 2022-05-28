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
    /*
     //Time = O(n)
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDeq = new ArrayDeque<>();
        Deque<Integer> maxDeq = new ArrayDeque<>();
        int maxLen = 0, left = 0;
        for(int i=0;i<nums.length; i++){
            while(!minDeq.isEmpty() && nums[i] < nums[minDeq.peekLast()]){
                minDeq.pollLast();
            }
            minDeq.addLast(i);

            while(!maxDeq.isEmpty() && nums[i] > nums[maxDeq.peekLast()]){
                maxDeq.pollLast();
            }
            maxDeq.addLast(i);

            while(nums[maxDeq.peekFirst()]-nums[minDeq.peekFirst()] > limit){
                if(minDeq.peekFirst()==left){
                    minDeq.remove(left);
                }
                if(maxDeq.peekFirst()==left){
                    maxDeq.remove(left);
                }
                left++;
            }
            maxLen = Math.max(maxLen, i-left+1);
        }
        return maxLen;
    }
     */
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



Solution - 1: use treeset
1) keep a sliding window by itereate numbers and add the index into treeset.
2) check if the largest-smallest=diff is greater than limit. If it is, we need
   to shrink the window size by move forward the left pointer
3) once the diff is valid, we update the answer

Solution - 2: use two queue
1) use a increase queue and decreasing queue to keep the data

[8, 2, 4, 7]  max-min=diff
 |left
i=0
increase: 8
decrease: 8
-----------
i=1
increase: 2   (2 is smaller than 8, so 8 was kicked out)
decrease: 8 2 (2 is add into decrease queue since 2 < 8)

increase: 2
decrease: 2
since 8-2>limit, so we need to pop the value on the left pointer(8), and left++
-----------
i=2
increase: 2 4 (4 is add into decrease queue since 4 > 2)
decrease: 4   (2 is smaller than 4, so 2 was kicked out)
i=3
increase: 2 4 7 (7 is add into decrease queue since 7 > 2)
decrease: 7     (4 is smaller than 7, so 7 was kicked out)
since 7-2>limit, so we need to pop the value on the left pointer(2), and left++ (2)
increase: 4 7 (7 is add into decrease queue since 7 > 2)
decrease: 7     (4 is smaller than 7, so 7 was kicked out)
since 7-4=3 < limit, so the answer is : n-2+1 = 4-2+1 = 3
*/



