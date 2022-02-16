package Prefix_Sum.Easy;

/**
 * Created by Shuhua Song
 */
public class _643_MaximumAverageSubarrayI {
    //Time = O(n), Space = O(n)
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if(n < k) return 0;

        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for(int i=1; i<n; i++){
            preSum[i] = preSum[i-1] + nums[i];
        }
        for(int p : preSum){
            // System.out.print(p + " ");
        }
        double maxAvg = preSum[k-1]*1.0/k;
        for(int i=k; i<n; i++){
            maxAvg = Math.max(maxAvg, (preSum[i]-preSum[i-k])*1.0/k);
        }
        return maxAvg;
    }
}
