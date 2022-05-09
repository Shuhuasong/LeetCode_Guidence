package Stack.MonotonicStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _496_NextGreaterElementI {


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] nextGreater = new int[n2];
        Arrays.fill(nextGreater, -1);
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n2; i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                int idx = stack.pop();
                nextGreater[idx] = nums2[i];
            }
            map.put(nums2[i], i);
            stack.push(i);
        }
        int[] ans = new int[n1];
        for(int i=0; i<n1; i++){
            int idx2 = map.get(nums1[i]);
            ans[i] = nextGreater[idx2];
        }
        return ans;
    }

    /*
      //Stack Time = O(m + n)
    /*
    Algorithm;
    1) keep an decreasing nums in stack
    2) if an element if greater than stack.top(), then we pop all the stack.pop < nums[i]
     */
  /*  public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] results = new int[nums1.length];
        for(int i=0; i<nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){ //Following example
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        for(int i=0; i<nums1.length; i++){
            results[i] = map.get(nums1[i]);
        }
        return results;
    }
     */



    //Brute Force Time = O(m*n)
  /*  public int[] nextGreaterElement(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            map.put(nums2[i], i);
        }
        int[] results = new int[nums1.length];
        int n1 = nums1.length, n2 = nums2.length, j = 0;
        for(int i=0; i<n1; i++){
            for(j=map.get(nums1[i]); j<n2; j++){
                if(nums2[j] > nums1[i]){
                    results[i] = nums2[j];
                    break; //once find it, need to exit it
                }
            }
            if(j==n2){
                results[i] = -1;
            }
        }
        return results;
    }

   */

}

/*
   Stack
   | 1  |
   | 2  |
   | 3  |
   | 4  |
   | 5  |
   | 6  |
    ----

    Input
[1,3,5,2,4]
[6,5,4,3,2,1,7]
Output
[7,-1,-1,-1,-1]
Expected
[7,7,7,7,7]
*/
