package DynamicProgramming.Hard;

/**
 * Created by Shuhua Song
 */
public class _42_TrappingRainWater {
    //DP
    public int trap(int[] height) {
        if(height==null || height.length<=1) return 0;
        int n = height.length;
        int[] leftMax = new int[n], rightMax = new int[n];
        leftMax[0] = height[0]; rightMax[n-1] = height[n-1];
        for(int i=1; i<n; i++)
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        for(int i=n-2; i>=0; i--)
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        int res = 0;
        for(int i=0; i<n; i++){
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    /* Two Pointer
     public int trap(int[] height) {
         if(height==null || height.length<=1) return 0;
         int n = height.length;
         int peekIdx = -1;
         int maxVal = height[0];
         for(int i=1; i<n; i++){
             if(height[i] > maxVal){
                 peekIdx = i;
                 maxVal = height[i];
             }
         }
         int leftMostBar = 0, rightMostBar = 0;
         int res = 0;
         for(int i=0; i<peekIdx; i++){
             if(height[i] > leftMostBar){
                 leftMostBar = height[i];
             }else{
                 res += leftMostBar-height[i];
             }
         }
         for(int i=n-1; i>peekIdx; i--){
             if(height[i] > rightMostBar){
                 rightMostBar = height[i];
             }else{
                 res += rightMostBar-height[i];
             }
         }
        return res;
    }
     */
}

/*
Solution-1: Brute force==>TLE
iterate the array, and find leftMax and rightMax for each position.
but this will take O(n^2)

Solution-1: Dynamic Programming
1) find the maximum height of bar from left_end(0) upto current index i
2) find the maximum height of bar from right_end(n-1) upto index i
3) iterate over the height array and update res:
    res += min(leftMax[i], rightMax[i]) - height[i]

e.g.
heights = {0,1,0,2,1,0,1,3,2,1,2,1}
left    = {0 1 1 2 2 2 2 3 3 3 3 3}
right   = {3 3 3 3 3 3 3 3 2 2 2 1 } ==> Math.min(left[i], right[i]) - height[i]
water.  = {0 0 1 0 1 2 1 0 0 1 0 0 }


 */
