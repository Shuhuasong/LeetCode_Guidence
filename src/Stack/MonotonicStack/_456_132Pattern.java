package Stack.MonotonicStack;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _456_132Pattern {

    //monotonick Stack
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] minLeft = new int[n];
        minLeft[0] = nums[0];
        for(int i=1; i<n; i++) minLeft[i] = Math.min(minLeft[i-1], nums[i]);
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            int second = Integer.MIN_VALUE;
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                second = Math.max(second, stack.pop());
            }
            if(second > minLeft[i]) return true;
            stack.push(nums[i]);
        }
        return false;
    }


    /*
     //Better Brute Force
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;
        int min = nums[0];
        for(int i=1; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i] > nums[j] && nums[j] > min) return true;
            }
            min = Math.min(min, nums[i]);
        }
        return false;
    }
     */


    /*
      //Brute Force
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    if(nums[j] > nums[k] && nums[k] > nums[i]) return true;
                }
            }
        }
        return false;
    }
     */
}

/*
Solution-monotonik stack
Thinking process:
1)  if we fixed a largest one, how can we find a smallest one on the left side
2)  if we can ensure the left side is smallest one, how we can find second large one
Algorithm
1) use a minimum array to store the min value from left to right
2) use a stack, iterate the array from right side to left side, keep an decreasing stack;
   -once we find there is increasing, we pop the element from stack
     and store the pop element element as a second largest value
   -compare this second with minVal, if second > minVal ==> we found the tuple
 */



/*
[1,4,0,-1,-2,-3,-1,-2]
i < j < k
-3 < -2 < -1
nums[i] < nums[k] < nums[j]


[1,0,1,-4,-3]
[1,2,3,4]
[3,1,4,2]
[-1,3,2,0]
*/
