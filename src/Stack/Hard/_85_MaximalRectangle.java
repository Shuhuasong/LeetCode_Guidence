package Stack.Hard;

import java.util.Stack;

/**
 * Created by Shuhua Song
 */
public class _85_MaximalRectangle {
    // Get the maximum area in a histogram given its heights
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int maxArea = 0;
        int[] dp = new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[j] = (matrix[i][j]=='1' ? dp[j]+1 : 0);
            }
            for(int a : dp){
                System.out.print(a + "  ");
            }
            System.out.println();
            maxArea = Math.max(maxArea, getMaxRect(dp));
        }
        return maxArea;
    }

    private int getMaxRect(int[] dp){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int n = dp.length, maxArea = 0;
        for(int i=0; i<dp.length; i++){
            while(stack.peek()!=-1 && dp[i] <= dp[stack.peek()]){
                int index = stack.pop();
                maxArea = Math.max(maxArea, dp[index]*(i-stack.peek()-1));
                System.out.println(i + " -- " + stack.peek() + " --" + dp[index] + "==" + maxArea);
            }
            stack.push(i);
        }

        while(stack.peek() != -1){
            int idx = stack.pop();
            maxArea = Math.max(maxArea, dp[idx]*(n-stack.peek()-1));
            System.out.println(idx + " --**--  " + stack.peek() + " --**--" + dp[idx] + "==" + maxArea);
        }
        return maxArea;
    }
}
