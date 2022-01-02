package Stack.Hard;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _84_LargestRectangleInHistogram {

    //Time = O(n), Space = O(n)
    public int largestRectangleArea(int[] ht) {
        int n = ht.length;
        int maxArea = 0, width = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0; i<n; i++){
            //once the elem <= top, we pop the elem from stack, and calculate area
            while(stack.peek()!=-1 && ht[stack.peek()] >= ht[i]){
                int currH = ht[stack.pop()];
                width = i-stack.peek()-1;
                maxArea = Math.max(maxArea, currH*width);
            }
            //keep push the index when elem is increasing
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int currH = ht[stack.pop()];
            width = n - stack.peek()-1;
            maxArea = Math.max(maxArea, currH*width);
        }
        return maxArea;
    }
    /*
      //Time = O(n^2) TLE
    public int largestRectangleArea(int[] ht) {
        int n = ht.length;
        int maxArea = 0, width = 0;
        for(int i=0; i<n; i++){
            int minH = ht[i];
            for(int j=i; j<n; j++){
                minH = Math.min(minH, ht[j]);
                width = j-i+ 1;
                maxArea = Math.max(maxArea, minH*width);
            }
        }
        return maxArea;
    }
     */

}
