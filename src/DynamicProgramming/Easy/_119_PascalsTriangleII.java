package DynamicProgramming.Easy;

import java.util.ArrayList;
import java.util.List;

public class _119_PascalsTriangleII {

    //Time = O(2^k)  Space = O(k)
    /*
      getNum(rowIndex, colIndex) = getNum(rowIndex-1, colIndex-1) + getNum(rowIndex-1, colIndex
    */
 /*   private int getNum(int row, int col) {
        if (row == 0 || col == 0 || row == col) {
            return 1;
        }

        return getNum(row - 1, col - 1) + getNum(row - 1, col);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            ans.add(getNum(rowIndex, i));
        }

        return ans;
    }
  */

    //Time = O(k^2)  Space = O(k^2)
    public List<Integer> getRow(int rowIndex) {
        List<Integer>[] dp = new ArrayList[rowIndex+1];
        dp[0] = new ArrayList<>();
        dp[0].add(1);
        if(rowIndex==0) return dp[0];
        for(int i=1; i<=rowIndex; i++){
            dp[i] = new ArrayList<>();
            dp[i].add(1);
            for(int j=1; j<dp[i-1].size(); j++){
                dp[i].add(dp[i-1].get(j-1) + dp[i-1].get(j));
            }
            dp[i].add(1);
        }
        return dp[rowIndex];
    }
}
