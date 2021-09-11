package OnlineCodingChallege.Citadel;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Shuhua Song
 */
public class _PortfolioBalance {
    //pass all cases
    private static long maxValue(int n, int[][] rounds){
        if(n<=0 || rounds==null) return 0;
        long[] invests = new long[n+1];
        Arrays.fill(invests, 0);
        for(int[] r : rounds){
            int left = r[0], right= r[1];
            long val = (long)r[2];
            invests[left] += val;
            if(right < n){
                invests[right+1] -= val;
            }
        }
        long result = invests[0];
        for(int i=2; i<n+1; i++){
            invests[i] += invests[i-1];
            result = Math.max(invests[i], result);
        }
        return result;
    }

    //Can't pass all cases
   /* private static int maxValue(int[][] rounds, int k){
        // k = number of assets
        int[] asset = new int[k+1];
        for(int[] r : rounds){
            for(int i=r[0]; i<=r[1]; i++){
                asset[i] += r[2];
            }
        }
        int res = 0;
        for(int a : asset){
            System.out.print(a + " ");
            res = Math.max(res, a);
        }
        return res;
    } */

    public static void main(String[] args) {
         int[][] rounds = { {1, 2, 10},
                            {2, 4, 5},
                            {3, 5, 12}};
         int k = 5;
        System.out.println(maxValue(k, rounds));
    }
}
