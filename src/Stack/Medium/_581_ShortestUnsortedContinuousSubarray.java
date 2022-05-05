package Stack.Medium;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _581_ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i-1]>nums[i]){
                minVal = Math.min(minVal, nums[i]);
            }
        }
        for(int i=n-2; i>=0; i--){
            if(nums[i]>nums[i+1]){
                maxVal = Math.max(maxVal, nums[i]);
            }
        }
        int i, j;
        for(i=0; i<n; i++){
            if(minVal < nums[i]) break;
        }
        for(j=n-1; j>=0; j--){
            if(maxVal > nums[j]) break;
        }
        return j-i<0 ? 0 : j-i+1;
    }
}

    /*
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int left = n, right = 0;
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        return right-left>0 ? right-left+1 : 0;
    }
} */

/*
 public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int left = 0, right = nums.length-1;
        while(left <= right){
            while(left <= right && nums[left]==arr[left]){
                left++;
            }
            while(left <= right && nums[right]==arr[right]){
                right--;
            }
            break;
        }
        return right-left+1;
    }
 */

/*
Solution-3: left Scan + right Scan
1) scan from left to right, find the minElem whenever
   there is foiling(it suppose to increasing)
2) scan from rigth to left, find the maxElem whenever
   there is raising(it suppose to decreasing)
3) traverse over nums from left side, find the first element which is just larger than min
4) traverse over nums from right side, find the first
   element which is just smaller than max



[1,2,3,4]
[2,6,4,8,10,9,15]
[1]

*/
