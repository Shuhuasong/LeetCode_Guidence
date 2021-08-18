package Stack.Hard;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _84_LargestRectangleInHistogram {

    //Time = O(n)
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0) return 0;
        int maxArea = 0, n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]){
                stack.push(i);
            }else{
                int right = i;
                int index = stack.pop();
                while(!stack.isEmpty() && heights[index] == heights[i]){
                    index = stack.pop();
                }
                int leftMost = (stack.isEmpty() ? -1 : stack.peek());
                maxArea = Math.max(maxArea, heights[index] *(right-leftMost-1));
                i--;
            }
        }
        int rightMost = stack.peek()+1;
        while(!stack.isEmpty()){
            int right = stack.pop();
            int left = (stack.isEmpty() ? -1 : stack.peek());
            maxArea = Math.max(maxArea, heights[right] *(rightMost-left-1));
        }
        return maxArea;
    }

}
