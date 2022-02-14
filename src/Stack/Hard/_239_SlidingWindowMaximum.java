package Stack.Hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Shuhua Song
 */
public class _239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int j = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int l = 0;
        for(int r=0; r<n; r++){

            if(!stack.isEmpty() && stack.peekFirst()==r-k){
                stack.removeFirst();
            }

            while(!stack.isEmpty() && nums[stack.peekLast()] < nums[r]){
                stack.pollLast();
            }
            stack.addLast(r);
            if(r >= k-1){
                res[r-k+1] = nums[stack.peekFirst()];
            }
        }
        return res;
    }

    /*
     //Dynamic Programming--left/right pass
    //Time = O(n), Space = O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n*k==0) return new int[0];
        if(k==1) return nums;
        int[] res = new int[n-k+1];
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0]; right[n-1] = nums[n-1];

        for(int i=1; i<n; i++){
            //pass from left to right
            if(i%k==0){
                left[i] = nums[i];
            }else{
                left[i] = Math.max(left[i-1], nums[i]);
            }
            //pass from right to left
            int r = n-i-1;
            if((r+1)%k==0){
                right[r] = nums[r];
            }else{
                right[r] = Math.max(nums[r], right[r+1]);
            }
        }
        for(int i=0; i<n-k+1; i++){
            res[i] = Math.max(left[i+k-1], right[i]);
        }
        return res;
    }
     */
}

/*
Solution1---MonotonicQueue
1) use ArrayDeque to store the index, and keep an increasing stack
2) check if the front_index == current_index-k(0 == 3-3)
   the window size is greater than k(3) if we try to add
   current_index into queue.
3) check if elem in the end of queue is smaller than curr_num,
   if it is, than we need to poll it out of queue.
   then, add the current_index into queue.
4) if the r pointer is greater or equal k-1, then we can collect the answer

*/
