package OnlineCodingChallege.Google;

/**
 * Created by Shuhua Song
 */
public class _CopyBooks_ {

    public static int copyBook(int[] pages, int k){
        if(pages.length==0){
            return 0;
        }
        int total = 0, n = pages.length;
        int max = pages[0];
        for(int i=0; i<n; i++){
            total += pages[i];
            max = Math.max(max, pages[i]);
        }
        int start = max, end = total;
        while(start+1 < end){
            int mid = (end-start)/2 + start;
            if(countPerson(pages, mid) > k){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(countPerson(pages, start) <= k){
            return start;
        }
        return end;
    }

    private static int countPerson(int[] pages, int limit){
        if(pages.length==0) return 0;
        int person = 1;
        int sum = pages[0];
        for(int i=1; i<pages.length; i++){
            if(sum + pages[i] > limit){
                person++;
                sum = 0;
            }
            sum += pages[i];
        }
        return person;
    }

    /* dp

    public static int copyBook(int[] pages, int k){
        int n = pages.length;
        //dp[i][j] ; the minimum time to copy the first j books by i the person
        int[][] dp = new int[k+1][n];
        int[] preSum = new int[n];
        for(int i=0; i<=k; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
         k = Math.min(n, k);
         for(int i=1; i<n; i++){
             preSum[i] += preSum[i-1];
         }
         for(int i=1; i<=k; i++){
             for(int j=0; j<n; j++){
                 if(i==1 || j==0){
                     dp[i][j] = pages[j];
                 }else{
                     for(int r=j-1; r>=0; r--){
                         int curMax = Math.max(dp[i-1][r], preSum[j]-preSum[r]);
                         System.out.println(dp[i-1][r] + " " + (preSum[j]-preSum[r]) + " " + j + " " + r);
                         dp[i][j] = Math.min(dp[i][j], curMax);
                     }
                 }
             }
         }
         for(int i=0; i<=k; i++){
             for(int j=0; j<n; j++){
                // System.out.print(dp[i][j] + " ");
             }
             System.out.println();
         }
         return dp[k][n-1];
    }

     */

    //recursion: Time = O(k*2^n)
    //Space = O(
 /*   public static int copyBook(int[] pages, int k){
        if(k > pages.length){
            k = pages.length;
        }
        int n = pages.length;
        return partition(pages, n, k);
    }

    private static int partition(int[] pages, int n, int k){
        if(k==0){
            return sum(pages, 0, n-1);
        }
        if(n==1){
            return pages[0];
        }
        int best = Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            best = Math.min(best, Math.max(sum(pages, i, n-1), partition(pages, i, k-1)));
        }
        return best;
    }

    private static int sum(int[] pages, int start, int end){
        int total = 0;
        for(int i=start; i<=end; i++){
            total += pages[i];
        }
        return total;
    } */

    public static void main(String[] args) {
        int[] pages = {3, 2, 4};
        copyBook(pages, 2);
    }
}
