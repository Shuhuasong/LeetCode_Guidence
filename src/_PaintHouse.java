public class _PaintHouse {
    public int minCost(int[][] costs) {
        // write your code here
        int n = costs.length;
        if(n==0) return 0;

        int[][] dp = new int[2][3];

        int old = 0, now = 0;
        dp[now][0] = dp[now][1] = dp[now][2] = 0;

        for(int i=1; i<=n; i++){
            old = now;
            System.out.print( " now1 = " + now);
            now = 1-now;

            for(int j=0; j<3; j++){
                dp[now][j] = Integer.MAX_VALUE;
                for(int k=0; k<3; k++){
                    if(j!=k){
                        System.out.print( " now2 = " + now);
                        dp[now][j] = Math.min(dp[now][j], dp[old][k] + costs[i-1][j]);
                    }
                }
            }

            for(int x=0; x<2; x++){
                for(int y=0; y<3; y++){
                    System.out.print(dp[x][y] + " ");
                }
                System.out.println();
            }
        }
        int result = dp[now][0];
        if(dp[now][1] < result){
            result = dp[now][1];
        }
        if(dp[now][2] < result){
            result = dp[now][2];
        }
        return result;
    }
}
