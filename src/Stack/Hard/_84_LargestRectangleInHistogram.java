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

/*
intuitive;
keep an increase stack
1) push an -1 into stack to avoid deal with edge case when stack is empty
2) iterate each element in the array, when currNum > stack.peek ===> push into stack
3) once find currNum < stack.peeek, we need pop element until the satisfy the
   condition (currNum > stack.peek)
   the currH = stack.pop, width = i-stack.peek.index-1
4) when hit the end of array, we need to check if the stack are empty.
   if not, repeat the step (3)

   0 1 2 3 4 5
  [2,1,5,6,2,3]
     |     |
  |
  |
  |  0  ht[stack.peek] >= ht[i] ==> pop.   currH = ht[stack.pop] = ht[0] = 2
  |_-1__                                   width = i-stack.peek-1 = 1-(-1)-1 = 1    area = 2

  |  3
  |  2    i = 4     6  >= 2
  |  1  ht[stack.peek] >= ht[i] ==> pop.   currH = ht[stack.pop] = ht[3] = 6
  |_-1__   width = i-stack.peek-1 = 4-2-1 = 1    maxArea = 6


  |  2    i = 4     5  >= 2
  |  1  ht[stack.peek] >= ht[i] ==> pop.   currH = ht[stack.pop] = ht[2] = 5
  |_-1__                                    width = i-stack.peek-1 = 4-2-1 = 2    area = 10

  |  5
  |  4    i = 6
  |  1  stack.peek != -1 ==> pop.   currH = ht[stack.pop] = ht[5] = 3
  |_-1__                                    width = i-stack.peek-1 = 6-4-1 = 1    area = 3


  |  4    i = 6
  |  1  stack.peek != -1 ==> pop.   currH = ht[stack.pop] = ht[4] = 2
  |_-1__                                    width = i-stack.peek-1 = 6-1-1 = 4   area = 8

  |      i = 6
  |  1  stack.peek != -1 ==> pop.   currH = ht[stack.pop] = ht[1] = 1
  |_-1__                                    width = i-stack.peek-1 = 6-(-1)-1 = 1   area = 6

   System.out.println(maxArea + " " + currH + " " + width);
    0 2 1
    2 6 1
    6 5 2
    10 3 1
    10 2 4
    10 1 6
  */
